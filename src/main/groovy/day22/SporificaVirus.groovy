package day22

class SporificaVirus {

    static def basicChangeStateRules = [".": "#", "#": "."]
    static def changeStateRulesEvolved = [".": "W", "W": "#", "#": "F", "F": "."]

    List<String> map = []
    Tuple2<Integer, Integer> location
    int direction = 0
    int infectionCounter = 0

    def burst(Map<String, String> changeStateRules = basicChangeStateRules) {
        expandMap()
        direction = changeDirection(map, direction, location)
        changeState(changeStateRules)
        location = move(direction, location)
    }

    def burstEvolved() {
        burst(changeStateRulesEvolved)
    }

    private static Tuple2<Integer, Integer> move(int direction, def location) {
        def vector = diretionToVector(direction)
        return new Tuple2<>(location.first + vector.first, location.second + vector.second)
    }

    private void expandMap() {
        if (location.first <= 0 || location.first >= map.size() - 1
                || location.second <= 0 || location.second >= map.size() - 1) {

            String row = '.' * (map.size() + 2)
            map = map.collect { '.' + it + '.' }
            map = [row] + map + row
            location = new Tuple2<>(location.first + 1, location.second + 1)
        }
    }

    private void changeState(Map<String, String> nodeChangeRule) {
        String currentRow = map[location.first]
        String currentNode = currentRow[location.second]
        String toBeChangedTo = nodeChangeRule[currentNode]
        if (toBeChangedTo != currentNode) {
            map[location.first] = replace(currentRow, toBeChangedTo, location.second)
            if (toBeChangedTo == "#") {
                infectionCounter++
            }
        }
    }

    private static String replace(String currentRow, String replacement, int index) {
        currentRow.substring(0, index) + replacement + currentRow.substring(index + 1, currentRow.size())
    }

    private static int changeDirection(map, int direction, def location) {
        def currentNode = map[location.first][location.second]
        if (currentNode == "#") {
            return turnRight(direction)
        } else if (currentNode == ".") {
            return turnLeft(direction)
        } else if (currentNode == "F") {
            return turnRight(turnRight(direction))
        } else {
            return direction
        }
    }

    void readMap(List<String> input) {
        map = input
        location = new Tuple2((int) (input.size() / 2), (int) (input.size() / 2))
    }

    static int turnLeft(int direction) {
        (direction + 3) % 4
    }

    static int turnRight(int direction) {
        (direction + 1) % 4
    }

    static def diretionToVector(int dir) {
        switch (dir) {
            case 0:
                return new Tuple2<Integer, Integer>(-1, 0)
            case 1:
                return new Tuple2<Integer, Integer>(0, 1)
            case 2:
                return new Tuple2<Integer, Integer>(1, 0)
            case 3:
                return new Tuple2<Integer, Integer>(0, -1)
            default:
                throw new IllegalArgumentException("wrong direction")
        }
    }
}


