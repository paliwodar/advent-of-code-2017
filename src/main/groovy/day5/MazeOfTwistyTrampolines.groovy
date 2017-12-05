package day5

class MazeOfTwistyTrampolines {

    static def calculate(List<Integer> input) {
        def index = 0;
        def old = 0;
        def steps = 0;

        while (index >= 0 && index < input.size()) {
            old = index;
            index += input[index];
            input[old]++
            steps++
        }
        steps
    }
}
