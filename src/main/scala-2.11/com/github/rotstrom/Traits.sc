trait Philosophical {
  def philosophize(): Unit = {
    println("I consume memory")
  }
}

trait HasLegs

class Animal {
  override def toString = "I'm an animal"
}

class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"
  override def philosophize(): Unit = {
    println("It's hard to be " + toString)
  }
}

//test condition of trait
val phrog: Philosophical = new Frog
phrog.philosophize()
trait First {
  val x = "first"
}

trait Second {
  val x = "second"
}

class C extends First with Second {
  override val x = "C"
}

(new C).x
//test super in trait
trait HasEyes {
  def show = super.toString
}

class Bear extends Animal with HasEyes {
  override def toString = "Bear"
}

(new Bear).show
//////////////////////////
class Point(val x: Int, val y: Int)
class Rectangle(val topLeft: Point, val bottomRight: Point) {
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

abstract class Component {
  def topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

trait Rectangular {
  def topLeft: Point
  def bottomRight: Point
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

abstract class Component2 extends Rectangular
class Rectangle2(val topLeft: Point, val bottomRight: Point) extends Rectangular
val rect = new Rectangle2(new Point(1, 1), new Point(10, 10))
rect.left
rect.right
rect.width
//Ordered trait
class Rational(val n: Int, val d: Int) extends Ordered[Rational] {
  def compare(that: Rational) = n * that.d - that.n * d
}

val half = new Rational(1, 2)
val twoThirds = new Rational(2, 3)
half < twoThirds
//Traits as stackable modifications
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new scala.collection.mutable.ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) {
    buf += x
  }
}

val queue = new BasicIntQueue
queue.put(10)
queue.put(20)
queue.get()
queue.get()
/**
 * can only be mixed into a class that also extends IntQueue
 */
trait Doubling extends IntQueue {
  /**
   * must be mixed into some class that has a concrete definition of the method
   */
  abstract override def put(x: Int) {
    super.put(2 * x)
  }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = {
    super.put(x + 1)
  }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int): Unit = {
    if (x >= 0) super.put(x)
  }
}

//order make sense: mixins applying from right to left
class MyQueue extends BasicIntQueue with Doubling with Incrementing
val myQueue = new MyQueue
myQueue.put(10)
myQueue.put(20)
myQueue.get()
myQueue.get()
//even better:
val myQueue2 = new BasicIntQueue with Incrementing with Doubling
myQueue2.put(10)
myQueue2.put(20)
myQueue2.get()
myQueue2.get()
