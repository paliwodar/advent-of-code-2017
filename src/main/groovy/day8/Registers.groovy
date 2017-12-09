package day8

class Registers {
    Map<String, Integer> map = [:]

    def calculate(List<String> input) {
        def high = -1
        for (String s : input) {
            def t = s.split()
            process(t[0], t[1], t[2] as Integer, t[4], t[5], t[6] as Integer)

            if (map.values().max() > high) {
                high = map.values().max()
            }
        }
        return high
    }

    def process(String reg, instr, n, reg2, op, opArg) {
        def reg1Val = map.getOrDefault(reg, 0)
        def reg2Val = map.getOrDefault(reg2, 0)
        def opMul = instr == "inc" ? 1 : -1

        if (Eval.me("${reg2Val} ${op} ${opArg}")) {
            map.put(reg, reg1Val + n * opMul)
        }
    }
}
