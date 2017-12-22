package day12

class DigitalPlumber {

    Map<String, List<String>> programs

    DigitalPlumber(List<String> input) {
        programs = readPrograms(input)
    }

    int countGroups() {
        Set<String> allProcessed = []
        int numberOfGroups = 0

        programs.keySet().each {
            if (!allProcessed.contains(it)) {
                allProcessed.addAll(getProgramsConnectedWith(it))
                numberOfGroups++
            }
        }
        return numberOfGroups
    }

    Set<String> getProgramsConnectedWith(String from, Set<String> visited = []) {
        if (visited.contains(from)) {
            return visited
        }
        return programs.getOrDefault(from, [])
                       .collectMany { getProgramsConnectedWith(it, visited + from) }
    }

    Map<String, List<String>> readPrograms(List<String> lines) {
        lines.collectEntries {
            def match = (it =~ /([0-9]*) <-> (.*)/)[0]
            [(match[1]): match[2].split(", ")]
        }
    }
}
