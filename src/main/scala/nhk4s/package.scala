import org.joda.time.LocalDate

package object nhk4s {

  val Area = NHK.Area
  val エリア = Area
  val Service = NHK.Service
  val サービス = Service

  type LocalDate = org.joda.time.LocalDate
  type DateTime = org.joda.time.DateTime

  def tomorrow: LocalDate = LocalDate.now().plusDays(1)
  def today: LocalDate = LocalDate.now()
  def yesterday: LocalDate = LocalDate.now().minusDays(1)

  def 明日 = tomorrow
  def 今日 = today
  def 昨日 = yesterday

}
