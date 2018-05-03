package epl.hmrc.tillroll


import org.scalatest.FunSuite
import epl.hmrc.tillroll.TillRoll._


class TillRollTest extends FunSuite {

  val costMap = Map[String, Double](("Apple", 60.0),
    ("Orange", 25.0))


  test("No items on TillRoll") {
    val tillItems:List[String] = Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 0.0 )
  }

  test(" (Apple) on TillRoll") {
    val tillItems:List[String] = "Apple" :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 60.0 )
  }

  test(" (Apple Apple) on TillRoll") {
    val tillItems:List[String] = "Apple" :: "Apple" :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 120.0 )
  }

  test(" (Orange) on TillRoll") {
    val tillItems:List[String] = "Orange" :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 25.0 )
  }

  test(" (Orange Orange) on TillRoll") {
    val tillItems:List[String] = "Orange" :: "Orange" :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 50.0 )
  }

  test(" (Apple Orange) on TillRoll") {
    val tillItems:List[String] = "Apple" :: "Orange" :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test(" (Orange Apple) on TillRoll") {
    val tillItems:List[String] = "Orange" :: "Apple" :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

}
