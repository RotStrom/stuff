def doSomething(): Unit = {}
def doSomethingWith(obj: Any*): Unit = {}
"if expression returns value"
val condition = false
val x = if (condition) 1 else 2
"while loop doesn't return a value (returns a Unit value)"
def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}
"do while loop also doesn't return a value (returns a Unit value)"
def readLine() = {
  var line = ""
  do {
    line = ""
    println("Read: " + line)
  } while (line != "")
}
"functional style gcd (recursive)"
def gcd(x: Long, y: Long): Long = {
  if (y == 0) x else gcd(y, x % y)
}
"for expression"
val files = Array("file1.sc", "file2.sc", "file3.scala")
for (file <- files) doSomethingWith(file)
"range example"
for (i <- 1 to 4) doSomethingWith(i)
"without upper bound"
for (i <- 1 until 4) doSomethingWith(i)
"filtering"
for (file <- files if file.endsWith(".scala")) doSomethingWith(file)
for (file <- files) if (file.endsWith(".scala")) doSomethingWith(file)
"several filters"
for (file <- files if file.nonEmpty if file.endsWith(".scala")) doSomethingWith(file)
"nested iteration"
for (file <- files; line <- file.split("\n")) doSomethingWith(file, line)
"nested iteration with filters"
for (file <- files if file.endsWith(".scala");
     line <- file.split("\n") if line.contains("something"))
  doSomethingWith(file, line)
"mid stream assignment in for expression"
def grep(pattern: String) = {
  for {file <- files
       if file.endsWith(".scala")
       line <- file.split("\n")
       trimmed = line.trim
       if trimmed.contains(pattern)
  } doSomethingWith(file, line)
}
"producing new collection with for yield"
def scalaFiles = for {file <- files if file.endsWith(".scala")} yield file
def scalaFiles2 = for (file <- files if file.endsWith(".scala")) yield file
"throwing exceptions"
val n = 2
val half = if (n % 2 == 0) n / 2 else throw new RuntimeException("n must be even")
"handling exceptions"
try {
  doSomethingWith(half)
} catch {
  case ex: RuntimeException => "pity"
  case ex: Exception => throw ex
} finally {
  doSomething()
}
"yielding a value"
def f(): Int = try {
  return 1
} finally return 2
def g(): Int = try 1 finally 2
f()
g()
"match expressions, result a value"
"butter" match {
  case "salt" => "pepper"
  case "chips" => "salsa"
  case _ => "huh?"
}
"scoping allows to define variable with the same name - shadowing"
val a = 1; {
  val a = 2;
  {
    doSomethingWith(a)
  }
}
"imperative-style function"
def printMultiTable(): Unit = {
  var i = 1
  while (i <= 10) {
    var j = 1
    while (j <= 10) {
      val prod = (i * j).toString
      var k = prod.length
      while (k < 4) {
        print(" ")
        k += 1
      }
      print(prod)
      j += 1
    }
    println()
    i += 1
  }
}

printMultiTable()

"functional style"
def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }
def makeRow(row: Int) = makeRowSeq(row).mkString
def multiTable() = {
  val tableSeq = for (row <- 1 to 10) yield makeRow(row)
  tableSeq.mkString("\n")
}
multiTable()