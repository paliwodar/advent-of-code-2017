package day1

class HalfwayRoundCaptcha {

    static int calculateSum(String input) {
        List<Integer> inputList = input.collect({ it as Integer })
        int halfOfLength = inputList.size() / 2.0
        int result = 0;

        for (int i = 0; i < inputList.size(); i++) {
            if (inputList[i] == inputList[(i + halfOfLength) % inputList.size()]) {
                result += inputList[i];
            }
        }

        return result;
    }
}
