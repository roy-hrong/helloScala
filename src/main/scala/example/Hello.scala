package example

import scala.collection.mutable.ArrayBuffer

object Hello extends App {

    def asciiDisplay(root: TreeNode[String]): Seq[String] = {
        val list = ArrayBuffer[String](s"+-${root.data}")

        def parser(child: TreeNode[String], level: Int, pre: String): Unit = {
            list += s"$pre+-${child.data}"
            child.children.foreach(parser(_, level + 1, pre + "|  "))
        }

        root.children.foreach(parser(_, 1, "  "))
        list
    }

    asciiDisplay(
        TreeNode("root", List(
            TreeNode("1", List(TreeNode("1-1"), TreeNode("1-2", List(TreeNode("1-2-1"), TreeNode("1-2-2", List(TreeNode("1-2-2-1"), TreeNode("1-2-2-2"))))),TreeNode("1-3"))),
            TreeNode("2", List(TreeNode("2-1"), TreeNode("2-2"), TreeNode("2-3"))),
            TreeNode("3", List(TreeNode("3-1"), TreeNode("3-2"))),
            TreeNode("4"))))
            .foreach(println)
}

case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)
