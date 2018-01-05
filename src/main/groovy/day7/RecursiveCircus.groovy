package day7

import java.util.regex.Matcher

class RecursiveCircus {

    static Map<String, Integer> weights = [:]
    static Map<String, List<String>> disc = [:]

    static def calculateSum(List<String> list, String starting) {
        list.each { read(it) }

        balance(starting, 0)
    }

    static int balance(String s, int level) {
        List<String> list = disc.get(s)
        int w = weights.get(s)

        if (list == null) {
            return w
        }

        if (list.collect { balance(it, level - 1) }.unique().size() > 1) {
            println list.collect { new Tuple2(it, balance(it, level - 1)) } + " LEVEL" + level
        }

        return list.collect { balance(it, level - 1) }.sum() + w
    }

    static def read(String s) {
        Matcher head = s =~ /^([a-z]*) [(]([0-9]*)[)]/
        Matcher tail = s =~ /.*-> (.*)/

        weights.put(head[0][1] as String, head[0][2] as Integer)

        if (tail.matches()) {
            disc.put(head[0][1], tail[0][1].split(", "))
        }
    }

    static def findStart(List<String> list) {

        return list.findAll { it.contains("->") }
                   .collect { (it =~ /^[a-z]*/)[0] }
                   .find { String k -> list.count { it.contains(k) } == 1 }
    }

}
