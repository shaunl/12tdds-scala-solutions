package tdds.day2

import language.implicitConversions
import annotation.tailrec

object NumberNames {

  def apply[T >: Long](number: T): String = {
    lazy val list = number.toString.toList.map(_.asDigit)
    toString(convertToStringList(list, list.length, Nil))
  }

  @tailrec
  def convertToStringList(list: List[Int], length: Int, acc: List[String]): List[String] = list match {
    case Nil => acc
    case x :: xs if length == 1 =>
      convertToStringList(Nil, 0, acc :+ singles.getOrElse(x, ""))
    case x :: xs if length == 2 =>
      convertToStringList(Nil, 0, acc ::: convertPairs((x, xs.head)))
    case x :: xs if length == 3 && xs.sum > 0 =>
      convertToStringList(xs, xs.length, acc :+ singles.getOrElse(x, "") :+ powersOfTen.getOrElse(length, "") :+ "and")
    case x :: xs if (5 to length by 3).contains(length) =>
      convertToStringList(xs.tail, xs.tail.length, (acc ::: convertPairs(x, xs.head)) :+ powersOfTen.getOrElse(length - 1, ""))
    case x :: xs if length > 5 && length % 3 == 0 =>
      convertToStringList(xs, xs.length, acc :+ singles.getOrElse(x, "") :+ powersOfTen.getOrElse(3, "") :+ "and")
    case x :: xs =>
      convertToStringList(xs, xs.length, acc :+ singles.getOrElse(x, "") :+ powersOfTen.getOrElse(length, ""))
  }

  private def convertPairs(numberPair: (Int, Int)): List[String] = {
    lazy val matchedPair = (numberPair._1.toString + numberPair._2.toString).toInt
    if (numberPair._1 + numberPair._2 > 0 && specialCases.contains(matchedPair))
      List(specialCases.getOrElse(matchedPair, ""))
    else if (numberPair._1 + numberPair._2 > 0)
      List(multiples.getOrElse(numberPair._1, ""), singles.getOrElse(numberPair._2, "")
      )
    else List("")
  }

  def toString(list: List[String]): String = {
    list.filter(_ != "").foldLeft("")(_ + " " + _).trim
  }

  val singles: Map[Int, String] = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six",
    7 -> "seven", 8 -> "eight", 9 -> "nine")

  val specialCases: Map[Int, String] = Map(11 -> "eleven", 12 -> "twelve", 13 -> "thirteen",
    14 -> "fourteen", 15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen",
    19 -> "nineteen")

  val multiples: Map[Int, String] = Map(1 -> "ten", 2 -> "twenty", 3 -> "thirty", 4 -> "forty", 5 -> "fifty",
    6 -> "sixty", 7 -> "seventy", 8 -> "eighty", 9 -> "ninety")

  val powersOfTen: Map[Int, String] = Map(3 -> "hundred", 4 -> "thousand,", 7 -> "million,", 10 -> "billion,",
    13 -> "trillion,", 16 -> "quadrillion,", 19 -> "quintillion,", 25 -> "septillion,", 28 -> "octillion,",
    31 -> "nonillion,", 34 -> "decillion,", 37 -> "undecillion,", 40 -> "duodecillion,", 43 -> "tredecillion,",
    46 -> "quattuordecillion,", 49 -> "quindecillion,", 52 -> "sexdecillion,", 55 -> "septendecillion,",
    58 -> "octodecillion,", 61 -> "novemdecillion,", 64 -> "vigintillion,")
}
