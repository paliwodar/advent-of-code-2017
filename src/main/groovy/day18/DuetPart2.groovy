package day18

import groovy.transform.TypeChecked

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.TimeUnit

@TypeChecked
class DuetPart2 implements Runnable {

    Map<String, BigInteger> reg = [:]
    BlockingQueue<BigInteger> queue = new ArrayBlockingQueue(128);
    DuetPart2 other
    List<String> input
    BigInteger init
    int sent = 0

    void setOther(DuetPart2 other) {
        this.other = other
    }

    void receive(BigInteger val) {
        queue.add(val)
    }

    BigInteger process(Map<String, BigInteger> regs, List<String> strings, DuetPart2 other) {
        String operation = strings[0]
        String registry = strings[1]
        BigInteger registryOrValue = parse(strings[1], regs)
        BigInteger value = parse(strings[2], regs)

        if (operation == "set") {
            regs.put(registry, value)
        } else if (operation == "add") {
            regs.put(registry, value + registryOrValue)
        } else if (operation == "mul") {
            regs.put(registry, value * registryOrValue)
        } else if (operation == "mod") {
            regs.put(registry, registryOrValue % value)
        } else if (operation == "rcv") {
            BigInteger rec = queue.poll(1, TimeUnit.SECONDS)
            if (rec != null) {
                regs.put(registry, rec)
            } else {
                throw new IllegalStateException("Deadlock occurred")
            }
        } else if (operation == "snd") {
            other.receive(registryOrValue)
            sent++
        } else if (operation == "jgz" && registryOrValue > 0) {
            return value
        }
        return 1
    }

    private BigInteger parse(String string, Map<String, BigInteger> regs) {
        try {
            return string as Integer
        } catch (NumberFormatException e) {
            return regs.getOrDefault(string, 0g)
        }
    }

    static List<List<String>> read(List<String> input) {
        input.collect { it.split(" ").toList() }
    }

    @Override
    void run() {
        reg.put('p', init)
        List<List<String>> instr = read(input)
        for (int i = 0; i < instr.size();) {
            BigInteger offset = process(reg, instr[i], other)
            i += (offset as Integer)
        }
    }
}
