package day16

class PermutationPromenade {

    List<String> input
    List<String> programs = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p']

    PermutationPromenade(String input, int size = 16) {
        this.input = input.split(",")
        programs = programs.subList(0, size)
    }

    List<String> dance() {
        for (String s : input) {
            if (s.startsWith("s")) {
                int val = ((s =~ /s([0-9]*)/)[0][1]) as Integer
                spin(val)
            } else if (s.startsWith("x")) {
                def m = s =~ /x([0-9]*)\/([0-9]*)/
                exchange(m[0][1] as Integer, m[0][2] as Integer)
            } else if (s.startsWith("p")) {
                partner(s[1], s[3])
            }
        }
        return programs
    }

    void spin(int k) {
        if (k > 15) {
            throw new IllegalArgumentException()
        }
        programs = programs.subList(programs.size() - k, programs.size()) + programs.subList(0, programs.size() - k)
    }

    void exchange(int i, int j) {
        programs.swap(i, j)
    }

    void partner(String u, String v) {
        programs.swap(programs.indexOf(u), programs.indexOf(v))
    }
}
