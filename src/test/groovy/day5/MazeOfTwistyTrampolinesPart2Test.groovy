package day5

import spock.lang.Specification

class MazeOfTwistyTrampolinesPart2Test extends Specification {

    def exampleTest() {
        expect:
        MazeOfTwistyTrampolinesPart2.calculate(input) == result

        where:
        input            | result
        [0, 3, 0, 1, -3] | 10
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day5/input.txt').eachLine { line ->
            input << (line as Integer)
        }

        expect:
        MazeOfTwistyTrampolinesPart2.calculate(input) == 24774780
    }

}
