package day13

import groovy.transform.CompileStatic

@CompileStatic
class PacketScanners {

    static int calculateMinimalDelay(List<String> input) {
        Map firewall = readAll(input)

        for (int i = 0; ; i++) {
            if (crossFirewall(firewall, i, { _, __ -> 1 }) == 0) {
                return i
            }
        }
    }

    static int calculateSeverity(List<String> input) {
        Map firewall = readAll(input)

        crossFirewall(firewall, 0, { int depth, int range -> depth * range })
    }

    static int crossFirewall(Map<Integer, Integer> map, int delay, Closure<Integer> evaluateCatch) {
        int result = 0
        for (Map.Entry<Integer, Integer> entry : map) {
            int frequency = entry.value + [entry.value - 2, 0].max()

            if ((entry.key + delay) % frequency == 0) {
                result += evaluateCatch(entry.key, entry.value)
            }
        }
        return result
    }

    static Map<Integer, Integer> readAll(List<String> lines) {
        Map<Integer, Integer> firewall = [:]

        for (int i = 0; i < lines.size(); i++) {
            String[] l = lines[i].split(": ")
            firewall.put(l[0] as Integer, l[1] as Integer);
        }
        return firewall
    }

}