package day19

import spock.lang.Specification

class SeriesOfTubesTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day19/input.txt').eachLine { line ->
            input << (line)
        }
    }

    def testExample() {
        given:
        List<String> input =
                ["     |          ",
                 "     |  +--+    ",
                 "     A  |  C    ",
                 " F---|----E|--+ ",
                 "     |  |  |  D ",
                 "     +B-+  +--+ "]
        expect:
        SeriesOfTubes.calc(input).first == "ABCDEF"
    }

    def finalTestPart1() {
        expect:
        SeriesOfTubes.calc(input).first == "MOABEUCWQS"
    }

    def finalTestPart2() {
        expect:
        SeriesOfTubes.calc(input).second == 18058
    }

}
