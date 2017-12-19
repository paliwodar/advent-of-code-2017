package day17

import groovy.transform.CompileStatic

@CompileStatic
class Day17 {

    int step = 3
    int currentIndex = 0
    int currentNumber = 0
    int numberAfterZero = 0

    Day17(int step) {
        this.step = step
    }

    int spin(int n) {
        for (int i = 0; i < n; i++) {
            int nextIndex = (currentIndex + step) % ++currentNumber + 1
            if (nextIndex == 1) {
                numberAfterZero = currentNumber
            }
            currentIndex = nextIndex
        }
        numberAfterZero
    }

    static void main(String[] args) {
        Day17 spin = new Day17(354)
        println spin.spin(50000000)
    }
}
