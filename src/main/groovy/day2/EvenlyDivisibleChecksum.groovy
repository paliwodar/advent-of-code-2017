package day2

class EvenlyDivisibleChecksum {

    def static calculate(List<List<Integer>> input) {
        input.collect(this.&evenDivision).sum()
    }

    def static evenDivision(List<Integer> list) {
        [list, list].combinations()
                    .findAll { it[0] % it[1] == 0}
                    .collect { it[0] / it[1]}
                    .max()
    }

}
