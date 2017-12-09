package day9

class StreamProcessing {

    def static calculate(String s) {

        def score = 0
        def level = 0
        def garbage = 0
        def triangl = false

        for (int i = 0; i < s.size(); i++) {

            if (triangl && s[i] != '>' && s[i] != '!') {
                garbage++
            }
            if (!triangl && s[i] == '<') {
                triangl = true
            }
            if (!triangl && s[i] == '{') {
                level++
                score += level
            }
            if (!triangl && s[i] == '}') {
                level--
            }
            if (s[i] == '>') {
                triangl = false
            }
            if (triangl && s[i] == '!') {
                i++
                continue
            }
        }

        return new Tuple2<>(score, garbage)
    }
}
