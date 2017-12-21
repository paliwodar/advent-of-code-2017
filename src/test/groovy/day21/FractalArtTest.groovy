package day21

import spock.lang.Ignore
import spock.lang.Specification

class FractalArtTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day21/input.txt').eachLine { line ->
            input << (line)
        }
    }

    def "process rule should split line on =>"() {
        expect:
        FractalArt.processRule("##/## => #.#/.../#..") == new Tuple2("##/##", "#.#/.../#..")
        FractalArt.processRule(".#./.../... => .#../####/..##/#...") == new Tuple2(".#./.../...", ".#../####/..##/#...")
    }

    def "enhance test"() {
        expect:
        FractalArt.enhance(Fractal.fromString("##/.."), [new Tuple2("##/..", "../..")]) == Fractal.fromString("../..")
    }

    def "enhance after rotating test"() {
        expect:
        FractalArt.enhance(Fractal.fromString("##/.."), [new Tuple2(".#/.#", "../..")]) == Fractal.fromString("../..")
    }

    def "enhance after flipping test"() {
        expect:
        FractalArt.enhance(Fractal.fromString("##/.."), [new Tuple2("../##", "../..")]) == Fractal.fromString("../..")
    }

    def "final test part 1"() {
        expect:
        FractalArt.iterate(input, Fractal.fromString(".#./..#/###"), 5) == 164
    }

    @Ignore("takes some time")
    def "final test part 2"() {
        expect:
        FractalArt.iterate(input, Fractal.fromString(".#./..#/###"), 18) == 2355110
    }

    def "mergeFractals test"() {
        expect:
        FractalArt.mergeFractals(["#./..", ".#/..", "../#.", "../.#"].collect { Fractal.fromString(it) }) ==
                Fractal.fromString("#..#/..../..../#..#")

    }

    def "util test"() {
        expect:
        new Fractal([""]* 4).matrix == ["","","",""]
    }
}
