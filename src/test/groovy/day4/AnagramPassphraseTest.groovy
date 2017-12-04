package day4

import spock.lang.Specification

class AnagramPassphraseTest extends Specification {

    def testPassphraseValid() {
        expect:
        AnagramPassphrase.isValid(input) == result

        where:
        input                      | result
        "abcde fghij"              | true
        "abcde xyz ecdab"          | false
        "oiii ioii iioi iiio"      | false
        "iiii oiii ooii oooi oooo" | true
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day4/input.txt').eachLine { line ->
            input << line
        }

        expect:
        AnagramPassphrase.howManyValid(input) == 119
    }

}