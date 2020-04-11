package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        val preRegString = a.filter { it.isUpperCase() }
        var regString = ""
        for (char in preRegString) {
            regString += ".*$char"
        }
        regString += ".*"
        if (!b.matches(regString.toRegex())) return "NO"

        var match = ""
        var i = 0
        for (c in b) {
            while ((i < a.length) && (a[i].toUpperCase() != c)) {
                i++
            }
            if (i >= a.length) break

            if (a[i].toUpperCase() == c) {
                i++
                match += c
            }
        }
        if (b != match) return "NO"

        return "YES"
    }
}
