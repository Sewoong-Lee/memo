# JSTL

**단순 IF문 : <c:if>**

if문에서 else가 없는 단순 if문을 구성할때 사용할 수 있다.

```html
<c:set var="name" value="홍길동" />

<c:if test="${name eq '홍길동'}">
    홍길동이 맞습니다.
</c:if>
```



**IF ~ ELSE 문 : <c:choose>**

우리가 많이 사용하는 if~else 문의 경우 jstl에서는 <c:choose>를 이용하여 구성하여야 한다.

```html
<c:set var="name" value="홍길동" />

<c:choose>
    <c:when test="${name eq '홍길동'}">
        홍길동이 맞습니다.
    </c:when>
    <c:when test="${name eq '철수'}">
        홍길동이 아닙니다.
    </c:when>
    <c:otherwise>
        사람이 없습니다 ㅜㅜ
    </c:otherwise>
</c:choose>
```



**비교기호 : eq, ne, empty**

if문을 사용할때에는 반드시 값과의 비교를 작성하게 되는데, jstl에서는 eq, ne와 같은 비교기호를 이용해도 된다.

**1. eq (==)**
 비교하고자 하는 값이 동일한지를 확인할때 사용한다.

**2. ne (!=)**
 비교하는 값이 동일하지 않은지 확인할때 사용한다.

**3. empty (== null)**
 비교하는 값이 null 인지 확인할때 사용한다.
 \* null이 아닌경우를 표현할때는 !empty 로 표현하면 된다.



번외)  if ~ else문을 작성하는데, <c:choose> 태그를 이용하지 않고 아래와 같이 작성 가능

```html
<c:set var="name" value="홍길동" />

<c:if test="${name eq '홍길동'}">
    홍길동이 맞습니다.
</c:if>
<c:if test="${name eq '철수'}">
    홍길동이 아닙니다.
</c:if>
<c:if test="${empty name}">
    홍길동이 아닙니다.
</c:if>
```

하지만 가독성이 많이 떨어지니 하지 말자....





