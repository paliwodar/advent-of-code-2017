package day25

class TouringMachine {

    List<Integer> tape = [0]
    int cursor = 0
    State state = State.A

    def go(int steps) {

        for (int i = 0; i < steps; i++) {
            List rules = state.moves[tape[cursor]]

            tape.set(cursor, (int) rules[0])
            state = State.valueOf((String) rules[2])

            cursor += rules[1]

            if (cursor < 0) {
                tape.add(++cursor, 0)
            } else if (cursor >= tape.size()) {
                tape.add(0)
            }
        }
        return tape.count(1)
    }

}
