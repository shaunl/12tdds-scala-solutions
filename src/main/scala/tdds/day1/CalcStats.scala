package tdds.day1

import scala.math.BigDecimal

class CalcStats(l: List[Int]) {
  def min: Int = l.min

  def max: Int = l.max

  def size: Int = l.size

  def avg: Double = BigDecimal(l.sum.toDouble / l.size).setScale(6, BigDecimal.RoundingMode.HALF_UP).toDouble
}

object CalcStats {
  def apply(l: List[Int]): CalcStats = new CalcStats(l)
}
