fun main() {
    val phoneShops = listOf(
        PhoneShop("Челябинск", listOf(25_000, 12_000, 65_000)),
        PhoneShop("Омск", listOf(25_500, 13_000, 65_200))
    )
    var repaired = false
    while (true) {
        println("Вас приветствует приложение магазина \"Смартшоп\"")
        println("Выберите действие:\n1: Выбрать город\n2: Выйти")
        val input1: String = readln()
        if (input1 == "2") return

        println("Выберите город:\n1: ${phoneShops[0].city}\n2: ${phoneShops[1].city}\n3: Выйти")
        val input2 = when(readln()) {
            "1" -> 0
            "2" -> 1
            else -> return
        }

        if (input2 == 0 && !repaired)  {
            println("В этом магазине есть мастерская. Отремонтировать ваш телефон?\n1: Да\n2: Нет")
            if (readln() == "1") {
                repaired = true
                println("Телефон отремонтирован")
            } else {
                repaired = true
                println("Не нуждаетесь в ремонте")
            }
        }

        val catalog = phoneShops[input2].getCatalog()
        var input3 = 0
        while (true) {
            println("Выберите телефон:")
            catalog.forEachIndexed { index, phone ->
                println("${index + 1}: ${phone.first} - ${phone.second}")
            }
            println("4: Просмотреть статистику магазина")
            try {
                input3 = readln().toInt()
            } finally {
                if (input3 == 0) continue else break
            }
        }
        when (input3) {
            4 -> {
                val shop = phoneShops[input2]
                println("Количество проданных телефонов:")
                for (i in 0..<(catalog.size)) {
                    println("${shop.phoneList[i]}: ${shop.getSoldPhones()[i]}")
                }
                println("Общая сумма покупок: ${shop.getIncome()}")
            }

            else -> {
                println("Вы приобрели: ${catalog[(input3) - 1].first}")
                phoneShops[input2].sellPhone(input3)
            }
        }
    }
}