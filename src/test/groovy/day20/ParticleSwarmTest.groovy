package day20

import spock.lang.Specification

class ParticleSwarmTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day20/input.txt').eachLine { line ->
            input << (line)
        }
    }

    def "parse test part 1"() {
        expect:
        ParticleSwarm.parseAbsSum("p=<15,680,-1336>, v=<1,2,-4>, a=<-1,-2,5>") == new Tuple2(7, 8)
    }

    def "parse test part 2"() {
        expect:
        ParticleSwarm.parseFull("p=<15,680,-1336>, v=<1,2,-4>, a=<-1,-2,5>") == [15, 680, -1336, 1, 2, -4, -1, -2, 5]
    }

    def "finalTestPart1"() {
        expect:
        ParticleSwarm.calcClosest(input) == 157
    }

    def "finalTestPart2"() {
        expect:
        ParticleSwarm.calcNonColliding(input, 1000) == 499
    }

}
