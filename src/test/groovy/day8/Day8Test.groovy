package day8

import spock.lang.Specification

class Day8Test extends Specification {

    def test() {
        expect:
        Day8.calculate(input) == result

        where:
        input                    | result
        ["b inc 5 if a > 1",
         "a inc 1 if b < 5",
         "c dec -10 if a >= 1",
         "c inc -20 if c == 10"] | 10
    }

    def test2() {
        expect:
        Day8.calculate(input) == result

        where:
        input                      | result
        ["aj dec -520 if icd < 9"] | 520
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day8/input.txt').eachLine { line ->
            input << (line)
        }

        expect:
        Day8.calculate(input) == 7310
    }
}
