abstract class Fruit(val name: String, val color: String)

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple, Orange, Pear)
}

def showFruit(fruit: Fruit): String = {
  import fruit._
  name + "s are " + color
}

import Fruits.Apple

showFruit(Apple)

import Fruits.{Apple => Macintosh, Orange}

showFruit(Macintosh)
showFruit(Orange)

//all except Pear
import Fruits.{Pear => _, _}

object A {
  private[this] val x = 10
  object B {
    println(x)
  }
}

A.B

//companion objects
class Rocket {
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20
}

object Rocket {
  private def fuel = 10
  def chooseStrategy(rocket: Rocket): Unit = {
    if (rocket.canGoHomeAgain)
      goHome()
    else pickAStar()
  }
  def goHome() {}
  def pickAStar() {}
}