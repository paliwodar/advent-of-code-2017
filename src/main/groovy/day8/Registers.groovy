package day8

class Registers {
    Map<String, Integer> map = [:]

    def calculate(List<String> s) {
        def high = -1
        for (int i = 0; i < s.size(); i++) {
            def t = s[i].split()

            process(t[0], t[1], t[2] as Integer, t[4], t[5], t[6] as Integer)

            if (map.values().max() > high) {
                high = map.values().max()
            }
        }
        return high
    }

    def process(String reg, instr, n, condReg, op, opArg) {
        def reg1Value = map.getOrDefault(reg, 0)
        def reg2Value = map.getOrDefault(condReg, 0)
        def opMul = instr == "inc" ? 1 : -1

        if (Eval.me("${reg2Value} ${op} ${opArg}")) {
            map.put(reg, reg1Value + n * opMul)
        }
    }
}
