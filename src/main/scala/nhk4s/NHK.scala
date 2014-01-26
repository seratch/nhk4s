package nhk4s

import scala.io._
import org.json4s._
import nhk4s.programguide.v1._

object NHK {

  val API_BASE_URL = "http://api.nhk.or.jp"
  val DEFAULT_API_VERSION = "v1"

  val ENV_API_KEY = "NHK_API_KEY"

  // ---------------------
  // Service Master
  // ---------------------
  object Service {

    val 総合1 = "g1"
    val 総合2 = "g2"
    val Eテレ1 = "e1"
    val Eテレ2 = "e2"
    val Eテレ3 = "e3"
    val ワンセグ2 = "e4"
    val BS1 = "s1"
    val BS1_102ch = "s2"
    val BSプレミアム = "s3"
    val BSプレミアム_104ch = "s4"
    val ラジオ第1 = "r1"
    val ラジオ第2 = "r2"
    val FM = "r3"
    val ネットラジオ第1 = "n1"
    val ネットラジオ第2 = "n2"
    val ネットラジオFM = "n3"

    val テレビ = "tv"
    val ラジオ = "radio"
    val 全部 = "all"

    val Sogo1 = "g1"
    val Sogo2 = "g2"
    val E_Tele1 = "e1"
    val E_Tele2 = "e2"
    val E_Tele3 = "e3"
    val OneSeg2 = "e4"
    //val BS1 = "s1"
    //val BS1_102ch  = "s2"
    val BS_Premium = "s3"
    val BS_Premium_104ch = "s4"
    val Radio_1 = "r1"
    val Radio_2 = "r2"
    //val FM = "r3"
    val NetRadio_1 = "n1"
    val NetRadio_2 = "n2"
    val NetRadio_FM = "n3"

    val TV = "tv"
    val Radio = "radio"
    val All = "all"
  }

  // ---------------------
  // Area Master
  // ---------------------
  object Area {

    val 札幌 = programguide.v1.Area(10, "札幌")
    val 函館 = programguide.v1.Area(11, "函館")
    val 旭川 = programguide.v1.Area(12, "旭川")
    val 帯広 = programguide.v1.Area(13, "帯広")
    val 釧路 = programguide.v1.Area(14, "釧路")
    val 北見 = programguide.v1.Area(15, "北見")
    val 室蘭 = programguide.v1.Area(16, "室蘭")
    val 青森 = programguide.v1.Area(20, "青森")
    val 盛岡 = programguide.v1.Area(30, "盛岡")
    val 仙台 = programguide.v1.Area(40, "仙台")
    val 秋田 = programguide.v1.Area(50, "秋田")
    val 山形 = programguide.v1.Area(60, "山形")
    val 福島 = programguide.v1.Area(70, "福島")
    val 水戸 = programguide.v1.Area(80, "水戸")
    val 宇都宮 = programguide.v1.Area(90, "宇都宮")
    val 前橋 = programguide.v1.Area(100, "前橋")
    val さいたま = programguide.v1.Area(110, "さいたま")
    val 千葉 = programguide.v1.Area(120, "千葉")
    val 東京 = programguide.v1.Area(130, "東京")
    val 横浜 = programguide.v1.Area(140, "横浜")
    val 新潟 = programguide.v1.Area(150, "新潟")
    val 富山 = programguide.v1.Area(160, "富山")
    val 金沢 = programguide.v1.Area(170, "金沢")
    val 福井 = programguide.v1.Area(180, "福井")
    val 甲府 = programguide.v1.Area(190, "甲府")
    val 長野 = programguide.v1.Area(200, "長野")
    val 岐阜 = programguide.v1.Area(210, "岐阜")
    val 静岡 = programguide.v1.Area(220, "静岡")
    val 名古屋 = programguide.v1.Area(230, "名古屋")
    val 津 = programguide.v1.Area(240, "津")
    val 大津 = programguide.v1.Area(250, "大津")
    val 京都 = programguide.v1.Area(260, "京都")
    val 大阪 = programguide.v1.Area(270, "大阪")
    val 神戸 = programguide.v1.Area(280, "神戸")
    val 奈良 = programguide.v1.Area(290, "奈良")
    val 和歌山 = programguide.v1.Area(300, "和歌山")
    val 鳥取 = programguide.v1.Area(310, "鳥取")
    val 松江 = programguide.v1.Area(320, "松江")
    val 岡山 = programguide.v1.Area(330, "岡山")
    val 広島 = programguide.v1.Area(340, "広島")
    val 山口 = programguide.v1.Area(350, "山口")
    val 徳島 = programguide.v1.Area(360, "徳島")
    val 高松 = programguide.v1.Area(370, "高松")
    val 松山 = programguide.v1.Area(380, "松山")
    val 高知 = programguide.v1.Area(390, "高知")
    val 福岡 = programguide.v1.Area(400, "福岡")
    val 北九州 = programguide.v1.Area(401, "北九州")
    val 佐賀 = programguide.v1.Area(410, "佐賀")
    val 長崎 = programguide.v1.Area(420, "長崎")
    val 熊本 = programguide.v1.Area(430, "熊本")
    val 大分 = programguide.v1.Area(440, "大分")
    val 宮崎 = programguide.v1.Area(450, "宮崎")
    val 鹿児島 = programguide.v1.Area(460, "鹿児島")
    val 沖縄 = programguide.v1.Area(470, "沖縄")

    val Sapporo = programguide.v1.Area(10, "札幌")
    val Hakodate = programguide.v1.Area(11, "函館")
    val Hirokawa = programguide.v1.Area(12, "旭川")
    val Obihiro = programguide.v1.Area(13, "帯広")
    val Kushiro = programguide.v1.Area(14, "釧路")
    val Kitami = programguide.v1.Area(15, "北見")
    val Muroran = programguide.v1.Area(16, "室蘭")
    val Aomori = programguide.v1.Area(20, "青森")
    val Morioka = programguide.v1.Area(30, "盛岡")
    val Sendai = programguide.v1.Area(40, "仙台")
    val Akita = programguide.v1.Area(50, "秋田")
    val Yamagata = programguide.v1.Area(60, "山形")
    val Fukushima = programguide.v1.Area(70, "福島")
    val Mito = programguide.v1.Area(80, "水戸")
    val Utsunomiya = programguide.v1.Area(90, "宇都宮")
    val Maebashi = programguide.v1.Area(100, "前橋")
    val Saitama = programguide.v1.Area(110, "さいたま")
    val Chiba = programguide.v1.Area(120, "千葉")
    val Tokyo = programguide.v1.Area(130, "東京")
    val Yokohama = programguide.v1.Area(140, "横浜")
    val Niigata = programguide.v1.Area(150, "新潟")
    val Toyama = programguide.v1.Area(160, "富山")
    val Kanazawa = programguide.v1.Area(170, "金沢")
    val Fukui = programguide.v1.Area(180, "福井")
    val Koufu = programguide.v1.Area(190, "甲府")
    val Nagano = programguide.v1.Area(200, "長野")
    val Gifu = programguide.v1.Area(210, "岐阜")
    val Shizuoka = programguide.v1.Area(220, "静岡")
    val Nagoya = programguide.v1.Area(230, "名古屋")
    val Tsu = programguide.v1.Area(240, "津")
    val Otsu = programguide.v1.Area(250, "大津")
    val Kyoto = programguide.v1.Area(260, "京都")
    val Osaka = programguide.v1.Area(270, "大阪")
    val Kobe = programguide.v1.Area(280, "神戸")
    val Nara = programguide.v1.Area(290, "奈良")
    val Wakayama = programguide.v1.Area(300, "和歌山")
    val Tottori = programguide.v1.Area(310, "鳥取")
    val Matsue = programguide.v1.Area(320, "松江")
    val Okayama = programguide.v1.Area(330, "岡山")
    val Hiroshima = programguide.v1.Area(340, "広島")
    val Yamaguchi = programguide.v1.Area(350, "山口")
    val Tokushima = programguide.v1.Area(360, "徳島")
    val Takamatsu = programguide.v1.Area(370, "高松")
    val Matsuyama = programguide.v1.Area(380, "松山")
    val Kochi = programguide.v1.Area(390, "高知")
    val Fukuoka = programguide.v1.Area(400, "福岡")
    val Kitakyusyu = programguide.v1.Area(401, "北九州")
    val Saga = programguide.v1.Area(410, "佐賀")
    val Nagasaki = programguide.v1.Area(420, "長崎")
    val Kumamoto = programguide.v1.Area(430, "熊本")
    val Oita = programguide.v1.Area(440, "大分")
    val Miyazaki = programguide.v1.Area(450, "宮崎")
    val Kagoshima = programguide.v1.Area(460, "鹿児島")
    val Okinawa = programguide.v1.Area(470, "沖縄")

  }

  // ---------------------
  // Program Guide API
  // ---------------------

  def programs: NHKProgramGuideAPI = programsWithApiKey()
  def 番組表: NHKProgramGuideAPI = programs

  def programsWithApiKey(apiKey: String = System.getenv(ENV_API_KEY)): NHKProgramGuideAPI = new NHKProgramGuideAPI(apiKey)
  def 番組表withApiKey(apiKey: String = System.getenv(ENV_API_KEY)) = programsWithApiKey(apiKey)

  case class NHKProgramGuideAPI(apiKey: String) extends jackson.JsonMethods {

    if (apiKey == null) {
      throw new IllegalStateException(
        """
          | ***************** NHK API Key Required ************************
          |
          |  1. Go to http://api-portal.nhk.or.jp/ja and register new app.
          |  2. export NHK_API_KEY=(API key value)
          |
          | ***************************************************************
          |""".stripMargin)
    }

    protected implicit val jsonFormats: Formats = DefaultFormats ++ org.json4s.ext.JodaTimeSerializers.all

    def infoApiEndpoint(areaId: Int, serviceId: String, programId: Long): String = {
      s"${API_BASE_URL}/${DEFAULT_API_VERSION}/pg/info/${areaId}/${serviceId}/${programId}.json?key=${apiKey}"
    }

    def listApiEndpoint(areaId: Int, serviceId: String, date: LocalDate = today): String = {
      s"${API_BASE_URL}/${DEFAULT_API_VERSION}/pg/list/${areaId}/${serviceId}/${date.toString("yyyy-MM-dd")}.json?key=${apiKey}"
    }

    def genreApiEndpoint(areaId: Int, serviceId: String, genreId: String, date: LocalDate = today): String = {
      s"${API_BASE_URL}/${DEFAULT_API_VERSION}/pg/genre/${areaId}/${serviceId}/${genreId}/${date.toString("yyyy-MM-dd")}.json?key=${apiKey}"
    }

    def nowApiEndpoint(areaId: Int, serviceId: String): String = {
      s"${API_BASE_URL}/${DEFAULT_API_VERSION}/pg/now/${areaId}/${serviceId}.json?key=${apiKey}"
    }

    def find(area: Area, serviceId: String, programId: Long): Option[Program] = {
      val jsonResponse = Source.fromURL(infoApiEndpoint(area.id, serviceId, programId), "utf-8").mkString
      parseOpt(StringInput(jsonResponse))
        .map(v => v.camelizeKeys)
        .map(_ \ "list" \ serviceId)
        .map[List[_Program]](_.extract[List[_Program]])
        .getOrElse(Nil)
        .headOption
        .map(pg => Program(pg))
    }
    def 番組詳細(area: Area, serviceId: String, programId: Long): Option[Program] = find(area, serviceId, programId)

    def findNowOnAir(area: Area, serviceId: String): Seq[NowOnAirPrograms] = {
      val jsonResponse = Source.fromURL(nowApiEndpoint(area.id, serviceId), "utf-8").mkString
      parseOpt(StringInput(jsonResponse))
        .map(v => v.camelizeKeys)
        .map(_ \ "nowonairList")
        .map[Map[String, _NowOnAirPrograms]](_.extract[Map[String, _NowOnAirPrograms]])
        .map(_.values)
        .getOrElse(Nil).toSeq
        .map(n => NowOnAirPrograms(n))
    }
    def 放送中(area: Area, serviceId: String): Seq[NowOnAirPrograms] = findNowOnAir(area, serviceId)

    def findAll(area: Area, serviceId: String, date: LocalDate = today): Seq[Program] = {
      val jsonResponse = Source.fromURL(listApiEndpoint(area.id, serviceId, date), "utf-8").mkString
      parseOpt(StringInput(jsonResponse))
        .map(v => v.camelizeKeys)
        .map(_ \ "list" \ serviceId)
        .map[List[_Program]](_.extract[List[_Program]])
        .getOrElse(Nil)
        .map(pg => Program(pg))
    }
    def 番組一覧(area: Area, serviceId: String, date: LocalDate = today): Seq[Program] = findAll(area, serviceId, date)

    def findAllByGenre(area: Area, serviceId: String, genreId: String, date: LocalDate = today): Seq[Program] = {
      val jsonResponse = Source.fromURL(genreApiEndpoint(area.id, serviceId, genreId, date), "utf-8").mkString
      parseOpt(StringInput(jsonResponse))
        .map(v => v.camelizeKeys)
        .map(_ \ "list" \ serviceId)
        .map[List[_Program]](_.extract[List[_Program]])
        .getOrElse(Nil)
        .map(pg => Program(pg))
    }
    def ジャンルで番組一覧(area: Area, serviceId: String, genreId: String, date: LocalDate = today): Seq[Program] = {
      findAllByGenre(area, serviceId, genreId, date)
    }

  }

}

