package day24

class ElectromagneticMoat {

    def static readAll(List<String> input) {
        input.collect {
            def strings = it.split("/")
            new Tuple2<>(strings[0] as Integer, strings[1] as Integer)
        }
    }

    static List<List<Tuple2<Integer, Integer>>> calcStrongest(start, List<String> input) {
        bridge(start, readAll(input), { x -> x.collect { p -> p.first + p.second }.sum(0) })
    }

    static List<List<Tuple2<Integer, Integer>>> calcLongest(start, List<String> input) {
        bridge(start, readAll(input), { x -> x.size() * 1000 + x.collect { p -> p.first + p.second }.sum(0) })
    }

    static List<Tuple2<Integer, Integer>> bridge(int startingPort, List<Tuple2<Integer, Integer>> components, Closure maxClosure) {
        List<List<Tuple2<Integer, Integer>>> matchings = components.indexed().collect {
            int index, Tuple2<Integer, Integer> component ->
                if (startingPort in component) {
                    [component] + bridge(component.first == startingPort ? component.second : component.first,
                                         components.take(index) + components.drop(index + 1),
                                         maxClosure)
                } else {
                    []
                }
        }
        return matchings.isEmpty() ? [] : matchings.max(maxClosure)
    }

}
