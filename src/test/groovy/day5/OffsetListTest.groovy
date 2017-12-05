package day5

import spock.lang.Specification

class OffsetListTest extends Specification {

    def exampleTest() {
        expect:
        OffsetList.calculate(input) == result

        where:
        input            | result
        [0, 3, 0, 1, -3] | 5
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day5/input.txt').eachLine { line ->
            input << (line as Integer)
        }

        expect:
        OffsetList.calculate(input) == 343467
    }

}
