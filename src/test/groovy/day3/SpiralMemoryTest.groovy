package day3

import spock.lang.Specification
import spock.lang.Unroll

class SpiralMemoryTest extends Specification {

    @Unroll
    def shouldWorkForExampleCases() {
        expect:
        SpiralMemory.calculateManhattanDistance(inputNumber) == expectedResult

        where:
        inputNumber || expectedResult
        1           || 0
        12          || 3
        23          || 2
        1024        || 31
    }

    def shouldWorkFor2() {
        expect:
        SpiralMemory.calculateManhattanDistance(inputNumber) == expectedResult

        where:
        inputNumber || expectedResult
        2           || 1
    }

    def shouldWorkFor12() {
        expect:
        SpiralMemory.calculateManhattanDistance(inputNumber) == expectedResult

        where:
        inputNumber || expectedResult
        12          || 3
    }

    @Unroll
    def shouldWorkForMoreCases() {
        expect:
        SpiralMemory.calculateManhattanDistance(inputNumber) == expectedResult

        where:
        inputNumber || expectedResult
        1           || 0
        2           || 1
        3           || 2
        4           || 1
        5           || 2
        6           || 1
        7           || 2
        8           || 1
        9           || 2
        10          || 3
        11          || 2
        12          || 3
        13          || 4
    }

    def finalTest() {
        expect:
        SpiralMemory.calculateManhattanDistance(inputNumber) == expectedResult

        where:
        inputNumber || expectedResult
        361527      || 326
    }


}
