package subtask4

class Pangram {

    fun getResult(inputString: String): String {
        val alphabet = hashMapOf(
            'a' to false, 'b' to false, 'c' to false, 'd' to false, 'e' to false, 'f' to false,
            'g' to false, 'h' to false, 'i' to false, 'j' to false, 'k' to false, 'l' to false,
            'm' to false, 'n' to false, 'o' to false, 'p' to false, 'q' to false, 'r' to false,
            's' to false, 't' to false, 'u' to false, 'v' to false, 'w' to false, 'x' to false,
            'y' to false, 'z' to false
        )
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y')
        val consonants = setOf(
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r',
            's', 't', 'v', 'w', 'x', 'z', 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K',
            'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z'
        )
        for (c in inputString) {
            if (c in 'a'..'z' || c in 'A'..'Z') alphabet[c.toLowerCase()] = true
        }
        val isPangram = alphabet.values.all { it }
        if (isPangram) return getResultForCharsInLetters(inputString, vowels)

        val noNewLinesString = inputString.replace('\n', ' ')
        return getResultForCharsInLetters(noNewLinesString, consonants)
    }

    private fun getResultForCharsInLetters(input: String, letters: Set<Char>): String {
        val words = input.split("\\s+".toRegex()).filter {it != ""}
        var maxNumber = -1
        val fitWords = words.map { word ->
            var fitWord = ""
            for (c in word) {
                fitWord += if (c in letters) c.toUpperCase() else c
            }
            val number = word.count { it in letters }
            if (maxNumber < number) maxNumber = number
            number.toString() + fitWord
        }
        val orderedWords = mutableListOf<String>()
        for (i in 0..maxNumber) {
            for (word in fitWords) {
                if (word.count { it in letters } == i) orderedWords.add(word)
            }
        }
        return orderedWords.joinToString(" ")
    }
}
