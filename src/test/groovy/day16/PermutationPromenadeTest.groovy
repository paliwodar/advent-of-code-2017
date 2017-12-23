package day16

import spock.lang.Specification

class PermutationPromenadeTest extends Specification {

    String input

    def setup() {
        new File('src/test/resources/day16/input.txt').eachLine { line ->
            input = line
        }
    }

    def "example test case"() {
        given:
        def permutationPromenade = new PermutationPromenade("s1,x3/4,pe/b", 5)

        when:
        permutationPromenade.dance()

        then:
        permutationPromenade.programs.join("") == "baedc"
    }

    def "example test case 2"() {
        given:
        def permutationPromenade = new PermutationPromenade("s11,x13/14,pe/b")

        when:
        permutationPromenade.dance()

        then:
        permutationPromenade.programs.join("") == "fghijklmnopaedcb"

    }

    def "final test part 1"() {
        given:
        def permutationPromenade = new PermutationPromenade(input)

        when:
        permutationPromenade.dance()

        then:
        permutationPromenade.programs.join("") == "dcmlhejnifpokgba"
    }

    def "final test part 2"() {
        given:
        def permutationPromenade = new PermutationPromenade(input)
        def cycleSize = 1000000000g % 24

        when:
        (1..cycleSize).each {
            permutationPromenade.dance()
        }
        then:
        permutationPromenade.programs.join("") == "ifocbejpdnklamhg"
    }

}
