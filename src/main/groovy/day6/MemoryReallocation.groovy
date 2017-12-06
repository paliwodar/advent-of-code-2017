package day6

class MemoryReallocation {

    static def calculate(List<Integer> input) {
        def seenInputs = [] as Set
        def steps = 0

        while (true) {
            steps++
            seenInputs.add(input)
            int index = input.findIndexOf { it == input.max()}
            input = redistribute(input, index)

            if (seenInputs.contains(input)) {
                return steps
            }
        }
    }

    def static redistribute(list, startingIndex) {
        def copy = new ArrayList(list)
        def n = copy[startingIndex]
        copy[startingIndex] = 0
        for (int j = startingIndex + 1; n > 0; n--) {
            copy[j++ % list.size()]++
        }
        copy
    }
}
