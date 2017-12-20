package day19

import groovy.transform.TailRecursive

class SeriesOfTubes {

    static Tuple2<String, Integer> calc(List<String> input) {
        int start = input[0].indexOf('|')
        return go(input, start, 0, new Tuple2<Integer, Integer>(0, 1), "", 0)
    }

    @TailRecursive
    static Tuple2<String, Integer> go(List<String> pipes, int currentX, int currentY, Tuple2<Integer, Integer> direction, String acc, int counter) {

        char current = pipes[currentY][currentX]

        if (current == " ") {
            return new Tuple2<String, Integer>(acc, counter)
        } else {
            final
            def newDirection = (current == "+" ? getNewDirection(pipes, currentX, currentY, direction) : direction)
            return go(pipes, currentX + newDirection.first, currentY + newDirection.second, newDirection, acc + (current.isLetter() ? current : ""), counter + 1)
        }
    }

    static Tuple2<Integer, Integer> getNewDirection(List<String> strings, int startX, int startY, Tuple2<Integer, Integer> direction) {
        if (direction.first == 0) {
            if (startX - 1 > 0 && strings.size() && strings[startY][startX - 1] != " ") {
                return new Tuple2<Integer, Integer>(-1, 0)
            } else {
                return new Tuple2<Integer, Integer>(1, 0)
            }
        } else if (direction.second == 0) {
            if (startY + 1 < strings.size() && strings[startY + 1][startX] != " ") {
                return new Tuple2<Integer, Integer>(0, 1)
            } else {
                return new Tuple2<Integer, Integer>(0, -1)
            }
        } else {
            throw new IllegalStateException()
        }

    }
}
