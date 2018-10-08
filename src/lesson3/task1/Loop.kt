@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var x = 1L
    var count = 0
    if (n == 0) {
        count++
    }
    while (x <= abs(n)) {
        count++
        x *= 10
    }
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    if (n <= 2) {
        return 1
    }

    var x = 1
    var y = 1

    for (i in 2 until n) {
        y += x
        x = y - x
    }

    return y
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    when {
        m % n == 0 -> return m
        n % m == 0 -> return n
        else -> {
            val number = n * m
            for (i in min(m, n) downTo 1) {
                val newNumber = number / i
                if (newNumber % n == 0 && newNumber % m == 0) {
                    return newNumber
                }
            }
            var i = 1
            while (true) {
                if (i % m == 0 && i % n == 0) {
                    return i
                }
                i++
            }
        }
    }
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var i = 2
    do {
        if (n % i == 0) {
            return i
        }
        i++
    } while (i <= n)

    return -1
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var i = 1
    var divisor = 1
    do {
        if (n % i == 0) {
            divisor = i
        }
        i++
    } while (i < n)

    return divisor
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = isCoPrimeReq(m, n) == 1

fun isCoPrimeReq(m: Int, n: Int): Int {
    return when {
        n > m -> isCoPrimeReq(n, m)
        n == 0 -> m
        else -> isCoPrimeReq(n, m % n)
    }
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    val min = min(n, m)
    val max = max(n, m)

    if (min == 0 && max == 0) {
        return true
    }

    var i = 1L
    var sqr = i * i
    while (sqr <= max) {
        if (sqr >= min) {
            return true
        }
        i++
        sqr = i * i
    }

    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int = collatzStep(x, 0)

fun collatzStep(x: Int, step: Int): Int {
    if (x == 1) {
        return step;
    }
    if (x % 2 == 0) {
        return collatzStep(x / 2, step + 1)
    } else {
        return collatzStep(x * 3 + 1, step + 1)
    }
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    if (n < 10) {
        return n
    }

    var k = n
    var m = 0

    while (k > 0) {
        m = m * 10 + k % 10
        k /= 10
    }

    return m
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    if (n < 0) {
        return false
    }

    var k = n
    var m = 0

    while (k > 0) {
        m = m * 10 + k % 10
        k /= 10
    }
    if (m == n) {
        return true
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    if (n < 10) {
        return false
    }
    val digit = n % 10
    var temp = n / 10
    do {
        if (temp % 10 != digit) {
            return true
        }
        temp /= 10
    } while (temp > 0)
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var index = 0
    var number = 0

    while (true) {
        number++
        val sq = number * number
        val length = getLength(value = sq, curLength = 0)

        if (length == 1 && index + 1 == n) {
            return sq
        } else if (length == 1) {
            index++
            continue
        }

        if (index + length < n) {
            index += length
            continue
        }

        return reverseGetAt(value = sq, curIndex = 0, reverseIndex = length - (n - index))
    }
}

fun getLength(value: Int, curLength: Int): Int {
    if (value < 10) {
        return curLength + 1
    }

    return getLength(value / 10, curLength + 1)
}

fun reverseGetAt(value: Int, curIndex: Int, reverseIndex: Int): Int {
    if (value < 10) {
        return value
    }
    if (curIndex == reverseIndex) {
        return value % 10
    }

    return reverseGetAt(value / 10, curIndex + 1, reverseIndex)
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 112_358_132_134_558_914_42...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var index = 0
    var fibNumber = 0

    while (true) {
        fibNumber++
        val fib = fib(fibNumber)

        if (fib < 10) {
            index++
            if (index == n) {
                return fib
            } else {
                continue
            }
        }

        var temp = fib
        var currentNumberIndexes = 1
        do {
            if (index + currentNumberIndexes == n) {
                return if (currentNumberIndexes == 1) {
                    revert(fib) % 10
                } else {
                    var k = fib
                    var length = 0

                    while (k > 0) {
                        k /= 10
                        length++
                    }

                    k = fib
                    var m = 0
                    var c = 0

                    while (k > 0) {
                        if (c == length + 1 - currentNumberIndexes) {
                            return m % 10
                        }
                        c++
                        m = m * 10 + k % 10
                        k /= 10
                    }

                    var multiplier = 1
                    for (i in 1 until currentNumberIndexes) {
                        multiplier *= 10
                    }
                    fib / multiplier % 10
                }
            }

            temp /= 10
            currentNumberIndexes++
        } while (temp > 0)

        currentNumberIndexes--
        index += currentNumberIndexes
    }
}
