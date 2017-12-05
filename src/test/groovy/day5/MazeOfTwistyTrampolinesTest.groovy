package day5

import spock.lang.Specification

class MazeOfTwistyTrampolinesTest extends Specification {

    def exampleTest() {
        expect:
        MazeOfTwistyTrampolines.calculate(input) == result

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
        MazeOfTwistyTrampolines.calculate(input) == 343467
    }

}
