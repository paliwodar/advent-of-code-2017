package day18

import spock.lang.Specification
import spock.lang.Unroll


class DuetTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day18/input.txt').eachLine { line ->
            input << (line)
        }
    }

    @Unroll
    def testScore() {
        expect:
        new Duet().calculate(input) == result2

        where:
        input        | result2
        ["set a 1",
         "add a 2",
         "mul a a",
         "mod a 5",
         "snd a",
         "set a 0",
         "rcv a",
         "jgz a -1",
         "set a 1",
         "jgz a -2"] | 4
    }

    @Unroll
    def finaltest() {
        expect:
        new Duet().calculate(input) == 7071
    }

}
