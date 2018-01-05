package day18

import spock.lang.Specification
import spock.lang.Unroll


class DuetPart2Test extends Specification {

    def input = []

    def setup() {
        new File('src/test/resources/day18/input.txt').eachLine { line ->
            input << (line)
        }
    }

    @Unroll
    def 'small test'() {
        given:
        DuetPart2 a0 = new DuetPart2(input: input, init: 0g)
        DuetPart2 a1 = new DuetPart2(input: input, init: 1g)
        a0.setOther(a1)
        a1.setOther(a0)

        and:
        def thread1 = new Thread(a0)
        def thread2 = new Thread(a1)

        when:
        thread1.start()
        thread2.start()
        thread1.join()
        thread2.join()

        then:
        a1.sent == 3

        where:
        input = [
                "snd 1",
                "snd 2",
                "snd p",
                "rcv a",
                "rcv b",
                "rcv c",
                "rcv d"
        ]
    }

    @Unroll
    def finaltest2() {
        given:
        DuetPart2 a0 = new DuetPart2(input: input, init: 0g)
        DuetPart2 a1 = new DuetPart2(input: input, init: 1g)
        a0.setOther(a1)
        a1.setOther(a0)

        and:
        def thread1 = new Thread(a0)
        def thread2 = new Thread(a1)

        when:
        thread1.start();
        thread2.start();
        thread1.join()
        thread2.join()

        then:
        a1.sent == 8001
    }
}


