import kotlin.math.max

fun main() {
    var tree= BinaryTree<Int>()
    for (i in (4 .. 8)){
        tree.add(i)
        tree.add(i+10)
    }
    println(tree.root?.value)
    println( tree.Height())

}

/*
var a=  intArrayOf(7,6,5,4,3)
    Selection_sort(a)
    for (i in a) print(i)

 */
fun Selection_sort(arr: IntArray) {
    var n :Int = arr.size-1
    var temp :Int
    for (i in arr){
        var IndexMax = 0
        for (j in  1 .. n){
            if (arr[j]>arr[IndexMax]){
                IndexMax =j
            }
        }
        if (n!= IndexMax){
            temp = arr[IndexMax]
            arr[IndexMax] = arr[n]
            arr[n]= temp
        }
        n-=1
    }
}

class BinaryTree<T:Comparable<T>>(){
     var root:Node<T>?=null

    class Node<T>(
        var value: T,
        var left : Node<T>?= null,
        var right: Node<T>?=null,
    )
    constructor(values: Iterable<T>) : this(){
        for (value in values){
            this.add(value)
        }
    }

    fun add(elem:T) : Boolean{
        if(root == null){

            root = Node(elem)
            return true
        }
        var current = root!!
        while(true){
            if(elem < current.value){
                if(current.left != null){
                    current = current.left!!
                }else{
                    current.left = Node(elem)
                    return true
                }
            }else if (elem > current.value){
                if(current.right != null){
                    current = current.right!!
                }else{
                    current.right = Node(elem)
                    return true
                }
            }else{
                return false
            }
        }
    }
    fun Height():Int{
        return height(root)
    }
    private fun height( root:Node<T>?): Int
    {
        if (root == null) {
            return 0;
        }

        return 1 + max(height(root.left), height(root.right))
    }
    fun see( ){
        root?.let { printRecursive( it) }
    }

    private fun printRecursive( node: Node<T>){
        node.left?.let { printRecursive ( it) }
        println(node.value)
        node.right?.let { printRecursive ( it) }
    }
}