package day22

import spock.lang.Ignore
import spock.lang.Specification

class SporificaVirusTest extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day22/input.txt').eachLine { line ->
            input << (line)
        }
    }

    def "test example part1"() {
        given:
        SporificaVirus virus = new SporificaVirus()
        virus.readMap(
                ["..#",
                 "#..",
                 "..."])

        when:
        (1..7).each {
            virus.burst()
        }

        then:
        virus.infectionCounter == 5
        virus.map == [".......",
                      ".......",
                      ".#..#..",
                      ".###...",
                      ".......",
                      ".......",
                      "......."]
    }

    def "final test part 1"() {
        given:
        SporificaVirus virus = new SporificaVirus()
        virus.readMap(input)

        when:
        (1..10000).each {
            virus.burst()
        }

        then:
        virus.infectionCounter == 5223
    }

    def "test example part 2"() {
        given:
        SporificaVirus virus = new SporificaVirus()
        virus.readMap(
                ["..#",
                 "#..",
                 "..."])

        when:
        (1..100).each {
            virus.burstEvolved()
        }

        then:
        virus.infectionCounter == 26
    }

    @Ignore("takes a bit longer to execute")
    def "final test part 2"() {
        given:
        SporificaVirus virus = new SporificaVirus()
        virus.readMap(input)

        when:
        (1..10000000).each {
            virus.burstEvolved()
        }

        then:
        virus.infectionCounter == 2511456
    }

}
