package day14

import spock.lang.Specification
import spock.lang.Unroll

import static DiskDefragmentation.calculateOnes
import static DiskDefragmentation.countGroups

class DiskDefragmentationTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day14/input.txt').eachLine { line ->
            input << (line)
        }
    }

    @Unroll
    def testScore() {
        expect:
        calculateOnes(input) == result2

        where:
        input      | result2
        "ugkiagan" | 8292
    }

    @Unroll
    def testScore2() {
        expect:
        countGroups("ugkiagan") == 1069

    }

    @Unroll
    def testScore2example() {
        expect:
        countGroups("flqrgnkx") == 1242
    }

}
