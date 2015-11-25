object FileMatcher {
  private def files = List("file1", "file2", "file3.scala")

  def filesEnding(query: String) = for (file <- files; if file.endsWith(query)) yield file

  def filesContaining(query: String) = for (file <- files; if file.contains(query)) yield file

  def filesRegex(query: String) = for (file <- files; if file.matches(query)) yield file
}

object FileMatcherImprovement {
  private def files = List("file1", "file2", "file3.scala")

  def filesMatching(query: String, matcher: (String, String) => Boolean) =
    for (file <- files; if matcher(file, query)) yield file

  def filesEnding(query: String) = filesMatching(query, _.endsWith(_))

  def filesContaining(query: String) = filesMatching(query, _.contains(_))

  def filesRegex(query: String) = filesMatching(query, _.matches(_))
}

object FileMatcherImprovement2 {
  private def files = List("file1", "file2", "file3.scala")

  def filesMatching(matcher: String => Boolean) =
    for (file <- files; if matcher(file)) yield file

  def filesEnding(query: String) = filesMatching(_.endsWith(query))

  def filesContaining(query: String) = filesMatching(_.contains(query))

  def filesRegex(query: String) = filesMatching(_.matches(query))
}

FileMatcher.filesEnding(".scala")
FileMatcherImprovement.filesEnding(".scala")
FileMatcherImprovement2.filesEnding(".scala")

"currying"
def plainOlsSum(x: Int, y: Int) = x + y
plainOlsSum(1, 2)
def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)
def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2)
val onePlus = curriedSum(1) _
onePlus(2)
"new control structures"
def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 1, 5)
def withPrintWriter(file: java.io.File, op: java.io.PrintWriter => Unit): Unit = {
  val writer = new java.io.PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
withPrintWriter(
  new java.io.File("date.txt"),
  writer => writer.println(new java.util.Date)
)
println("hello")
"one argument - using curly braces"
println {
  "hello"
}
//curly braces not allowed with more than one argument: "hello".substring{1, 3}
"currying"
def withPrintWriterCur(file: java.io.File)(op: java.io.PrintWriter => Unit): Unit = {
  val writer = new java.io.PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
withPrintWriterCur(new java.io.File("date.txt")) {
  writer => writer.println(new java.util.Date)
}
"by name parameters"
val assertionsEnabled = false
def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate()) println("fail")
myAssert(() => 5 > 3)
//myAssert(5 > 3) not works
def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate) println("fail")
def boolAssert(predicate: Boolean): Unit = {
  if (assertionsEnabled && ! predicate) println("fail")
}

byNameAssert(5 > 3)
myAssert(() => 1/0 == 0)
byNameAssert(1/0 == 0)
try {
  boolAssert(1/0 == 0)
} catch {
  case _: Throwable =>
}