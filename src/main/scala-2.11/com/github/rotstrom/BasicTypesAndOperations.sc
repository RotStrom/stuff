//hex
val hex = 0x5
val hex2 = 0x00FF
val magic = 0xcafebabe

//octal has been deprecated in 2.10 and removed in 2.11
//val oct = 035
val prog = 0xCAFEBABEL
val tower = 35L
val of = 31l
val little: Short = 367
val littler: Byte = 38
val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45
val littleFloat = 1.2345F
val littleBiggerFloat = 2e5f
val anotherDouble = 3e5
val yetAnotherDouble = 3e5D

//chars
val a = 'A'
val c = '\101'
val d = '\u0041'
val f = '\u0044'
val b = '\\'

//strings
val hello = "hello"
val escapes = "\\\"\'"
"""very
  |nice"""
"""even
  |nicer
""".stripMargin

//symbols
val s = 'cymbal
s.name

//operators are just methods using in operator notation
val sum = 1 + 2
val sum2 = (1).+(2)
val longSum = 1L + 2
val longSum2 = 2 + 1L

//operator notation
val s1 = "hello"
s1.indexOf('o') // not operator - method
s1 indexOf 'o' // operator
s1 indexOf('o', 2)

//prefix and postfix are unary (one operand)
//prefix - method name before object on which invoking the method
-7
//same as:
(7).unary_-
//postfix - after
7 toLong
//infix - two operands - left method right

//allowed prefix operators: +, -, !, ~
//ex: unary_* - not allowed

//leave off epmpty parenthesis method call
"Hello".toLowerCase()
"Hello".toLowerCase
"Hello" toLowerCase

// logical operations are short-circuited,
// by-name parameter evaluation:
/*
def salt = {println("salt"); false}
def pepper = {println("pepper"); true}
pepper && salt
salt && pepper
*/

//bitwise: &, |, ^(xor), ~(unary bitwise complement operator)
//available for integer types
~1
//shifting: <<, >>, >>>(unsigned shift right)
-1 >> 31
-1 >>> 31
1 << 2

//object equality (value)
1 == 1
1 != 2
List(1, 2, 3) == List(1, 2, 3)
1 == 1.0
"he" + "ll" == "hell"
null == null
//reference equality
List(1) eq List(1)

//operator precedence (by first character of a method name)
// (all other special characters)
// */%
// +-
// :
// =!
// <>
// &
// ˆ
// |
// (all letters)
// (all assignment operators: =, +=, *=, ...)
2 + 2 << 2
2 << 2 + 2

//associativity: if ':' is the last char from right to left
//a ::: b ~ { val x = a; b.:::(x) }
//a ::: b ::: c ~ a ::: (b ::: c)
//otherwise - from right to left
//a * b * c ~ (a * b) * c

//rich operations - implicit operations - rich wrappers
(1.0 / 0) isInfinity //RichDouble

//conclusion: operators are method calls
