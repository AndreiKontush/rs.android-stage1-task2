package subtask1

import java.time.DateTimeException
import java.time.LocalDate

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val monthMap = hashMapOf(
            "JANUARY" to "января", "FEBRUARY" to "февраля", "MARCH" to "марта",
            "APRIL" to "апреля", "MAY" to "мая", "JUNE" to "июня",
            "JULY" to "июля", "AUGUST" to "августа", "SEPTEMBER" to "сентября",
            "OCTOBER" to "октября", "NOVEMBER" to "ноября", "DECEMBER" to "декабря"
        )
        val dayMap = hashMapOf(
            "MONDAY" to "понедельник", "TUESDAY" to "вторник",
            "WEDNESDAY" to "среда", "THURSDAY" to "четверг",
            "FRIDAY" to "пятница", "SATURDAY" to "суббота", "SUNDAY" to "воскресенье"
        )
        val date = try {
            LocalDate.of(year.toInt(), month.toInt(), day.toInt())
        } catch (e: DateTimeException) {
            return "Такого дня не существует"
        }
        val ruMonth = monthMap.getValue(date.month.toString())
        val ruDayOfWeek = dayMap.getValue(date.dayOfWeek.toString())
        return "${date.dayOfMonth} $ruMonth, $ruDayOfWeek"
    }
}
