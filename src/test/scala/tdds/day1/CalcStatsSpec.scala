package tdds.day1

import org.scalatest.{FlatSpec, Matchers}

class CalcStatsSpec extends FlatSpec with Matchers {
  /*o) minimum value = -2
  o) maximum value = 92
  o) number of elements in the sequence = 6
  o) average value = 21.833333*/
  val calcStats = CalcStats(List(6, 9, 15, -2, 92, 11))

  "min" should "return the minimum value in a list" in {
    calcStats.min shouldBe -2
  }

  "max" should "return the maximum value in a list" in {
    calcStats.max shouldBe 92
  }

  "size" should "return the number of values in a list" in {
    calcStats.size shouldBe 6
  }

  "avg" should "return the average of values in a list" in {
    calcStats.avg shouldBe 21.833333
  }
}
