package day2

class EvenlyDivisibleChecksum {

    def static calculate(List<List<Integer>> input) {
        input.collect(this.&evenDivision).sum()
    }

    def static evenDivision(List<Integer> list) {
        ([list.sort().withIndex()] * 2)
                .combinations()
                .collectMany { x1, x2 -> x1[1] > x2[1] && x1[0] % x2[0] == 0 ? [x1[0] / x2[0]] : [] }
                .get(0)
    }

}
