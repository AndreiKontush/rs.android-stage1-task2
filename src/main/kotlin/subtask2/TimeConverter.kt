package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val numMap = mapOf(
            1 to "one", 2 to "two", 3 to "three", 4 to "four",
            5 to "five", 6 to "six", 7 to "seven", 8 to "eight",
            9 to "nine", 10 to "ten", 11 to "eleven", 12 to "twelve",
            13 to "thirteen", 14 to "fourteen", 15 to "fifteen", 16 to "sixteen",
            17 to "seventeen", 18 to "eighteen", 19 to "nineteen", 20 to "twenty",
            21 to "twenty one", 22 to "twenty two", 23 to "twenty three", 24 to "twenty four",
            25 to "twenty five", 26 to "twenty six", 27 to "twenty seven", 28 to "twenty eight",
            29 to "twenty nine", 30 to "thirty"
        )
        val hours = hour.toInt()
        val minutes = minute.toInt()

        when (minutes) {
            0 -> return "${numMap.getValue(hours)} o' clock"
            in 1..30 -> {
                if (minutes == 1) return "one minute past ${numMap.getValue(hours)}"
                if (minutes == 15) return "quarter past ${numMap.getValue(hours)}"
                if (minutes == 30) return "half past ${numMap.getValue(hours)}"
                return "${numMap.getValue(minutes)} minutes past ${numMap.getValue(hours)}"
            }
            in 31..59 -> {
                if (minutes == 59) return "one minute to ${numMap.getValue(hours + 1)}"
                if (minutes == 45) return "quarter to ${numMap.getValue(hours + 1)}"
                return "${numMap.getValue(60 - minutes)} minutes to ${numMap.getValue(hours + 1)}"
            }
            else -> return ""
        }
    }
}
