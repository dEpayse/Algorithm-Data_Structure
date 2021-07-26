import java.util.*

fun main() {
    // 입력값이 클수록 분할 정복(재귀 함수)에 걸리는 시간이 기하 급수적으로 오래 걸릴 것임.
    val scanner = Scanner(System.`in`)
    println("피보나치 수열의 몇 번째 값이 궁금하신가요?(숫자만 입력해주세요)")
    val num = scanner.nextInt()
    println("------------------------------------------")
    var beforeTime = System.currentTimeMillis()
    println("동적 계획법 결과값 : ${fibonacciDynamicProgramming(num)}")
    var afterTime = System.currentTimeMillis()
    println("걸린 시간 : ${afterTime-beforeTime} ms")
    println("------------------------------------------")
    beforeTime = System.currentTimeMillis()
    println("분할 정복 결과값: ${fibonacciDivideConquer(num)}")
    afterTime = System.currentTimeMillis()
    println("걸린 시간 : ${afterTime-beforeTime} ms")
    println("------------------------------------------")
}

// 동적 계획법(Dynamic Programming) - memoization 기법을 사용함
// 큰 문제를 작은 문제로 나누었을 때, 작은 문제의 결과값이 변하지 않을 때 사용가능
fun fibonacciDynamicProgramming(num: Int): Int {
    if (num <= 1) return num
    val fiboList = IntArray(num + 1)
    fiboList[0] = 0
    fiboList[1] = 1
    for (i in 2..num) {
        fiboList[i] = fiboList[i - 1] + fiboList[i - 2]
    }
    return fiboList[num]
}

// 분할 정복 - 계산 중복을 고려하지 않고 재귀 함수를 사용함 => 중복이 많음
fun fibonacciDivideConquer(num: Int): Int {
    // base case, termination case
    if (num <= 1) return num
    // recursive case
    return fibonacciDivideConquer(num - 1) + fibonacciDivideConquer(num - 2)
}