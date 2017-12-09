package day10

import day9.StreamProcessing
import spock.lang.Specification
import spock.lang.Unroll

class Day10Test extends Specification {

    @Unroll
    def testExamples() {
        expect:
        StreamProcessing.calculate(input) == result

        where:
        input  | result
        "row1" | 0
        "row2" | 0
    }

    @Unroll
    def testExamples2() {
        expect:
        StreamProcessing.calculate(input) == result

        where:
        input    | result
        ["row1"] | 0
        ["row2"] | 0
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day9/input.txt').eachLine { line ->
            input << (line)
        }

        expect:
        StreamProcessing.calculate(input[0]) == 0
    }
}
