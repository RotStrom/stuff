import scala.util.Try

//n: numerator, d: denominator
class Rational(n: Int, d: Int) {
  require(d != 0)
  //  println("Created " + this.toString)
  private val g = gcd(n.abs, d.abs)

  private def gcd(a: Int, b: Int): Int = {
    //recursive functions must have explicit types
    if (b == 0) a else gcd(b, a % b)
  }

  val numerator = n / g
  val denominator = d / g

  def this(n: Int) {
    //first statement must be call to another constructor
    this(n, 1)
  }

  def lessThan(that: Rational): Boolean = {
    this.numerator * that.denominator < that.numerator * this.denominator
  }

  def max(that: Rational): Rational = {
    if (this.lessThan(that)) that else this
  }

  def add(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )
  }

  def +(that: Rational): Rational = {
    this.add(that)
  }

  def +(i: Int): Rational = {
    new Rational(numerator + i * denominator, denominator)
  }

  def -(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator)
  }

  def -(i: Int) = {
    new Rational(numerator - i * denominator, denominator)
  }

  def *(that: Rational): Rational = {
    new Rational(numerator * that.numerator, denominator * that.denominator)
  }

  def *(i: Int): Rational = {
    new Rational(numerator * i, denominator)
  }

  def /(that: Rational): Rational = {
    new Rational(numerator * that.denominator, denominator * that.numerator)
  }

  def /(i: Int): Rational = {
    new Rational(numerator, i * denominator)
  }

  def unary_-(): Rational = {
    new Rational(-numerator, denominator)
  }

  override def toString = numerator + "/" + denominator
}

implicit def intToRational(x: Int): Rational = new Rational(x)

"usage"
"creation"
val oneHalf = new Rational(1, 2)
val twoThirds = new Rational(2, 3)
"precondition"
Try {
  val impossible = new Rational(5, 0)
}
val possible = new Rational(0, 5)
"add"
oneHalf add oneHalf
oneHalf add twoThirds
"accessing fields"
oneHalf.numerator
oneHalf.denominator
"less than"
oneHalf lessThan twoThirds
"max"
oneHalf max twoThirds
"using auxilary constructors"
new Rational(5)
"testing simplifying"
new Rational(66, 42)
"operator +"
oneHalf + twoThirds
oneHalf.+(twoThirds)
"operator *"
oneHalf * twoThirds
"composing operators"
oneHalf + twoThirds * twoThirds
"unary -"
-oneHalf
"overloading methods"
oneHalf * 2
oneHalf - 1
"implicit conversion"
2 * oneHalf
oneHalf * 2
"complex example"
(oneHalf / 7) + (1 - twoThirds)
"comparing does not work without overriding equals and hashcode"
new Rational(1, 2) == new Rational(1, 2)