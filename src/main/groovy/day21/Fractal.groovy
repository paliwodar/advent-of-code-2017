package day21

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = ["matrix"], callSuper = false)
class Fractal {

    List<String> matrix = []

    Fractal(List<String> matrix) {
        this.matrix = matrix.collect()
    }

    List<Fractal> splitIntoSubfractals() {
        List<String> subfractals = []

        if (matrix.size() % 2 == 0) {
            for (int i = 0; 2 * i < matrix.size(); i++) {
                for (int j = 0; 2 * j < matrix.size(); j++) {
                    subfractals.add(matrix[2 * i][2 * j] + matrix[2 * i][2 * j + 1] +
                                            "/" + matrix[2 * i + 1][2 * j] + matrix[2 * i + 1][2 * j + 1])
                }
            }
            return subfractals.collect { fromString(it) }
        } else if (matrix.size() % 3 == 0) {
            for (int i = 0; 3 * i < matrix.size(); i++) {
                for (int j = 0; 3 * j < matrix.size(); j++) {
                    subfractals.add(matrix[3 * i][3 * j] + matrix[3 * i][3 * j + 1] + matrix[3 * i][3 * j + 2] +
                                            "/" + matrix[3 * i + 1][3 * j] + matrix[3 * i + 1][3 * j + 1] + matrix[3 * i + 1][3 * j + 2] +
                                            "/" + matrix[3 * i + 2][3 * j] + matrix[3 * i + 2][3 * j + 1] + matrix[3 * i + 2][3 * j + 2])
                }
            }
            return subfractals.collect { fromString(it) }
        } else {
            throw new IllegalStateException("Fractal size not evenly divisible by 2 neither by 3")
        }
    }

    List<Fractal> getRotatedOrFlipped() {
        def rotated90 = this.rotate90()
        def rotated180 = rotated90.rotate90()
        def rotated270 = rotated180.rotate90()

        ([this, rotated90, rotated180, rotated270].collectMany {
            [it, it.flipVertically(), it.flipHorizontally()]
        } as Set) as List
    }

    Fractal rotate90() {
        new Fractal(matrix.collect { it.toCharArray().toList() }
                          .transpose()
                          .collect { it.join().reverse() })
    }

    Fractal flipVertically() {
        new Fractal(matrix.reverse())
    }

    Fractal flipHorizontally() {
        new Fractal(matrix.collect { it.reverse() })
    }

    Fractal joinRows(Fractal f) {
        if (this.matrix.size() != f.matrix.size()) {
            throw new IllegalStateException("joining matrices of different row number")
        }

        new Fractal(matrix.indexed().collect { int i, String entry -> entry + f.matrix[i] })
    }

    static Fractal fromString(String s) {
        new Fractal(s.split("/").toList())
    }

    @Override
    String toString() {
        matrix.join("/")
    }
}