private const val SECONDS_IN_MINUTE = 60
private const val SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTE
private const val SECONDS_IN_DAY = 24 * SECONDS_IN_HOUR

fun main() {
    println(agoToText(1))
    println(agoToText(SECONDS_IN_MINUTE))
    println(agoToText(SECONDS_IN_MINUTE + 1))
    println(agoToText(2 * SECONDS_IN_MINUTE))
    println(agoToText(5 * SECONDS_IN_MINUTE))
    println(agoToText(11 * SECONDS_IN_MINUTE))
    println(agoToText(12 * SECONDS_IN_MINUTE))
    println(agoToText(20 * SECONDS_IN_MINUTE))
    println(agoToText(21 * SECONDS_IN_MINUTE))
    println(agoToText(23 * SECONDS_IN_MINUTE))
    println(agoToText(SECONDS_IN_HOUR))
    println(agoToText(SECONDS_IN_HOUR + 1))
    println(agoToText(2 * SECONDS_IN_HOUR))
    println(agoToText(5 * SECONDS_IN_HOUR))
    println(agoToText(5 * SECONDS_IN_HOUR + 1))
    println(agoToText(21 * SECONDS_IN_HOUR + 1))
    println(agoToText(SECONDS_IN_DAY))
    println(agoToText(SECONDS_IN_DAY + 1))
    println(agoToText(2 * SECONDS_IN_DAY + 1))
    println(agoToText(3 * SECONDS_IN_DAY + 1))
}

private fun agoToText(secondsCount: Int): String = when {
    secondsCount <= SECONDS_IN_MINUTE -> "был(а) только что"
    secondsCount <= SECONDS_IN_HOUR -> getMinutesText(secondsCount)
    secondsCount <= SECONDS_IN_DAY -> getHoursText(secondsCount)
    secondsCount <= 2 * SECONDS_IN_DAY -> "был(а) в сети сегодня"
    secondsCount <= 3 * SECONDS_IN_DAY -> "был(а) в сети вчера"
    else -> "был(а) в сети давно"
}

private fun getMinutesText(secondsCount: Int): String {
    val minutesCount = secondsCount / SECONDS_IN_MINUTE
    val divisionBy10Remainder = minutesCount % 10
    val minutesText = when {
        (minutesCount in 5..20) || divisionBy10Remainder >= 5 || divisionBy10Remainder == 0 -> "минут"
        divisionBy10Remainder >= 2 -> "минуты"
        else -> "минуту"
    }
    return "был(а) $minutesCount $minutesText назад"
}

private fun getHoursText(secondsCount: Int): String {
    val hoursCount = secondsCount / SECONDS_IN_HOUR
    val divisionBy10Remainder = hoursCount % 10
    val hoursText = when {
        (hoursCount in 5..20) || divisionBy10Remainder == 0 -> "часов"
        divisionBy10Remainder >= 2 -> "часа"
        else -> "час"
    }
    return "был(а) в сети $hoursCount $hoursText назад"
}