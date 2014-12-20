## NHK4S

This is an "NHK 番組表 API" client library for Scala.

http://api-portal.nhk.or.jp/

http://api-portal.nhk.or.jp/ja/ServiceGuide


### How to use (sbt)

Just add nhk4s to your dependencies.

```scala
libraryDependencies += "com.github.seratch" %% "nhk4s" % "1.0.0"
```

Get API key on the NHK API portal site.

```
export NHK_API_KEY=xxxxxxxx
```

### Examples

#### Program List API

http://api-portal.nhk.or.jp/doc_list-v1_con

```scala
val programs = NHK.programs.findAll(Area.Tokyo, Service.Sogo1, today)
```

日本語でも使えます。

```scala
val 番組一覧 = NHK.番組表.番組一覧(エリア.東京, サービス.総合1, 今日)
```

#### Program Genre API

http://api-portal.nhk.or.jp/doc_genre-v1_con

```scala
val programsInGenre0000 = NHK.programs.findAllByGenre(Area.Nagoya, Service.ETele1, "0000", today)
```

日本語でも使えます。

```scala
val 番組一覧 = NHK.番組表.ジャンルで番組一覧(エリア.名古屋, サービス.Eテレ1, "0000", 今日)
```

#### Program Info API

http://api-portal.nhk.or.jp/doc_info-v1_con

```scala
val program = NHK.programs.find(Area.Okinawa, Service.FM, programs.head.id)
```

日本語でも使えます。

```scala
val 番組の詳細 = NHK.番組表.番組詳細(エリア.沖縄, サービス.FM, 番組.id)
```

#### Now On Air API

http://api-portal.nhk.or.jp/doc_now-v1_con

```scala
val nowOnAir = NHK.programs.findNowOnAir(Area.Hiroshima, Service.TV)
```

日本語でも使えます。

```scala
val 放送中 = NHK.番組表.放送中(エリア.広島, サービス.テレビ全部)
```

### License

Apache License, Version 2.0

Copyright 2014 Kazuhiro Sera


