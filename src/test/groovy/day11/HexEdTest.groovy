package day11

import spock.lang.Specification
import spock.lang.Unroll

class HexEdTest extends Specification {

    @Unroll
    def testScore() {
        expect:
        HexEd.calculate(input) == result

        where:
        input            | result
        "ne,ne,ne"       | 3
        "ne,ne,sw,sw"    | 2
        "ne,ne,s,s"      | 2
        "se,sw,se,sw,sw" | 3
        "n,n,n,n"        | 4
        "n,s"            | 1
        "ne,s"           | 1
        "s,s,ne,se"      | 3
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day11/input.txt').eachLine { line ->
            input << (line)
        }

        expect:
        HexEd.calculate(input[0]) == 1524
    }
}
