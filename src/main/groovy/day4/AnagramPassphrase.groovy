package day4

class AnagramPassphrase {

    static def howManyValid(List<String> list) {
        list.findAll { isValid(it) }.size()
    }

    static def isValid(String passphrase) {
        passphrase.split(" ")
                  .collect { String s -> s.toList().sort() }
                  .unique().size() == passphrase.split(" ").size()

    }
}
