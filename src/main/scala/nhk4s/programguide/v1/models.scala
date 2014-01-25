package nhk4s.programguide.v1

import org.joda.time.DateTime

// @see http://api-portal.nhk.or.jp/ja

// ----------------------
// Program Guide API models
// ----------------------

case class Program(
  id: Long,
  eventId: Long,
  startTime: DateTime,
  endTime: DateTime,
  area: Area,
  service: Service,
  title: String,
  subtitle: String,
  genres: Seq[String],
  programLogo: Option[ProgramLogo] = None,
  hashtags: Seq[String] = Nil,
  programUrl: Option[String] = None)

case class ProgramLogo(url: String, width: Int, height: Int)

case class Area(id: Int, name: String)

case class Service(id: String, name: String, logoS: ServiceLogo, logoM: ServiceLogo, logoL: ServiceLogo)

case class ServiceLogo(url: String, width: Int, height: Int)

case class NowOnAirPrograms(
  previous: Program,
  present: Program,
  following: Program)

// ----------------------
// directly mapped from API
// ----------------------

case class _NowOnAirPrograms(
  previous: _Program,
  present: _Program,
  following: _Program)

case class _Program(
  id: String,
  eventId: String,
  startTime: String,
  endTime: String,
  area: _Area,
  service: _Service,
  title: String,
  subtitle: String,
  genres: Seq[String],
  programLogo: Option[_ProgramLogo] = None,
  hashtags: Seq[String] = Nil,
  programUrl: Option[String] = None)

case class _ProgramLogo(url: String, width: String, height: String)

case class _Area(id: String, name: String)

case class _Service(id: String, name: String, logoS: _ServiceLogo, logoM: _ServiceLogo, logoL: _ServiceLogo)

case class _ServiceLogo(url: String, width: String, height: String)

object NowOnAirPrograms {
  def apply(n: _NowOnAirPrograms) = new NowOnAirPrograms(
    Program(n.previous), Program(n.present), Program(n.following))
}
object Program {
  def apply(pg: _Program): Program = new Program(
    id = pg.id.toLong,
    eventId = pg.eventId.toLong,
    startTime = DateTime.parse(pg.startTime),
    endTime = DateTime.parse(pg.endTime),
    area = Area(pg.area),
    service = Service(pg.service),
    title = pg.title,
    subtitle = pg.subtitle,
    genres = pg.genres,
    programLogo = pg.programLogo.map(pl => ProgramLogo(pl)),
    hashtags = pg.hashtags,
    programUrl = pg.programUrl
  )
}

object ProgramLogo {
  def apply(s: _ProgramLogo) = new ProgramLogo(s.url, s.width.toInt, s.height.toInt)
}

object Area {
  def apply(a: _Area) = new Area(a.id.toInt, a.name)
}

object Service {
  def apply(s: _Service) = new Service(s.id, s.name, ServiceLogo(s.logoS), ServiceLogo(s.logoM), ServiceLogo(s.logoL))
}

object ServiceLogo {
  def apply(s: _ServiceLogo) = new ServiceLogo(s.url, s.width.toInt, s.height.toInt)
}
