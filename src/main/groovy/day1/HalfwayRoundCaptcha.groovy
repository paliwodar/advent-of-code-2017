package day1

class HalfwayRoundCaptcha {

    static int calculateSum(String input) {
        input.toList()
             .withIndex()
             .collect { x, i -> x == input[(int)(i + input.length() / 2) % input.length()] ? x as Integer : 0 }
             .sum(0)
    }
}
