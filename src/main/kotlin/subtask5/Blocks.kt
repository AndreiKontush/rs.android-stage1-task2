package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any { //changed Array<ANY> to Array<*>
        if (blockB == Int::class) {
            val intList = blockA.filterIsInstance<Int>()
            if (intList.isEmpty()) throw IllegalArgumentException("Not enough data.")
            return intList.sum()
        }

        if (blockB == String::class) {
            val stringList = blockA.filterIsInstance<String>()
            if (stringList.isEmpty()) throw IllegalArgumentException("Not enough data.")
            return stringList.joinToString("")
        }

        if (blockB == LocalDate::class) {
            val resultDate = blockA.filterIsInstance<LocalDate>().max()
            return resultDate?.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                ?: throw IllegalArgumentException("Not enough data.")
        }

        throw IllegalArgumentException("Illegal blockB argument.")
    }
}
