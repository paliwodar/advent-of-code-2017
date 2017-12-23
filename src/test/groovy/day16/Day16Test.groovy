package day16

import spock.lang.Specification

class Day16Test extends Specification {

    String input

    def setup() {
        new File('src/test/resources/day16/input.txt').eachLine { line ->
            input = line
        }
    }

    def "example test case"() {
        given:
        def day16 = new Day16("s1,x3/4,pe/b", 5)

        when:
        day16.dance()

        then:
        day16.programs.join("") == "baedc"
    }

    def "example test case 2"() {
        given:
        def day16 = new Day16("s11,x13/14,pe/b")

        when:
        day16.dance()

        then:
        day16.programs.join("") == "fghijklmnopaedcb"

    }

    def "final test part 1"() {
        given:
        def day16 = new Day16(input)

        when:
        day16.dance()

        then:
        day16.programs.join("") == "dcmlhejnifpokgba"
    }

    def "final test part 2"() {
        given:
        def day16 = new Day16(input)
        def cycleSize = 1000000000g % 24

        when:
        (1..cycleSize).each {
            day16.dance()
        }
        then:
        day16.programs.join("") == "ifocbejpdnklamhg"
    }

}
