package day23

class CoprocessorConflagration {
    static int mul = 0

    static int calculate(List<String> input) {

        Map<String, BigInteger> reg = [:]
        List<List<String>> instr = input.collect { it.split(" ").toList() }

        for (int i = 0; i < instr.size();) {
            BigInteger offset = process(reg, instr[i])
            i += offset as Integer
        }
        return mul
    }

    static BigInteger process(Map<String, BigInteger> regs, List<String> strings) {
        String operation = strings[0]
        String registry = strings[1]
        BigInteger registryValue = parse(strings[1], regs)
        BigInteger value = parse(strings[2], regs)

        if (operation == "set") {
            regs.put(registry, value)
        } else if (operation == "sub") {
            regs.put(registry, regs.getOrDefault(registry, 0g) - value)
        } else if (operation == "mul") {
            mul++
            regs.put(registry, value * regs.getOrDefault(registry, 0g))
        } else if (operation == "jnz") {
            if (registryValue != 0) {
                return value
            }
        } else {
            throw new IllegalArgumentException()
        }
        return 1
    }

    private static BigInteger parse(String string, Map<String, BigInteger> regs) {
        try {
            return string as Integer
        } catch (NumberFormatException e) {
            return regs.getOrDefault(string, 0g)
        }
    }

}
