#### npm 사이트  https://www.npmjs.com/

https://medium.com/withj-kr/nodejs-express%EB%A1%9C-%EC%84%9C%EB%B2%84-%EA%B5%AC%EC%84%B1%ED%95%98%EA%B8%B0-1-express-%EA%B8%B0%EB%B3%B8%EA%B8%B0-c0245b4120bc 참고





아마존 웹서비스 가입 (도시를 서울로 변경)

#### aws 데이터베이스 생성

RDS(관계형데이터베이스시스템) -> 데이터베이스 생성

MYSQL 선택  -> 버전 설정

템플릿 - 프리티어(무료 사용) 

식별자 - db이름 설정 (디폴트)

설정 : root or admin (마스터) - 비밀번호

연결 : 퍼블릭으로 접근제한 설정, 보안그룹(특정 아이피만 들어오게끔), 포트 3306

생성

- 이후, 데이터베이스 접속시 ec2에 해당 db의 보안그룹을 생성해야한다.

ec2 보안그룹 - 디폴트 - 인바운드 생성

mysql 넣고 0.0.0.0/0 설정 (아무나 접속 가능)



깃허브에 노드js에 쓸 레파지토리 생성



#### Elastic Beanstalk (배포를 쉽게 해주는 역할)

Elastic Beanstalk 검색하여 들어가기 -> 시작하기

플랫폼을 노드js 생성하고 새 환경 생성

이후, 생성환 환경의 구성 ->  소프트웨어 -> 편집 -> 환경속성에 PORT 포트넘버 설정

(접속할 포트를 지정)

** 문제가 생길시 로그에서 확인 가능



#### CodePipeline (깃허브와 Elastic Beanstalk를 연결)

깃허브에 변화가 있을시 자동 적용을 시켜준다.

CodePipeline에 검색 후 들어가 파이프라인 생성 

소스공급자는 깃허브1로 설정 -> 깃허브 연결

이후 설정 -> 다음

빌드스테이지 건너뜀 (당장은 없어도 된다.)

배포 공급자는 Elastic Beanstalk

기존에 만든 노드js들로 성정 후 생성



## mysql

mysql워크벤치를 키고 새로 커넥션을 한다.

호스트네임은 RDS 생성한 데이터베이스의  엔드포인트로 설정

포트, 유저네임은 만들때 생성한것으로 적음

스키마 만들고 사용할 테이블 생성



## vsc

npm init -y  프로젝트 생성

npm install --save express 익스프레스 프레임워크 설치

깃을 알아서 읽고 파일들을 생성



- server.js 파일 만들기

  https://www.npmjs.com/package/express 참고

```
const express = require('express')
const app = express()
 
app.get('/', function (req, res) {
  res.send('Hello World')
})

// Elastic Beanstalk의 PORT가 없다면  3000으로 접속
const PORT = process.env.PORT || 3000; 

app.listen(PORT)

```

Elastic Beanstalk의 링크를 타고 가면 Hello World 출력



- mysql 설치

  https://www.npmjs.com/package/mysql2 참고

```
//터미널에
npm install --save mysql2
```

```
// get the client
const mysql = require('mysql2');

// create the connection to database
const connection = mysql.createConnection({
  host: 'localhost', //엔드포인트
  user: 'root', //mysql 유저네임
  password: 'password', // 비밀번호가 있다면 추가
  database: 'test' //사용할 db
});

// simple query (app.get 안에 넣어줄거임)
connection.query(
  'SELECT * FROM `table` WHERE `name` = "Page" AND `age` > 45',
  function(err, results, fields) {
    console.log(results); // results contains rows returned by server
    console.log(fields); // fields contains extra meta data about results, if available
  }
);
```

작성 

```
app.get('/', function (req, res) {
  // simple query
  connection.query(
    'SELECT * FROM BOOK',
    function(err, results, fields) {
      console.log(results); // results contains rows returned by server
      //console.log(fields); // fields contains extra meta data about results, if available
      res.send(results)
    }
  );
})
```

위의 기존 작성된 app.get을 위와 같이 변경

다시 접속시 내 BOOK 테이블의 전체 정보 출력



- 겟방식 (파라메터 받기)

```
app.get('/book', function (req, res) {
  let id = req.query.id;
  // simple query
  connection.query(
    'SELECT * FROM BOOK WHERE ID = '+id,
    function(err, results, fields) {
      console.log(results); // results contains rows returned by server
      //console.log(fields); // fields contains extra meta data about results, if available
      res.send(results)
    }
  );
})
```

http://nodeserver-env.eba-atnf6giu.ap-northeast-2.elasticbeanstalk.com/book?id=2

파라메터의 값을 받아 조건문 실행



- 포스트방식

```
//포스트방식은 body로 json으로 주고 받으며 json 사용 선언
app.use(express.json()); 

app.post('/a', function (req, res) {
  console.log(req.body); 
  let name = req.body.name;
  // simple query
  connection.query(
    'SELECT * FROM BOOK WHERE NAME LIKE "%'+name+'%"',
    function(err, results, fields) {
      console.log(results); // results contains rows returned by server
      //console.log(fields); // fields contains extra meta data about results, if available
      res.send(results)
    }
  );
})
```

{"name":"검색어"} 로 넘길시 해당 내용만 출력



- server.js 전체 내용

```
***server.js***
const express = require('express')
const mysql = require('mysql2');
const app = express()
app.use(express.json());


// create the connection to database
const connection = mysql.createConnection({
  host: 'database-1.c94eem47tisk.ap-northeast-2.rds.amazonaws.com',
  user: 'root',
  password: '12341234',
  database: 'TEST'
});


app.get('/', function (req, res) {
  // simple query
  connection.query(
    'SELECT * FROM BOOK',
    function(err, results, fields) {
      console.log(results); // results contains rows returned by server
      //console.log(fields); // fields contains extra meta data about results, if available
      res.send(results)
    }
  );
})

app.get('/a', function (req, res) {
  let id = req.query.id;
  // simple query
  connection.query(
    'SELECT * FROM BOOK WHERE ID = '+id,
    function(err, results, fields) {
      console.log(results); // results contains rows returned by server
      //console.log(fields); // fields contains extra meta data about results, if available
      res.send(results)
    }
  );
})

app.post('/a', function (req, res) {
  console.log(req.body); 
  let name = req.body.name;
  // simple query
  connection.query(
    'SELECT * FROM BOOK WHERE NAME LIKE "%'+name+'%"',
    function(err, results, fields) {
      console.log(results); // results contains rows returned by server
      //console.log(fields); // fields contains extra meta data about results, if available
      res.send(results)
    }
  );
})

const PORT = process.env.PORT || 3000;

app.listen(PORT)
```





## 이후 추가 공부

.env 로 환경변수 추가

https://velog.io/@public_danuel/process-env-on-node-js 

https://rangsub.tistory.com/111?category=981158 참고



리엑트 axios로 요청 보내기

https://wonit.tistory.com/305 참고



노드js crud 업그레이드

https://ing-yeo.net/2020/02/study-nodejs-create-simple-restful-api-server/

https://any-ting.tistory.com/13

https://any-ting.tistory.com/14



http://nodeserver-env.eba-atnf6giu.ap-northeast-2.elasticbeanstalk.com/a?id=2









# AWS S3

https://hunjang.tistory.com/19

https://cdn.discordapp.com/attachments/868002137412603930/918423939124957224/unknown.png



AWS 에서 S3 접속



버킷 생성



ACL 활성화

퍼블릭 엑세스 차단 풀기



이미지 업로드 후 객체 URL로 확인



노드 S3 파일 업로드 코드

```
const AWS = require("aws-sdk");
const fs = require("fs");
require("dotenv").config({ path: __dirname + "\\" + ".env" });

const s3 = new AWS.S3({
  accessKeyId: "AKIA4SU5OUHHFVDGQWHJ", //process.env.AWS_ACCESS_KEY
  secretAccessKey: "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", //process.env.AWS_SECRET_ACCESS_KEY
  //region : 'us-east-1'
});

let params = {
  Bucket: "name.ac",
  Key: "image/bbb/" + "test",
  ACL: "public-read",
  Body: fs.createReadStream("./image/aa.jpg"),
  //ContentType: "image/png",
};

s3.upload(params, function (err, data) {
  console.log(err);
  console.log(data);
});
```

