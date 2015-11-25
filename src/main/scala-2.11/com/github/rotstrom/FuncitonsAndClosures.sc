val File = "/home/alex/dev/stuff/stuff/src/main/scala-2.11/com/github/rotstrom/FuncitonsAndClosures.sc"
val Width = 80
def doStuff(): Unit = {}
val someNumbers = List(1, 2, 3, 4, 5)
"methods"

object LongLines {
  def processFile(filename: String, width: Int): Unit = {
    val source = scala.io.Source.fromFile(filename)
    val shortFilename = filename.split(java.io.File.separator).last
    for (line <- source.getLines()) processLine(shortFilename, width, line)
  }

  private def processLine(filename: String, width: Int, line: String): Unit = {
    if (line.length > width) println(filename + ": " + line.trim)
  }
}

LongLines.processFile(File, Width)
"local functions"

object LongLinesLocalFunctuions {
  def processFile(filename: String, width: Int): Unit = {
    val source = scala.io.Source.fromFile(filename)
    val shortFilename = filename.split(java.io.File.separator).last

    def processLine(line: String): Unit = {
      if (line.length > width) println(shortFilename + ": " + line.trim)
    }

    for (line <- source.getLines()) processLine(shortFilename)
  }
}

LongLinesLocalFunctuions.processFile(File, Width)
"first-class functions (function literals)"
val increase = (x: Int) => x + 1
increase(10)
"multiple statemets"
val increase2 = (x: Int) => {
  doStuff()
  x + 1
}
"usage in foreach"
someNumbers.foreach((x: Int) => println(x))
"usage in filter"
someNumbers.filter((x: Int) => x > 3)
"short forms of function literals"
"omitting types (type inference)"
someNumbers.filter(x => x > 3)
"placeholder syntax (underscore)"
someNumbers.filter(_ > 3)
val f = (_: Int) + (_: Int)
f(5, 10)
"partially applied functions"
someNumbers.foreach(println(_))
someNumbers.foreach(println _)
def sum(a: Int, b: Int, c: Int) = a + b + c
val a = sum _
a.apply(1, 2, 3)
a(1, 2, 3)
val b = sum(1, _: Int, 3)
b(2)
"closures"
val more = 1
val addMore = (x: Int) => x + more
addMore(10)
"special function call forms"
"repeated parameters"
def echo(args: String*) = for (arg <- args) println(arg)
echo()
echo("lol")
echo("lol", "lol2")
echo(Array("lol", "lol2"): _*)
"named arguments (allowing different paremeters order)"
def speed(distance: Float, time: Float) = distance / time
speed(100, 10)
speed(time = 10, distance = 100)
"default parameter values"
def speed2(distance: Float = 100, time: Float = 10) = distance / time
speed2(100)
speed2(time = 50)
"tail recursion"
def isGoodEnough(guess: Double): Boolean = math.abs(guess) < 1
def improve(guess: Double): Double = guess / 2
def approximate(guess: Double): Double =
  if (isGoodEnough(guess)) guess
  else approximate(improve(guess))
"tracing tail-recursive functions"
//not tail-recursive due to increment (boom(x-1)+1)
def boom(x: Int): Int =
  if (x == 0) throw new Exception("boom!")
  else boom(x - 1) + 1
//tail-recursive, executes in a single stack-frame (could be disabled with -g:notailcalls)
def boom2(x: Int): Int =
  if (x == 0) throw new Exception("boom!")
  else boom2(x - 1)
"limits of tail recursion"
"no optimization: indirect recursion"
def isEven(x: Int): Boolean = if (x == 0) true else isOdd(x - 1)
def isOdd(x: Int): Boolean = if (x == 0) false else isEven(x - 1)
"no optimization: final call - function value"
val funValue = nestedFun _
def nestedFun(x: Int) {
  if (x != 0) {
    println(x); funValue(x - 1)
  }
}












