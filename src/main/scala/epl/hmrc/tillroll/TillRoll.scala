package epl.hmrc.tillroll


case class TillRoll( tillItems:List[String], costMap:Map[String, Double] )

object TillRoll {

  def totalCostPence( tillRoll:TillRoll  ) : Double =
  {
    tillRoll.tillItems.foldLeft(0.0d)( (cost, tillItem) => cost + tillRoll.costMap(tillItem)  )
  }

  def totalCostPound( tillRoll:TillRoll  ) : Double =
  {
    return totalCostPence( tillRoll)/100.0
  }


}
