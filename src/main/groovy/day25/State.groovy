package day25

enum State {

    A([0: [1, 1, "B"], 1: [0, -1, "C"]]),
    B([0: [1, -1, "A"], 1: [1, 1, "D"]]),
    C([0: [1, 1, "A"], 1: [0, -1, "E"]]),
    D([0: [1, 1, "A"], 1: [0, 1, "B"]]),
    E([0: [1, -1, "F"], 1: [1, -1, "C"]]),
    F([0: [1, 1, "D"], 1: [1, 1, "A"]])

    final Map<Integer, List> moves

    State(Map<Integer, List> moves) {
        this.moves = moves
    }

}