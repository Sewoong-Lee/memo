### 1) JWT를 이해하기전 세션에 대해 알아보자

- JWT = json web token 이다

- 중요한점은 왜 사용되고 어디에 쓰는지이다!!



세션이란?

일반적으로 유저가 웹을 키고 주소를 요청하면 서버는 해당 주소에 맞는 컨트롤러의 메소드를 찾음

그 메소드에서 html 파일을 리턴함 이떄 http 헤더를 달아보냄

http 헤더에 쿠키(세션id)를 담아 보내준다.

프론트에서는 쿠키를 받으면 자동으로 쿠키 저장영역에 세션id가 등록된다. (최초 요청시)

2번째 요청부터는 요청 헤더에 세션id를 달고 간다.

2번째 요청부터는 서버가 세션id를 새로 생성이 아닌 그대로 돌려준다.

세션id는 예를들어 카페의 쿠폰과 같다. (쿠폰(세션id)를 가지고 오지 않으면 처음온것으로 간주)

서버는 쿠폰을 만들어줄때마다 목록을 가지고 있다.

요청이 올때마다 쿠폰을 매칭한다.



1. 최초요청
2. 서버는 목록에 쿠폰(세션id)을만들어주고 쿠폰을 돌려줌 html을 던져줄때 담아서 보내주고 목록에 쿠폰을 저장해둠
3. 2번째 프론트 요청이 왔을때 목록에 쿠폰(세션id)이 있는지 확인 (없으면 발급)



언제 세션id가 사라지나?

1. 세션을 서버쪽에서 날릴때

2. 사용자가 브라우저를 닫았을때 (프론트의 세션id가 사라짐)
3. 특정 시간이 지날시 자동으로 사라짐 (보통 30분)



세션사용?

로그인요청시 많이 사용됨

클라이언트가 요청을 보냄 서버에서는 세션 저장소에 세션id와 세션id전용 저장소 생성

서버에서 응답을 해줄때 헤더에 세션id를 돌려준다.

클라이언트는 웹브라우저에 세션id가 저장된다.

로그인 요청이 왔을시 아이디와 비밀번호를 날리면 db에서 정상인지 확인

정상일시 해당 세션id의 저장소에 유저정보를 저장함

메인페이지로 리턴

이후 인증이 필요한 페이지를 요청시 세션id가 있는지 확인

데이터베이스에 사용자 정보 응답후 돌려줌



세션을 통하여 사용자 인증, 민감한 정보 접근시 값이 있는지 확인



세션의 단점?

클라이언트가 요청을 할때 서버에서 응답이 가능하다.

그리고, 동접자가 많다면 여러개의 서버를 만들어야 한다.

하지만 동일한 사용자가 동일한 서버에만 요청을 한다는 보장이 없다.

스티키 서버를 만들어서 최초요청 서버로만 요청이 가게끔 하던가, 세션을 복제해야한다.

또는 세션에 정보를 저장하는게 아니라 db에 저장하는 방법도 있다.

하지만 db를 만지게 되면 io가 일어나면서 엄청나게 딜레이가 생김

원래는 메모리에서 데이터를 찾기 때문에 빨랐다.....

그래서 보통은 메모리 공유 서버(레디스)를 사용하여 세션id를 저장해두며 사용하게된다.



#### 하지만 JWT는 세션의 문제점을 해결해준다!!















































