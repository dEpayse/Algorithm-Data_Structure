import java.util.*

// 퀵 정렬 함수 제네릭하게 구현
fun <T : Comparable<T>> quickSort(list: List<T>): List<T> {
    // base case, termination case
    if (list.size == 1 || list.isEmpty()) return list

    val pivot = list[0]
    val smallerList = mutableListOf<T>()
    val largerList = mutableListOf<T>()
    for (i in list.subList(1, list.size)) {
        if (i <= pivot) {
            smallerList.add(i)
        } else {
            largerList.add(i)
        }
    }

    // recursive case
    return quickSort(smallerList) + pivot + quickSort(largerList)
}

fun main() {
    val mixedList = listOf(49, 97, 53, 5, 33, 65, 62, 51)

    println("Do you want to use sample list? [y/n]")

    val sc = Scanner(System.`in`)
    while(true){
        when(sc.nextLine()){
            "y" -> {
                println(quickSort(mixedList))
                println("Sorting Complete by quick sort")
                break
            }
            "n" -> {
                println("Enter 'numbers separating by space' and press 'enter button'")

                var list: List<Int>

                while(true){
                    try {
                        list = sc.nextLine().split(" ").let {
                            val numList = mutableListOf<Int>()
                            for (numStr in it) {
                                numList.add(numStr.toInt())
                            }
                            numList
                        }
                        break
                    } catch (e : Exception) {
                        println("please enter 'numbers separating by space' and press 'enter button'")
                    }
                }

                println(quickSort(list))
                println("Sorting Complete by quick sort")
                break
            }
            else -> {
                println("please enter 'y' or 'n'")
            }
        }
    }
}