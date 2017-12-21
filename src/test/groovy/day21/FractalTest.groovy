package day21

import spock.lang.Specification

class FractalTest extends Specification {

    def "fromString should build proper 2x2 fractal"() {
        expect:
        Fractal.fromString("##/..").matrix == ["##", ".."]
    }

    def "fromString should build proper 3x3 fractal"() {
        expect:
        Fractal.fromString(".#./..#/###").matrix == [".#.", "..#", "###"]
    }

    def "toString should join rows using separator"() {
        expect:
        new Fractal([".#.", "..#", "###"]).toString() == ".#./..#/###"
    }

    def "equals should return true for Fractals with same matrices"() {
        expect:
        new Fractal([".#", ".."]) == new Fractal([".#", ".."])
    }

    def "equals should return false for Fractals with different matrices"() {
        expect:
        new Fractal(["..", "##"]) != new Fractal(["##", ".."])
    }

    def "split should return same matrix if the size is 2"() {
        expect:
        new Fractal([".#", ".."]).splitIntoSubfractals() == [new Fractal([".#", ".."])]
    }

    def "split should return same matrix if the size is 3"() {
        expect:
        new Fractal(["...", "###", ".#."]).splitIntoSubfractals() == [new Fractal(["...", "###", ".#."])]
    }

    def "split for 4x4 matrix should return 4 2x2 matrices"() {
        expect:
        new Fractal(["#..#", "....", "....", "#..#"]).splitIntoSubfractals() ==
                ["#./..", ".#/..", "../#.", "../.#"].collect { Fractal.fromString(it) }
    }

    def "splitAll for 4x4 matrix should return 4 2x2 matrices"() {
        expect:
        new Fractal(["#..#", "....", "....", "#..#"]).splitIntoSubfractals() ==
                ["#./..", ".#/..", "../#.", "../.#"].collect { Fractal.fromString(it) }
    }

    def "rotate90 rotates a 2x2 fractal by 90 degrees"() {
        expect:
        new Fractal(["12", "34"]).rotate90() == new Fractal(["31", "42"])
        new Fractal(["31", "42"]).rotate90() == new Fractal(["43", "21"])
        new Fractal(["43", "21"]).rotate90() == new Fractal(["24", "13"])
        new Fractal(["24", "13"]).rotate90() == new Fractal(["12", "34"])
    }

    def "rotate90 rotates a 3x3 fractal by 90 degrees"() {
        expect:
        new Fractal(["123", "456", "789"]).rotate90() == new Fractal(["741", "852", "963"])
    }

    def "flip flips the fractal correctly"() {
        expect:
        new Fractal(["12", "34"]).flipVertically() == new Fractal(["34", "12"])
        new Fractal(["12", "34"]).flipHorizontally() == new Fractal(["21", "43"])
    }

    def "getRotatedOrFlipped 2x2 matrix returns all results"() {
        expect:
        new Fractal(["12", "34"]).getRotatedOrFlipped() as Set ==
                [new Fractal(["12", "34"]),
                 new Fractal(["31", "42"]),
                 new Fractal(["43", "21"]),
                 new Fractal(["24", "13"]),
                 new Fractal(["34", "12"]),
                 new Fractal(["21", "43"]),
                 new Fractal(["13", "24"]),
                 new Fractal(["42", "31"])] as Set
    }

    def "getRotatedOrFlipped 3x3 marix returns 8 results"() {
        expect:
        new Fractal(["123", "456", "789"]).getRotatedOrFlipped().size() == 8
    }

}
