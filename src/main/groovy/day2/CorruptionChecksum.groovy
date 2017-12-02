package day2

class CorruptionChecksum {

    static calculate(List<List<Integer>> input) {
        input.collect { it.max() - it.min() }.sum()
    }


}
