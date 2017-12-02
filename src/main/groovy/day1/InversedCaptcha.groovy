package day1

class InversedCaptcha {

    static int calculateSum(String input) {
        List<Integer> inputList = input.collect( {it as Integer})
        int result = 0;

        for (int i = 0; i < inputList.size(); i++) {
            if (inputList[i] == inputList[(i + 1) % inputList.size()]) {
                result += inputList[i];
            }
        }

        return result;
    }


}
