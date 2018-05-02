package epl.hmrc.tillroll


case class TillRoll(tillItems:List[String] ) {

  def totalCostPence(  ) : Double =
  {
    return 0.0
  }

  def totalCostPound(  ) : Double =
  {
    return totalCostPence()
  }


}
