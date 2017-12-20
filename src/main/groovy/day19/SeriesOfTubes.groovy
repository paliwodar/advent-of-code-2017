package day19

import groovy.transform.TailRecursive

class SeriesOfTubes {

    static Tuple2<String, Integer> calc(List<String> input) {
        int start = input[0].indexOf('|')
        return go(input, start, 0, 0, 1, "", 0)
    }

    @TailRecursive
    static Tuple2<String, Integer> go(List<String> strings, int startX, int startY, int dirX, int dirY, String acc, int counter) {

        char current = strings[startY][startX]

        if (current == " ") {
            return new Tuple2<String, Integer>(acc, counter)
        } else if (current == "+") {
            Tuple2<Integer, Integer> newDir = getNewDirection(strings, startX, startY, dirX, dirY)
            return go(strings, startX + newDir.first, startY + newDir.second, newDir.first, newDir.second, acc, counter + 1)
        } else {
            return go(strings, startX + dirX, startY + dirY, dirX, dirY, acc + (current.isLetter() ? current : ""), counter + 1)
        }
    }

    static Tuple2<Integer, Integer> getNewDirection(List<String> strings, int startX, int startY, int dirX, int dirY) {
        if (dirX == 0) {
            if (startX - 1 > 0 && strings.size() && strings[startY][startX - 1] != " ") {
                return new Tuple2<Integer, Integer>(-1, 0)
            } else {
                return new Tuple2<Integer, Integer>(1, 0)
            }
        } else if (dirY == 0) {
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
