## NHK4S

This is an "NHK 番組表 API" client library for Scala.

http://api-portal.nhk.or.jp/ja

### How to use

```scala
libraryDependencies += "com.github.seratch" %% "nhk4s" % "0.1.0"
```

### Examples

Get API key on the NHK API portal site.

```
export NHK_API_KEY=xxxxxxxx
```

#### Program List API

http://api-portal.nhk.or.jp/doc_list-v1_con

```scala
val programs = NHK.programs.findAll(Area.Tokyo, Service.Sogo1, today)
```

#### Program Genre API

http://api-portal.nhk.or.jp/doc_genre-v1_con

```scala
val programsInGenre0000 = NHK.programs.findAllByGenre(Area.Tokyo, Service.Sogo1, "0000", today)
```

#### Program Info API

http://api-portal.nhk.or.jp/doc_info-v1_con

```scala
val program = NHK.programs.find(Area.東京, Service.Sogo1, programs.head.id)
```
#### Now On Air API

http://api-portal.nhk.or.jp/doc_now-v1_con

```scala
val nowOnAir = NHK.programs.findNowOnAir(Area.東京, Service.総合1)
```

### License

Apache License, Version 2.0

Copyright 2014 Kazuhiro Sera


