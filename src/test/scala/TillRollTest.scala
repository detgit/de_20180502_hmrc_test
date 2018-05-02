package epl.hmrc.tillroll


import org.scalatest.FunSuite
import epl.hmrc.tillroll.TillRoll._

class TillRollTest extends FunSuite {
  test("No items on TillRoll") {
    val l:List[String] = Nil
    val emptyTillRoll = TillRoll(l)
    val tillRollTotal = emptyTillRoll.totalCostPence()

    assert( tillRollTotal == 0.0 )
  }

  test("Apple on TillRoll") {
    val l:List[String] = "Apple" :: Nil
    val emptyTillRoll = TillRoll( l )
    val tillRollTotal = emptyTillRoll.totalCostPence()

    assert( tillRollTotal == 60.0 )
  }

}
