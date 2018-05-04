package epl.hmrc.tillroll


import org.scalatest.FunSuite
import epl.hmrc.tillroll.TillRoll._


class TillRollTest extends FunSuite {


  // test no special offers.

  val costMap = Map[String, Double]((TillRoll.APPLE, 60.0),
    (TillRoll.ORANGE, 25.0))


  test("No items on TillRoll") {
    val tillItems:List[String] = Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 0.0 )
  }

  test(" (Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 60.0 )
  }

  test(" (Apple Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 120.0 )
  }

  test(" (Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 25.0 )
  }

  test(" (Orange Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 50.0 )
  }

  test(" (Apple Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test(" (Orange Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  // test special offers apples only.

  test("Special offers apples only. No items on TillRoll") {
    val tillItems:List[String] = Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 0.0 )
  }

  test("Special offers apples only. (Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 60.0 )
  }

  test("Special offers apples only. (Apple Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 60.0 )
  }

  test("Special offers apples only. (Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 25.0 )
  }

  test("Special offers apples only. (Orange Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 50.0 )
  }

  test("Special offers apples only. (Apple Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test("Special offers apples only. (Orange Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test("Special offers apples only. (Apple Apple Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.APPLE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test("Special offers apples only. (Apple Apple Orange Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.APPLE :: TillRoll.ORANGE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 145.0 )
  }

  // test special offers apples and oranges.

  test("Special offers apples and oranges. No items on TillRoll") {
    val tillItems:List[String] = Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 0.0 )
  }

  test("Special offers apples and oranges. (Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 60.0 )
  }

  test("Special offers apples and oranges. (Apple Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 60.0 )
  }

  test("Special offers apples and oranges. (Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 25.0 )
  }

  test("Special offers apples and oranges. (Orange Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 50.0 )
  }

  test("Special offers apples and oranges. (Orange Orange Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.ORANGE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 50.0 )
  }

  test("Special offers apples and oranges. (Orange Orange Orange Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.ORANGE :: TillRoll.ORANGE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 75.0 )
  }

  test("Special offers apples and oranges. (Apple Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test("Special offers apples and oranges. (Orange Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.ORANGE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test("Special offers apples and oranges. (Apple Apple Orange) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.APPLE :: TillRoll.ORANGE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 85.0 )
  }

  test("Special offers apples and oranges. (Apple Apple Orange Orange Orange Orange Apple) on TillRoll") {
    val tillItems:List[String] = TillRoll.APPLE :: TillRoll.APPLE :: TillRoll.ORANGE :: TillRoll.ORANGE :: TillRoll.ORANGE :: TillRoll.ORANGE :: TillRoll.APPLE :: Nil
    val tillRoll = TillRoll(tillItems, costMap)
    val tillRollTotal = TillRoll.totalCostWithSpecialOffersPence( tillRoll )

    assert( tillRollTotal == 195.0 )
  }

}
