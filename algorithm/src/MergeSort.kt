import java.util.*

fun <T : Comparable<T>> mergeSort(list: List<T>): List<T> {
    fun splitAndMerge(frontList: List<T>, backList: List<T>): List<T> {
        //base case, termination case
        if (backList.isEmpty()) return frontList

        //recursive case
        val frontHalfIndex = frontList.lastIndex / 2 + 1
        val backHalfIndex = backList.lastIndex / 2 + 1
        val frontQueue = LinkedList(
            splitAndMerge(
                frontList.subList(0, frontHalfIndex),
                frontList.subList(frontHalfIndex, frontList.size)
            )
        )
        val backQueue = LinkedList(
            splitAndMerge(
                backList.subList(0, backHalfIndex),
                backList.subList(backHalfIndex, backList.size)
            )
        )

        //merge process
        val mergedList = mutableListOf<T>()
        var front: T? = frontQueue.poll()
        var back: T? = backQueue.poll()
        while (front != null || back != null) {
            if (front == null && back != null) {
                mergedList.add(back)
                back = backQueue.poll()
            } else if (back == null && front != null) {
                mergedList.add(front)
                front = frontQueue.poll()
            } else if (front != null && back != null) {
                if (front <= back) {
                    mergedList.add(front)
                    front = frontQueue.poll()
                } else {
                    mergedList.add(back)
                    back = backQueue.poll()
                }
            }
        }
        return mergedList
    }

    val halfIndex = list.lastIndex / 2 + 1
    return splitAndMerge(
        list.subList(0, halfIndex),
        list.subList(halfIndex, list.size)
    )
}

fun main() {
    val mixedList = listOf(49, 97, 53, 5, 33, 65, 62, 51)

    println("Do you want to use sample list? [y/n]")

    val sc = Scanner(System.`in`)
    while(true){
        when(sc.nextLine()){
            "y" -> {
                println(mergeSort(mixedList))
                println("Sorting Complete by merge sort")
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

                println(mergeSort(list))
                println("Sorting Complete by merge sort")
                break
            }
            else -> {
                println("please enter 'y' or 'n'")
            }
        }
    }
}