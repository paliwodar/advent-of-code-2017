package day20

class ParticleSwarm {

    static def calcClosest(List<String> input) {
        List<Tuple2<Integer, Integer>> parsed = input.collect { parseAbsSum(it) }

        def minimalAcceleration = parsed.second.collect { Math.abs(it) }.min()
        def minAccelerationParticles = (parsed.findAll { it.second == minimalAcceleration })

        def minimalVelocity = minAccelerationParticles.first.collect { Math.abs(it) }.min()
        def resultParticles = minAccelerationParticles.findAll { it.first == minimalVelocity }

        if (resultParticles.size() > 1) {
            throw new IllegalArgumentException("More than one particle with minimal acceleration and velocity")
        }
        return parsed.indexOf(resultParticles[0])
    }

    static def calcNonColliding(List<String> input, int iterations) {
        List<List<Integer>> particles = input.collect { parseFull(it) }

        for (int i = 0; i < iterations; i++) {
            for (int j = 0; j < particles.size(); j++) {
                for (int k = 3; k < 6; k++) {
                    particles[j][k] += particles[j][k + 3]
                }
                for (int k = 0; k < 3; k++) {
                    particles[j][k] += particles[j][k + 3]
                }
            }

            particles = particles.groupBy { List<Integer> particle -> [particle[0], particle[1], particle[2]] }
                                 .findAll { it.value.size() == 1 }
                                 .collect { it.value[0] }
        }
        return particles.size()

    }

    static Tuple2<Integer, Integer> parseAbsSum(String line) {
        def m = line =~ /p=<.*>, v=<(.*)>, a=<(.*)>/

        return new Tuple2<Integer, Integer>(m[0][1].split(",").collect { Math.abs(it as Integer) }.sum(),
                                            m[0][2].split(",").collect { Math.abs(it as Integer) }.sum())
    }

    static List<Integer> parseFull(String line) {
        def m = line =~ /p=<(.*)>, v=<(.*)>, a=<(.*)>/
        (m[0][1].split(",").toList() + m[0][2].split(",").toList() + m[0][3].split(",").toList()).collect {
            it as Integer
        }
    }
}

