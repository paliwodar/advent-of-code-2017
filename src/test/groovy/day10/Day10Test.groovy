package day10

import spock.lang.Ignore
import spock.lang.Specification

class Day10Test extends Specification {

    @Ignore
    def testExamples() {
        expect:
        Day10.calculate(5, [3, 4, 1, 5]) == 12
    }

    @Ignore
    def finalTest() {
        expect:
        Day10.calculate(256, input) == result

        where:
        input                                                                | result
        [165, 1, 255, 31, 87, 52, 24, 113, 0, 91, 148, 254, 158, 2, 73, 153] | 0
    }

    def finalTestPart2() {
        expect:
        Day10.calculate(256, "165,1,255,31,87,52,24,113,0,91,148,254,158,2,73,153") == "2f8c3d2100fdd57cec130d928b0fd2dd"
    }

    def testExample1Part2() {
        expect:
        Day10.calculate(256, "AoC 2017") == "33efeb34ea91902bb2f59c9920caa6cd"
    }

    def testExample2Part2() {
        expect:
        Day10.calculate(256, "") == "a2582a3a0e66e6e86e3812dcb672a272"
    }
}
