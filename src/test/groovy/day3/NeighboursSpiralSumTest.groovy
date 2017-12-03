package day3

import spock.lang.Specification
import spock.lang.Unroll

class NeighboursSpiralSumTest extends Specification {

    @Unroll
    def shouldWorkForExampleCases() {
        expect:
        NeighboursSpiralSum.calculateSum(inputNumber) == expectedResult

        where:
        inputNumber || expectedResult
        1           || 1
        2           || 1
        3           || 2
        4           || 4
        5           || 5
        6           || 10
    }
}
