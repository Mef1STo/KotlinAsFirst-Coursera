package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun shoppingListCostTest() {
        val itemCosts = mapOf(
            "Хлеб" to 50.0,
            "Молоко" to 100.0
        )
        assertEquals(
            150.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко"),
                itemCosts
            )
        )
        assertEquals(
            150.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко", "Кефир"),
                itemCosts
            )
        )
        assertEquals(
            0.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко", "Кефир"),
                mapOf()
            )
        )
    }

    @Test
    @Tag("Example")
    fun filterByCountryCode() {
        val phoneBook = mutableMapOf(
            "Quagmire" to "+1-800-555-0143",
            "Adam's Ribs" to "+82-000-555-2960",
            "Pharmakon Industries" to "+1-800-555-6321"
        )

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+999")
        assertEquals(0, phoneBook.size)
    }

    @Test
    @Tag("Example")
    fun removeFillerWords() {
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я как-то люблю Котлин".split(" "),
                "как-то"
            )
        )
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я как-то люблю таки Котлин".split(" "),
                "как-то",
                "таки"
            )
        )
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я люблю Котлин".split(" "),
                "как-то",
                "таки"
            )
        )
    }

    @Test
    @Tag("Example")
    fun buildWordSet() {
        assertEquals(
            buildWordSet("Я люблю Котлин".split(" ")),
            mutableSetOf("Я", "люблю", "Котлин")
        )
        assertEquals(
            buildWordSet("Я люблю люблю Котлин".split(" ")),
            mutableSetOf("Котлин", "люблю", "Я")
        )
        assertEquals(
            buildWordSet(listOf()),
            mutableSetOf<String>()
        )
    }

    @Test
    @Tag("Normal")
    fun mergePhoneBooks() {
        assertEquals(
            mapOf("Emergency" to "112"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "112")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "112", "Police" to "02")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112, 911", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "911", "Police" to "02")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112, 911", "Fire department" to "01", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112", "Fire department" to "01"),
                mapOf("Emergency" to "911", "Police" to "02")
            )
        )
    }

    @Test
    @Tag("Easy")
    fun buildGrades() {
        assertEquals(
            mapOf<Int, List<String>>(),
            buildGrades(mapOf())
        )
        // TODO: Sort the values here or let the students do it?
        assertEquals(
            mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат")),
            buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
        )
        assertEquals(
            mapOf(3 to listOf("Семён", "Михаил", "Марат")),
            buildGrades(mapOf("Марат" to 3, "Семён" to 3, "Михаил" to 3))
        )
    }

    @Test
    @Tag("Easy")
    fun containsIn() {
        assertTrue(containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")))
    }

    @Test
    @Tag("Normal")
    fun averageStockPrice() {
        assertEquals(
            mapOf<String, Double>(),
            averageStockPrice(listOf())
        )
        assertEquals(
            mapOf("MSFT" to 100.0, "NFLX" to 40.0),
            averageStockPrice(listOf("MSFT" to 100.0, "NFLX" to 40.0))
        )
        assertEquals(
            mapOf("MSFT" to 150.0, "NFLX" to 40.0),
            averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
        )
        assertEquals(
            mapOf("MSFT" to 150.0, "NFLX" to 45.0),
            averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0, "NFLX" to 50.0))
        )
    }

    @Test
    @Tag("Normal")
    fun findCheapestStuff() {
        assertNull(
            findCheapestStuff(
                mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                "торт"
            )
        )
        assertEquals(
            "Мария",
            findCheapestStuff(
                mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                "печенье"
            )
        )
    }

    @Test
    @Tag("Hard")
    fun propagateHandshakes() {
        assertEquals(
            mapOf(
                "Marat" to setOf("Mikhail", "Sveta"),
                "Sveta" to setOf("Mikhail"),
                "Mikhail" to setOf()
            ),
            propagateHandshakes(
                mapOf(
                    "Marat" to setOf("Sveta"),
                    "Sveta" to setOf("Mikhail")
                )
            )
        )
        assertEquals(
            mapOf(
                "Marat" to setOf("Mikhail", "Sveta"),
                "Sveta" to setOf("Marat", "Mikhail"),
                "Mikhail" to setOf("Sveta", "Marat")
            ),
            propagateHandshakes(
                mapOf(
                    "Marat" to setOf("Mikhail", "Sveta"),
                    "Sveta" to setOf("Marat"),
                    "Mikhail" to setOf("Sveta")
                )
            )
        )
    }

    @Test
    @Tag("Easy")
    fun subtractOf() {
        val from = mutableMapOf("a" to "z", "b" to "c")

        subtractOf(from, mapOf())
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("b" to "z"))
        assertEquals(from, mapOf("a" to "z", "b" to "c"))

        subtractOf(from, mapOf("a" to "z"))
        assertEquals(from, mapOf("b" to "c"))
    }

    @Test
    @Tag("Easy")
    fun whoAreInBoth() {
        assertEquals(
            emptyList<String>(),
            whoAreInBoth(emptyList(), emptyList())
        )
        assertEquals(
            listOf("Marat"),
            whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Marat", "Kirill"))
        )
        assertEquals(
            emptyList<String>(),
            whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Sveta", "Kirill"))
        )
    }

    @Test
    @Tag("Normal")
    fun canBuildFrom() {
        assertFalse(canBuildFrom(emptyList(), "foo"))
        assertTrue(canBuildFrom(listOf('a', 'b', 'o'), "baobab"))
        assertFalse(canBuildFrom(listOf('a', 'm', 'r'), "Marat"))
    }

    @Test
    @Tag("Normal")
    fun extractRepeats() {
        assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(emptyList())
        )
        assertEquals(
            mapOf("a" to 2),
            extractRepeats(listOf("a", "b", "a"))
        )
        assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(listOf("a", "b", "c"))
        )
    }

    @Test
    @Tag("Normal")
    fun hasAnagrams() {
        assertFalse(hasAnagrams(emptyList()))
        assertTrue(hasAnagrams(listOf("рот", "свет", "тор")))
        assertFalse(hasAnagrams(listOf("рот", "свет", "код", "дверь")))
    }

    @Test
    @Tag("Hard")
    fun findSumOfTwo() {
//        assertEquals(
//            Pair(-1, -1),
//            findSumOfTwo(emptyList(), 1)
//        )
//        assertEquals(
//            Pair(0, 2),
//            findSumOfTwo(listOf(1, 2, 3), 4)
//        )
//        assertEquals(
//            Pair(-1, -1),
//            findSumOfTwo(listOf(1, 2, 3), 6)
//        )
        assertEquals(
            Pair(-1, -1),
            findSumOfTwo(
                listOf(
                    40699,
                    40700,
                    40699,
                    13948,
                    0,
                    0,
                    40699,
                    1,
                    47901,
                    0,
                    12995,
                    1,
                    40700,
                    1,
                    0,
                    40700,
                    17754,
                    0,
                    40699,
                    40700,
                    29224,
                    9661,
                    40699,
                    24516,
                    40699,
                    0,
                    40700,
                    40700,
                    1,
                    40699,
                    1,
                    1,
                    40700,
                    45285,
                    37383,
                    24727,
                    43807,
                    40699,
                    49100,
                    14914,
                    14160,
                    49769,
                    16646,
                    36730,
                    40699,
                    41246,
                    1,
                    1,
                    1,
                    39296,
                    13207,
                    4166,
                    40700,
                    1,
                    40700,
                    0,
                    24252,
                    12292,
                    40700,
                    0,
                    40700,
                    40699,
                    19218,
                    0,
                    40700,
                    40700,
                    49151,
                    0,
                    40699,
                    40699,
                    40700,
                    24520,
                    40699,
                    0,
                    32878,
                    12157,
                    40700,
                    6922,
                    22429,
                    32869,
                    1,
                    48737,
                    40700,
                    40700,
                    26118,
                    0,
                    40700,
                    40700,
                    1,
                    1,
                    0,
                    0,
                    40699,
                    40700,
                    40699,
                    40699,
                    30118,
                    40700,
                    40699,
                    10389,
                    17040,
                    34122,
                    40700,
                    40700,
                    1,
                    0,
                    40699,
                    419,
                    0,
                    0,
                    40700,
                    40700,
                    40700,
                    12264,
                    40700,
                    39079,
                    23517,
                    37223,
                    40700,
                    40699,
                    40699,
                    13027,
                    32604,
                    40699,
                    1,
                    0,
                    17682,
                    40699,
                    28114,
                    40699,
                    23264,
                    7574,
                    0,
                    0,
                    24779,
                    11274,
                    40699,
                    35482,
                    38981,
                    0,
                    46553,
                    0,
                    1,
                    40699,
                    23075,
                    4279,
                    2264,
                    40700,
                    34813,
                    0,
                    0,
                    11047,
                    40700,
                    13365,
                    40699,
                    39111,
                    40700,
                    29294,
                    0,
                    48433,
                    43570,
                    0,
                    8096,
                    0,
                    1,
                    14558,
                    40700,
                    40700,
                    45153,
                    40699,
                    40699,
                    1,
                    1,
                    25652,
                    12988,
                    40699,
                    36977,
                    25456,
                    0,
                    4377,
                    40699,
                    40700,
                    0,
                    0,
                    40699,
                    33430,
                    0,
                    1,
                    46882,
                    40700,
                    40700,
                    15921,
                    1,
                    8319,
                    40699,
                    0,
                    1,
                    1,
                    0,
                    38810,
                    23727,
                    37874,
                    22623,
                    16485,
                    1,
                    42155,
                    0,
                    1,
                    0,
                    40699,
                    10819,
                    40699,
                    42809,
                    0,
                    0,
                    15865,
                    4898,
                    40699,
                    33454,
                    1,
                    19385,
                    40700,
                    325,
                    1,
                    1,
                    1,
                    40699,
                    0,
                    46995,
                    24977,
                    40700,
                    1,
                    40699,
                    1,
                    8581,
                    1,
                    28649,
                    0,
                    0,
                    40700,
                    40700,
                    7825,
                    40699,
                    40699,
                    12386,
                    1,
                    0,
                    24074,
                    40699,
                    40699,
                    0,
                    13720,
                    46375,
                    875,
                    40699,
                    46812,
                    49709,
                    48486,
                    31754,
                    31482,
                    1,
                    1,
                    40700,
                    1,
                    1,
                    2131,
                    40699,
                    1,
                    1,
                    40700,
                    806,
                    40700,
                    40699,
                    0,
                    27414,
                    44295,
                    40700,
                    0,
                    34785,
                    18838,
                    48474,
                    1,
                    40700,
                    22561,
                    40700,
                    4442,
                    1854,
                    40699,
                    12609,
                    1,
                    0,
                    1,
                    0,
                    22173,
                    5852,
                    0,
                    26735,
                    40700,
                    40699,
                    0,
                    40699,
                    39432,
                    23064,
                    40699,
                    48259,
                    40699,
                    29241,
                    40699,
                    0,
                    0,
                    1,
                    1,
                    40699,
                    40699,
                    0,
                    7600,
                    0,
                    40700,
                    41816,
                    24063,
                    36833,
                    19966,
                    40699,
                    40700,
                    0,
                    18656,
                    1,
                    40700,
                    23169,
                    1,
                    1,
                    0,
                    1,
                    1,
                    40699,
                    1,
                    40699,
                    1,
                    40699,
                    46907,
                    40700,
                    24544,
                    37404,
                    44582,
                    35047,
                    1,
                    1459,
                    42073,
                    28864,
                    40700,
                    40699,
                    40700,
                    1147,
                    40700,
                    15505,
                    40700,
                    1,
                    40700,
                    40700,
                    1,
                    32401,
                    40699,
                    21366,
                    13667,
                    5621,
                    0,
                    40700,
                    1,
                    44066,
                    40699,
                    40699,
                    0,
                    34334,
                    27950,
                    40700,
                    0,
                    40700,
                    40699,
                    24594,
                    49815,
                    1,
                    1,
                    6844,
                    1,
                    729,
                    1,
                    4615,
                    9778,
                    40700,
                    40700,
                    0,
                    24535,
                    40699,
                    0,
                    40699,
                    0,
                    40699,
                    22693,
                    1,
                    40700,
                    48714,
                    8638,
                    1,
                    5399,
                    40700,
                    1,
                    6978,
                    1,
                    40700,
                    40699,
                    0,
                    0,
                    0,
                    40700,
                    40699,
                    40699,
                    40700,
                    11938,
                    40699,
                    42524,
                    40699,
                    21892,
                    1,
                    40699,
                    4865,
                    49093,
                    40700,
                    6657,
                    1
                ), 41914
            )
        )
    }

    @Test
    @Tag("Impossible")
    fun bagPacking() {
        assertEquals(
            setOf("Кубок"),
            bagPacking(
                mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                850
            )
        )
        assertEquals(
            emptySet<String>(),
            bagPacking(
                mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                450
            )
        )
    }

    // TODO: map task tests
}
