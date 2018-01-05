package day18

import groovy.transform.TypeChecked

@TypeChecked
class Duet {

    BigInteger played = 0g
    boolean received

    BigInteger calculate(List<String> input) {
        List<List<String>> instr = input.collect { it.split(" ").toList() }
        Map<String, BigInteger> reg = [:]

        for (int i = 0; i < instr.size() && !received;) {
            BigInteger offset = process(reg, instr[i])
            i += offset as Integer
        }
        return played
    }

    BigInteger process(Map<String, BigInteger> regs, List<String> strings) {
        String operation = strings[0]
        String registry = strings[1]
        BigInteger value = 0g

        try {
            value = strings[2] as Integer
        } catch (NumberFormatException e) {
            value = regs.getOrDefault(strings[2], 0g)
        }

        if (operation == "set") {
            regs.put(registry, value)
        } else if (operation == "add") {
            regs.put(registry, value + regs.getOrDefault(registry, 0g))
        } else if (operation == "mul") {
            regs.put(registry, value * regs.getOrDefault(registry, 0g))
        } else if (operation == "mod") {
            regs.put(registry, regs.getOrDefault(registry, 0g) % value)
        } else if (operation == "rcv" && played > 0) {
            received = true
        } else if (operation == "snd") {
            played = regs.get(registry)
        } else if (operation == "jgz" && regs.getOrDefault(registry, 0g) > 0) {
            return value
        }
        return 1
    }

}
