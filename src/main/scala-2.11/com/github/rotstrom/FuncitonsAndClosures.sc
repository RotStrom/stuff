"methods"

object LongLines {
  def processFile(filename: String, width: Int): Unit = {
    val source = scala.io.Source.fromFile(filename)
    for (line <- source.getLines()) processLine(filename, width, line)
  }

  private def processLine(filename: String, width: Int, line: String): Unit = {
    if (line.length > width) println(filename + ": " + line.trim)
  }
}

val path = ""
LongLines.processFile(path, 10)

