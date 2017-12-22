package day12

import spock.lang.Specification

class DigitalPlumberTest extends Specification {

    def input = []

    def setup() {

        new File('src/test/resources/day12/input.txt').eachLine { line ->
            input << (line)
        }
    }

    def "test count groups"() {
        expect:
        new DigitalPlumber(input).countGroups() == result

        where:
        input          | result
        ["0 <-> 2",
         "1 <-> 1",
         "2 <-> 0, 3, 4",
         "3 <-> 2, 4",
         "4 <-> 2, 3, 6",
         "5 <-> 6",
         "6 <-> 4, 5"] | 2
    }

    def "test count groups 2"() {
        expect:
        new DigitalPlumber(input).countGroups() == result

        where:
        input       | result
        ["1 <-> 2",
         "2 <-> 1, 3",
         "3 <-> 2",
         "4 <-> 5",
         "5 <-> 4",
         "6 <-> 6"] | 3
    }

    def "test count groups 3"() {
        expect:
        new DigitalPlumber(input).countGroups() == result

        where:
        input       | result
        ["1 <-> 2",
         "2 <-> 1",
         "6 <-> 0",
         "0 <-> 6"] | 2
    }

    def "final test part 1"() {
        expect:
        new DigitalPlumber(input).getProgramsConnectedWith("0").size() == 134
    }

    def "final test part 2"() {
        expect:
        new DigitalPlumber(input).countGroups() == 193
    }
}
