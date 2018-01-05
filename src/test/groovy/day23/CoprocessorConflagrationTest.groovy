package day23

import spock.lang.Specification
import spock.lang.Unroll

class CoprocessorConflagrationTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day23/input.txt').eachLine { line ->
            input << (line)
        }
    }

    @Unroll
    def finaltest() {
        expect:
        CoprocessorConflagration.calculate(input) == 6724
    }

}
