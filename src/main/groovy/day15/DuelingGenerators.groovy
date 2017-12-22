package day15

class DuelingGenerators {

    def static twoPower16 = 65536g
    def static ultimateReminder = 2147483647g
    def static aFactor = 16807g
    def static bFactor = 48271g

    static int calculate1(genInitA, genInitB, rounds) {
        def a = genInitA
        def b = genInitB
        def result = 0

        for (int i = 0; i < rounds; i++) {
            a = a * aFactor % ultimateReminder
            while (a % 4 != 0) {
                a = a * aFactor % ultimateReminder
            }

            b = b * bFactor % ultimateReminder
            while (b % 8 != 0) {
                b = b * bFactor % ultimateReminder
            }

            if (a % twoPower16 == b % twoPower16) {
                result++
            }
        }
        result
    }

    static void main(String[] args) {
        assert calculate1(516, 190, 5000000) == 303
    }

}