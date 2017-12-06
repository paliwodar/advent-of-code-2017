package day6

import spock.lang.Specification
import spock.lang.Unroll

class MemoryReallocationTest extends Specification {

    @Unroll
    def testExample() {
        expect:
        MemoryReallocation.calculate([0, 2, 7, 0]) == 5
    }

    @Unroll
    def finalTest() {
        expect:
        MemoryReallocation.calculate([0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11]) == 7864
    }

    @Unroll
    def finalTestPart2() {
        expect:
        MemoryReallocation.calculate([10, 9, 8, 7, 6, 5, 4, 3, 1, 1, 0, 15, 14, 13, 11, 12]) == 1695
    }

    def testRedistribute3() {
        expect:
        MemoryReallocation.redistribute([0, 2, 7, 0], 2) == [2, 4, 1, 2]
    }

}
