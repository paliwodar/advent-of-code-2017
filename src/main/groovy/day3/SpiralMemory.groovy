package day3

import static java.lang.Math.abs

class SpiralMemory {

    static def calculateManhattanDistance(int n) {

        def positions = [new Tuple2(0, 0), new Tuple2(0, 0)]
        def directions = [[1, 0], [0, 1], [-1, 0], [0, -1]].collect { it as Tuple2 }
        def steps = 0

        for (int i = 2; positions.size() <= n; i++) {
            positions += goForward(positions.last(), i / 2, directions[steps++ % 4])
        }

        return abs(positions[n].first) + abs(positions[n].second)
    }

    private static goForward(Tuple2<Integer, Integer> from, def distance, Tuple2 direction) {
        (1..distance).collect {
            new Tuple2(from.first + direction.first * it, from.second + direction.second * it)
        }
    }

}
