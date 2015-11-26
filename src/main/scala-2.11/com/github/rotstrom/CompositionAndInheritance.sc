object Element {
  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)

  def elem(line: String): Element = new LineElement(line)
}

abstract class Element {

  import Element.elem

  def contents: Array[String]

  //without side-effects: leaving off parenthesis
  def height: Int = contents.length

  def width: Int = if (height == 0) 0 else contents(1).length

  def demo = "Element"

  def imperativeBeside(that: Element): Element = {
    val contents = new Array[String](this.contents.length)
    for (i <- 0 until this.contents.length)
      contents(i) = this.contents(i) + that.contents(i)
    new ArrayElement(contents)
  }

  def above(that: Element): Element =
    elem(this.contents ++ that.contents)

  def beside(that: Element): Element =
    elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      var right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      var bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"

}

//implicitly extends AnyRef (java.lang.Object)
class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts

  override def demo = "ArrayElement"
}

class ArrayElement2(conts: Array[String]) extends Element {
  val contents: Array[String] = conts

  override def demo = "ArrayElement2"
}

//two namespaces:
//-values (fields, methods, packages and singleton objects)
//-types (class and trait names)

val ae = new ArrayElement(Array("hello", "world"))
ae.width

val e: Element = new ArrayElement(Array("hello"))

//parametric field
class ArrayElement3(val contents: Array[String]) extends Element {
  final override def demo = "ArrayElement3"
}

//Invoking superclass constructor
class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length

  override def height = 1

  override def demo = "LineElement"
}

//Polymorphism and dynamic binding
final class UniformElement(ch: Char,
                           override val width: Int,
                           override val height: Int) extends Element {
  private val line = ch.toString * width

  def contents = Array.fill(height)(line)

  def demo2 = "UniformElement"
}

//dynamic binding
def invokeDemo(e: Element) = e.demo
invokeDemo(new ArrayElement(Array("hello")))
invokeDemo(new LineElement("hello"))
invokeDemo(new UniformElement('c', 2, 2))

object Spiral {
  import Element.elem

  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)
      def verticalBar = elem('|', 1, sp.height)
      def horizontalBar = elem('-', sp.width, 1)
      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }

  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}

Spiral.spiral(16, 0)