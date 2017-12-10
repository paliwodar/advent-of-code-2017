package day10

class Day10 {

    static def calculate(int size, String bytes) {

        List<Byte> lengths = bytes.bytes.toList()
        lengths += ([17, 31, 73, 47, 23])

        List<Integer> list = (0..(size - 1)).toList()
        int skip = 0
        int current = 0

        for (int j = 0; j < 64; j++) {
            for (int i = 0; i < lengths.size(); i++) {

                int toAdd = lengths[i]
                list = reverse(current, lengths[i], list)

                current = (current + toAdd + skip) % size
                skip++
            }
        }

        def xor = xor(list)
        toHex(xor).trim()
    }

    static def toHex(List<Byte> integers) {
        return integers.collect {
            def a = 64.toHexString(it)
            a.size() == 1 ? "0" + a : a
        }.join("")
    }

    def static xor(List list) {
        List<Integer> res = []
        for (int i = 0; i < ((int) list.size() / 16); i++) {
            res << list.subList(i * 16, (i + 1) * 16).inject { x, y -> x ^ y }
        }
        return res
    }

    static def reverse(int start, int length, List<Integer> list) {
        def rev = []
        for (int i = start; i < start + length; i++) {
            rev += list[i % list.size()]
        }

        rev = rev.reverse()
        List<Integer> copy = list.collect()

        for (int i = start; i < start + length; i++) {
            copy[i % copy.size()] = rev[i - start]
        }

        return copy
    }

    static void main(String[] args) {
        assert (0..3).toList() == [0, 1, 2, 3]
        assert reverse(0, 3, [0, 1, 2, 3, 4]) == [2, 1, 0, 3, 4]
        assert xor([65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22]) == [64]
        assert xor([0] * 16 + [65, 27, 9, 1, 4, 3, 40, 50, 91, 7, 6, 0, 2, 5, 68, 22]) == [0, 64]
        assert toHex([64, 7, 255]) == "4007ff"
        assert "1,2,3".bytes.toList() == [49, 44, 50, 44, 51]
    }

}