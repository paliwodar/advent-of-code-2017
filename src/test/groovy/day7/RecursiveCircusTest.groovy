package day7

import spock.lang.Specification

class RecursiveCircusTest extends Specification {

    def exampleTestPart1() {
        expect:
        RecursiveCircus.findStart(input) == "tknk"

        where:
        input = ["pbga (66)",
                 "xhth (57)",
                 "ebii (61)",
                 "havc (66)",
                 "ktlj (57)",
                 "fwft (72) -> ktlj, cntj, xhth",
                 "qoyq (66)",
                 "padx (45) -> pbga, havc, qoyq",
                 "tknk (41) -> ugml, padx, fwft",
                 "jptl (61)",
                 "ugml (68) -> gyxo, ebii, jptl",
                 "gyxo (61)",
                 "cntj (57)"]
    }

    def finalTestPart1() {
        given:
        def input = []
        new File('src/test/resources/day7/input.txt').eachLine { line ->
            input << (line)
        }

        expect:
        RecursiveCircus.findStart(input) == "eqgvf"
    }

    def exampleTest() {
        expect:
        RecursiveCircus.calculateSum(input, "tknk") == 778

        where:
        input = ["pbga (66)",
                 "xhth (57)",
                 "ebii (61)",
                 "havc (66)",
                 "ktlj (57)",
                 "fwft (72) -> ktlj, cntj, xhth",
                 "qoyq (66)",
                 "padx (45) -> pbga, havc, qoyq",
                 "tknk (41) -> ugml, padx, fwft",
                 "jptl (61)",
                 "ugml (68) -> gyxo, ebii, jptl",
                 "gyxo (61)",
                 "cntj (57)"]
    }

    def testCalculateSum() {
        expect:
        RecursiveCircus.calculateSum(input, "fwft") == 264

        where:
        input = ["pbga (66)",
                 "u (60)",
                 "fwft (72) -> pbga, qoyq, u",
                 "qoyq (66)"]
    }

    def finalTest() {
        given:
        def input = []
        new File('src/test/resources/day7/input.txt').eachLine { line ->
            input << (line)
        }

        expect:
        RecursiveCircus.calculateSum(input, "eqgvf") == 445226
    }

}
