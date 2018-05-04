package epl.hmrc.tillroll


case class TillRoll( tillItems:List[String], costMap:Map[String, Double] )

object TillRoll {
  val APPLE = "Apple"
  val ORANGE = "Orange"

  def _totalCostPence(costTillRoll:( Double, TillRoll, List[String])  ) : ( Double, TillRoll, List[String]  ) =
  {
    val ( costSoFar, tillRoll, itemsSoFar ) = costTillRoll
    val totalCost = tillRoll.tillItems.foldLeft(costSoFar)( (cost, items)  => cost + tillRoll.costMap.get(items ).getOrElse( 0.0d )  )
    (totalCost, TillRoll( Nil, tillRoll.costMap), itemsSoFar ++ tillRoll.tillItems )
  }

  def totalCostPence( tillRoll:TillRoll  ) : Double =
  {
    val ( cost, _, _) = _totalCostPence( (0.0d, tillRoll, Nil) )
    ( cost )
  }

  def totalCostPound( tillRoll:TillRoll  ) : Double =
  {
    val cost = totalCostPence( tillRoll )
    ( cost/100.0 )
  }

  def totalCostWithSpecialOffersPence( tillRoll:TillRoll  ) : Double =
  {
    val (cost, _, _) = _totalCostWithSpecialOffersPence( ( 0.0d, tillRoll, Nil)  )
    (cost)
  }

  def totalCostWithSpecialOffersPound( tillRoll:TillRoll  ) : Double =
  {
    val cost = totalCostWithSpecialOffersPence( tillRoll )
    ( cost/100.0 )
  }

  def _totalCostWithSpecialOffersPence(costTillRoll:( Double, TillRoll, List[String])  ) : ( Double, TillRoll, List[String]  ) =
  {
    // Add in special offers here.
    val (cost, tillRollAfterOffers, itemsSoFar) = _totalCostPence(
      BuyOneAppleGetOneFree( costTillRoll ) )
    (cost, tillRollAfterOffers, itemsSoFar)
  }


  // Note we could add items into basket or assume basket never changes and we caclulate based on basket.
  // This is unclear from spec. Have One Apple get one free could mean we add another apple into the basket.
  // Alternative if we have a basket with 2 apples one of them should be free.

  def BuyOneAppleGetOneFree( costTillRoll:( Double, TillRoll, List[String]) ) : ( Double, TillRoll, List[String]  ) =
  {
    val ( costSoFar, tillRoll, itemsOutSoFar ) = costTillRoll
    val count = tillRoll.tillItems.count( _ == TillRoll.APPLE )
    val numApplesToPayFor = (count/2) + count%2
    val costApples = tillRoll.costMap(TillRoll.APPLE) * numApplesToPayFor
    val tillRollLeft = TillRoll( tillRoll.tillItems.filter( _ != TillRoll.APPLE ), tillRoll.costMap )
    val itemsOutAfter = itemsOutSoFar ++ List.fill(count)(TillRoll.APPLE)
      // This irrelevent if the basket canot be changed, but could be that we add 2 apples for each 1 then we would add them in here?.
    ( costSoFar + costApples, tillRollLeft, itemsOutAfter )
  }

}
