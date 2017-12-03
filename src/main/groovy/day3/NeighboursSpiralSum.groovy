package day3

import static com.google.common.collect.Iterables.cycle

class NeighboursSpiralSum {

    static def calculateSum(int n) {

        def positionsList = [new Tuple2(0, 0), new Tuple2(0, 0)]
        def positionsToSum = [(new Tuple2(0, 0)): 1]
        def directions = cycle([[1, 0], [0, 1], [-1, 0], [0, -1]].collect { it as Tuple2 }).iterator()

        (2..100).collect {
            positionsList += goForward(positionsList.last(), it / 2, directions.next(), positionsToSum)
        }

        return positionsToSum[positionsList[n]]
    }

    private static goForward(def from, def distance, def direction, def positionsToSum) {
        (1..distance).collect {
            def currentPosition = new Tuple2(from.first + direction.first * it, from.second + direction.second * it)
            positionsToSum.put(currentPosition, getSurroundingSum(currentPosition, positionsToSum))
            currentPosition
        }
    }

    def static getSurroundingSum(Tuple2 point, Map positionsToSum) {
        ([-1..1] * 2).combinations().collect {
            positionsToSum.getOrDefault(new Tuple2(point.first + it[0], point.second + it[1]), 0)
        }.sum()
    }

}
