package day13

import spock.lang.Specification

class PacketSendersTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day13/input.txt').eachLine { line ->
            input << (line)
        }
    }

    def finalTestPart1() {
        expect:
        PacketScanners.calculateSeverity(input) == 1900
    }

    def finalTestPart2() {
        expect:
        PacketScanners.calculateMinimalDelay(input) == 3966414
    }
}
