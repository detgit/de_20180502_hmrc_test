package epl.hmrc.tillroll

import epl.hmrc.tillroll.TillRoll._


// Notes asked to used Doubles for values.

object TillRollMain {

  val costMap = Map[String, Double](("Apple", 60.0),
    ("Orange", 25.0))



  def main(args:Array[String]): Unit = {

    // Use args for quick and dirty tests, once happy with a test it can moved to the test suite.
    // 1) "" i.e nothing              0.00
    // 2) "Apple"                     0.60
    // 3) "Apple Apple"               1.20
    // 4) "Orange"                    0.25
    // 5) "Orange Orange"             0.50
    // 6) "Orange Apple Orange Apple" 1.90
    // for testing totalCostPence

    val tillItems = args.toList

    println("tillItems " + tillItems.mkString(" ") )

//    println("cost " + TillRoll.totalCostPence( TillRoll(tillItems, costMap)) )
    println("cost " + TillRoll.totalCostWithSpecialOffersPence( TillRoll(tillItems, costMap)) )
  }

}
