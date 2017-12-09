package day9

import spock.lang.Specification
import spock.lang.Unroll

class StreamProcessingTest extends Specification {

    @Unroll
    def testScore() {
        expect:
        StreamProcessing.calculate(input).first == result

        where:
        input                           | result
        "{{<!!>},{<!!>},{<!!>},{<!!>}}" | 9
        "{{<ab>},{<ab>},{<ab>},{<ab>}}" | 9
        "{<{},{},{{}}>}"                | 1
        "{{<a!>},{<a!>},{<a!>},{<ab>}}" | 3
        "{{{},{},{{}}}}"                | 16
        "{<a!>,<a>,{}}"                 | 3
        "{<a!>,{<a}>,{}}"               | 3
    }

    @Unroll
    def testGarbageSize() {
        expect:
        StreamProcessing.calculate(input).second == result

        where:
        input                           | result
        "{{<!!>},{<!!>},{<!!>},{<!!>}}" | 0
        "{{<ab>},{<ab>},{<ab>},{<ab>}}" | 8
        "{<{},{},{{}}>}"                | 10
        "{{<a!>},{<a!>},{<a!>},{<ab>}}" | 17
        "{{{},{},{{}}}}"                | 0
        "{<a!>,<a>,{}}"                 | 4
        "{<a!>,{<a}>,{}}"               | 6
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day9/input.txt').eachLine { line ->
            input << (line)
        }

        expect:
        StreamProcessing.calculate(input[0]).first == 17390
        StreamProcessing.calculate(input[0]).second == 7825
    }
}
