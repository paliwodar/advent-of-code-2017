package day1

class InversedCaptcha {

    static int calculateSum(String input) {
        input.toList()
             .withIndex()
             .collect { x, i -> x == input[(i + 1) % input.size()] ? x as Integer : 0 }
             .sum(0)
    }


}
