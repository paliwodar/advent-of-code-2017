package day4

import spock.lang.Specification

class HighEntropyPassphraseTest extends Specification {

    def testPassphraseValid() {
        expect:
        HighEntropyPassphrase.isValid(input) == result

        where:
        input             | result
        "aa bb cc dd ee"  | true
        "aa bb cc dd aa"  | false
        "aa bb cc dd aaa" | true
    }

    def testHowMany() {
        expect:
        HighEntropyPassphrase.howManyValid(input) == result

        where:
        input               | result
        ["aa bb cc dd ee",
         "aa bb cc dd aa",
         "aa bb cc dd aaa"] | 2
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day4/input.txt').eachLine { line ->
            input << line
        }

        expect:
        HighEntropyPassphrase.howManyValid(input) == 325
    }
}
