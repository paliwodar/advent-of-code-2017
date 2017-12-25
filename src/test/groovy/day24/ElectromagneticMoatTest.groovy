package day24

import spock.lang.Specification

class ElectromagneticMoatTest extends Specification {

    List<String> input = []

    def setup() {
        new File('src/test/resources/day24/input.txt').eachLine { line ->
            input << (line)
        }
    }

    def "example test"() {
        expect:
        ElectromagneticMoat.calcStrongest(0, ["0/2", "2/2", "2/3", "3/4", "3/5", "0/1", "1/1", "10/1", "9/10"]).toString() ==
                "[[0, 1], [1, 1], [10, 1], [9, 10]]"
    }

    def "example test part 2"() {
        expect:
        ElectromagneticMoat.calcLongest(0, ["0/2", "2/2", "2/3", "3/4", "3/5", "0/1", "10/1", "9/10"]).toString() ==
                "[[0, 2], [2, 2], [2, 3], [3, 5]]"
    }

    def "example test part 3"() {
        expect:
        ElectromagneticMoat.calcLongest(0, ["0/2", "2/2", "2/2"]).toString() == "[[0, 2], [2, 2], [2, 2]]"
    }

    def "final test"() {
        expect:
        ElectromagneticMoat.calcStrongest(0, input).collect { p -> p.first + p.second }.sum() == 1868
    }

    def "final test part 2"() {
        expect:
        ElectromagneticMoat.calcLongest(0, input).collect { p -> p.first + p.second }.sum() == 1841
    }
}
