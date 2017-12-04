package day4

class HighEntropyPassphrase {

    static def howManyValid(List<String> list) {
        list.findAll { isValid(it)}.size()
    }

    static def isValid(String passphrase) {
        passphrase.split(" ").toList().unique().size() == passphrase.split(" ").size()
    }
}
