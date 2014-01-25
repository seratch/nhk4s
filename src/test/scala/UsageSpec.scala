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

    it("calls Genre API") {
      val programs = NHK.programs.findAllByGenre(Area.Tokyo, Service.Sogo1, "0000", today)
      println(programs.take(3))
      programs.size should be > 0
    }

    it("calls Info API") {
      val programs = NHK.programs.findAll(Area.Tokyo, Service.Sogo1, today)
      val program = NHK.programs.find(Area.東京, Service.Sogo1, programs.head.id)
      println(program)
      program.isDefined should be(true)
    }

    it("calls Now on Air API") {
      val nowOnAir = NHK.programs.findNowOnAir(Area.Tokyo, Service.OneSeg2)
      println(nowOnAir.take(3))
      nowOnAir.size should be(1)
    }

    it("calls Now on Air API for All Services") {
      val nowOnAir = NHK.programs.findNowOnAir(Area.広島, Service.全部)
      println(nowOnAir.take(3))
      nowOnAir.take(3).size should equal(3)
    }

  }

}
