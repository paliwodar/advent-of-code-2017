package day14

import day10.KnotHash

class DiskDefragmentation {

    static int calculateOnes(String input) {
        getArea(input).collectMany { it as List }.count { it == 1 }
    }

    static int countGroups(String input) {
        int[][] area = getArea(input)
        int a = 0
        ([0..127] * 2).combinations().each { int x, int y ->
            if (area[x][y] == 1) {
                a++
                clearAll(area, x, y)
            }
        }
        return a
    }

    static int[][] getArea(String input) {
        List<String> all = buildInput(input)
        int[][] area = new int[128][128]

        all.collect { KnotHash.calculate(256, it) }
           .eachWithIndex { String it, int index ->

            for (int i = 0; i < it.length(); i++) {
                String a = hexToBinary(it[i])

                for (int j = 0; j < a.length(); j++) {
                    if (a[j] == "1") {
                        area[index][i * 4 + j] = 1
                    }
                }
            }
        }
        return area
    }

    static def clearAll(int[][] area, int i, int j) {
        area[i][j] = 0
        [[-1, 0], [1, 0], [0, -1], [0, 1]].each { int x, int y ->
            if (check(area, i + x, j + y)) {
                clearAll(area, i + x, j + y)
            }
        }
        area[i][j] = 0
    }

    static boolean check(int[][] area, int i, int j) {
        return i >= 0 && j >= 0 && i < 128 && j < 128 && area[i][j] == 1
    }

    static List<String> buildInput(String s) {
        return (0..127).collect { s + "-" + it }
    }

    static String hexToBinary(String hex) {
        int i = Integer.parseInt(hex, 16);
        String Bin = Integer.toBinaryString(i);
        int toAdd = [4 - Bin.length(), 0].max()
        String toAddS = "0" * toAdd
        return toAddS + Bin;
    }

}