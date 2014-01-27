import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class UsageSpec extends FunSpec with ShouldMatchers {

  import nhk4s._

  describe("nhk4s") {

    it("calls List API") {
      val programs = NHK.programs.findAll(Area.Tokyo, Service.Sogo1, today)
      println(programs.take(3))
      programs.size should be > 0
    }

    it("calls 番組一覧 API") {
      val 番組一覧 = NHK.番組表.番組一覧(エリア.東京, サービス.総合1, 今日)
      println(番組一覧.take(3))
      番組一覧.size should be > 0
    }

    it("calls Genre API") {
      val programs = NHK.programs.findAllByGenre(Area.Nagoya, Service.Sogo2, "0000")
      println(programs.take(3))
      programs.size should be > 0
    }

    it("calls ジャンルで番組表 API") {
      val 番組一覧 = NHK.番組表.ジャンルで番組一覧(エリア.名古屋, サービス.総合2, "0000", 今日)
      println(番組一覧.take(3))
      番組一覧.size should be > 0
    }

    it("calls Info API") {
      val programs = NHK.programs.findAll(Area.Kyoto, Service.ETele1, today)
      val program = NHK.programs.find(Area.Kyoto, Service.ETele1, programs.head.id)
      println(program)
      program.isDefined should be(true)
    }

    it("calls 番組詳細 API") {
      val 見つかったの = NHK.番組表.番組一覧(エリア.沖縄, サービス.FM, 明日)
      val 詳細 = NHK.番組表.番組詳細(エリア.沖縄, サービス.FM, 見つかったの.head.id)
      println(詳細)
      詳細.isDefined should be(true)
    }

    it("calls Now on Air API") {
      val nowOnAir = NHK.programs.findNowOnAir(Area.Hiroshima, Service.TV)
      println(nowOnAir.take(3))
      nowOnAir.size should be > 0
    }

    it("calls 放送中 API") {
      val 放送中 = NHK.番組表.放送中(エリア.広島, サービス.テレビ全部)
      println(放送中.take(3))
      放送中.take(3).size should equal(3)
    }

  }

}
