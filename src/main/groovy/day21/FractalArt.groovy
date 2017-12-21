package day21

class FractalArt {

    static iterate(List<String> rulesStrings, Fractal initFractal, int n) {

        List<Tuple2<String, String>> rules = rulesStrings.collect { processRule(it) }
        Fractal currentFractal = initFractal

        (1..n).each {
            List<Fractal> splittedAndEnhanced = currentFractal.splitIntoSubfractals()
                                                              .collect { Fractal f -> enhance(f, rules) }
            currentFractal = mergeFractals(splittedAndEnhanced)
        }
        return currentFractal.matrix.join().count("#")
    }

    static Fractal mergeFractals(List<Fractal> fractals) {
        int fractalsPerRow = Math.sqrt(fractals.size())
        int fractalSize = fractals[0].matrix.size()
        List<String> result = []

        for (int i = 0; fractalsPerRow * i < fractals.size(); i++) {
            Fractal rowFractal = new Fractal([""] * fractalSize)
            for (int j = 0; j < fractalsPerRow; j++) {
                rowFractal = rowFractal.joinRows(fractals[i * fractalsPerRow + j])
            }
            result += rowFractal.matrix
        }
        return new Fractal(result)
    }

    static Tuple2<String, String> processRule(String s) {
        def matcher = s =~ /([.#\/]*) => ([.#\/]*)/
        return new Tuple2<String, String>(matcher[0][1], matcher[0][2])
    }

    static Fractal enhance(Fractal fractal, List<Tuple2<String, String>> rules) {
        List<String> matchingRules = []

        for (Fractal rotated : fractal.getRotatedOrFlipped()) {
            for (Tuple2<String, String> rule : rules) {
                if (rotated.toString() == rule.first) {
                    matchingRules.add(rule.second)
                }
            }
        }

        if (matchingRules.size() > 1) {
            throw new IllegalStateException("More than one rule applies")
        } else if (matchingRules.size() == 1) {
            return Fractal.fromString(matchingRules[0])
        } else {
            throw new IllegalStateException("No rules apply")
        }
    }

}


