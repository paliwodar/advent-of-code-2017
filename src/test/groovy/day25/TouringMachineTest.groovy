package day25

import spock.lang.Specification

class TouringMachineTest extends Specification {

    def "final test"() {
        expect:
        new TouringMachine().go(12173597) == 2870
    }
}
