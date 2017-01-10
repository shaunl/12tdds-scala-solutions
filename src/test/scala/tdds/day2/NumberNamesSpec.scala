package tdds.day2

import org.scalatest.{FlatSpec, Matchers}

class NumberNamesSpec extends FlatSpec with Matchers {
  "19" should "return nineteen" in {
    NumberNames(19) shouldBe "nineteen"
  }

  "99" should "return ninety nine" in {
    NumberNames(99) shouldBe "ninety nine"
  }

  "300" should "return three hundred" in {
    NumberNames(300) shouldBe "three hundred"
  }

  "310" should "return three hundred and ten" in {
    NumberNames(310) shouldBe "three hundred and ten"
  }

  "1501" should "return one thousand, five hundred and one" in {
    NumberNames(1501) shouldBe "one thousand, five hundred and one"
  }

  "12609" should "return twelve thousand, six hundred and nine" in {
    NumberNames(12609) shouldBe "twelve thousand, six hundred and nine"
  }

  "512607" should "return five hundred and twelve thousand, six hundred and seven" in {
    NumberNames(512607) shouldBe "five hundred and twelve thousand, six hundred and seven"
  }

  "43112603 " should "return forty three million, one hundred and twelve thousand, six hundred and three" in {
    NumberNames(43112603) shouldBe "forty three million, one hundred and twelve thousand, six hundred and three"
  }

  "21243112603 " should "return twenty one billion, two hundred and forty three million, one hundred and twelve thousand, six hundred and three" in {
    NumberNames(21243112603L) shouldBe "twenty one billion, two hundred and forty three million, one hundred and twelve thousand, six hundred and three"
  }
}


/*
99 –> ninety nine
300 –> three hundred
310 –> three hundred and ten
1501 –> one thousand, five hundred and one
12609 –> twelve thousand, six hundred and nine
512607 –> five hundred and twelve thousand,
six hundred and seven
43112603 –> forty three million, one hundred and
twelve thousand,
six hundred and three
*/
