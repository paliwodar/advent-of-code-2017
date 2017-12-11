package day11

import static java.lang.Math.abs

class HexEd {

    static def calculate(String input) {

        List<String> steps = input.split(",").toList()
        double currentY = 0
        double currentX = 0
        double maxDistance = 0

        for (int i = 0; i < steps.size(); i++) {
            double stepY = 0;
            double stepX = 0;

            switch (steps[i]) {
                case "n":
                    stepY = 1
                    break
                case "nw":
                    stepY = 0.5
                    stepX = -1
                    break
                case "ne":
                    stepY = 0.5
                    stepX = 1
                    break
                case "s":
                    stepY = -1
                    break
                case "se":
                    stepX = 1
                    stepY = -0.5
                    break;
                case "sw":
                    stepX = -1
                    stepY = -0.5
                    break;
            }

            currentX += stepX
            currentY += stepY

            double currentDistance = distance(abs(currentX), abs(currentY))

            if (currentDistance > maxDistance) {
                maxDistance = currentDistance
            }
        }
        return maxDistance
    }

    static def distance(double x, double y) {
        if (x == 0) {
            return y
        } else {
            return 1 + distance(x - 1, y - 0.5)
        }
    }

}