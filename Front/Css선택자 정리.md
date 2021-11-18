https://code.tutsplus.com/ko/tutorials/the-30-css-selectors-you-must-memorize--net-16048

여러분은 `id`, `class`, `descendant` 기초를 알고 있겠죠. 과연 그게 전부일까요? 그렇다면, 여러분은 폭넓게 적용하지 못하고 있네요. 이 글에서 설명하는 선택자 중에 다수가 CSS3 명세서에 있으며 모던 브라우저에서만 적용할 수 있지만, 여러분이 이 선택자들을 열심히 암기하기 바랍니다.

## 1. *

```css
* {
 margin: 0;
 padding: 0;
}
```

고급 선택자로 이동하기 전에 초보자를 위해 쉬운 선택자부터 알아보죠.

별표는 페이지에 있는 전체 요소를 대상으로 합니다. 많은 개발자가 `margin`과 `padding` 값을 0으로 세팅하려고 이 선택자를 사용합니다. 간단한 테스트 용도로서는 괜찮습니다. 그러나, 저는 여러분에게 이 별표를 실전에서 사용하지 말라고 권합니다. 브라우저에 *과부하*가 걸리고, 사용하기에 적절하지 않습니다.

`*`를 자식 선택자에도 사용할 수 있습니다.

```css
#container * {
 border: 1px solid black;
}
```

이 코드는 `#container` `div`의 자식 요소 전체를 대상으로 합니다. 한 번 더 말하지만, 이 선택자를 과다하게 사용하지 마세요.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/star.html)

### 호환성

- IE6+
- 파이어폭스
- 크롬
- 사파리
- 오페라



## 2. #X

```
#container {
   width: 960px;
   margin: auto;
}
```

선택자 앞에 해시(#) 기호를 붙여서 `id`를 대상으로 삼습니다. 가장 흔하고 쉽게 사용됩니다. 하지만, `id` 선택자를 사용할 때는 조심스러워야 합니다.

> 자문해 보세요. 이 요소를 대상으로 하기 위해 `id`를 필히 적용해야 할까요?

`id` 선택자는 유연성이 없고 재활용할 수 없습니다. 가능한 처음에 태그 명이나 새로운 HTML 요소 중 하나, 아니면 가상 클래스라도 적어 보세요.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/id.html)

### 호환성

- IE6+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 3. .X

```
.error {
  color: red;
}
```

`class` 선택자입니다. `id`와 `class`의 차이점이라면, 후자는 여러 개의 요소를 대상으로 정할 수 있습니다. 스타일을 한 그룹의 요소에 적용할 때는 `class`를 사용하세요. 찾을 가망성이 거의 없는 요소에 `id`를 사용하고 그 유일한 요소에만 스타일을 적용하세요.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/class.html)

### 호환성

- IE6+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 4. X Y

```
li a {
  text-decoration: none;
}
```

다음으로 가장 많이 언급하는 선택자는 `descendant`입니다. 선택자를 이용해 더 상세히 작업해야 할 때, 이 선택자를 사용합니다. 가령, *전체* 앵커 태그를 대상으로 하기보다 순서를 매기지 않는 목록(unordered list)에 있는 앵커만 대상으로 한다면 어떨까요? 하위 선택자를 사용하면 상세해집니다.

> **꿀팁** - 선택자가 `X Y Z A B.error`처럼 보이면 여러분은 작업을 잘못하고 있습니다. *모든 요소에 꼭 가중치를 둬야 하는지를 늘 자문하세요.*

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/descend.html)



### 호환성

- IE6+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 5. X

```
a { color: red; }
ul { margin-left: 0; }
```

만일 여러분이 `id`나 `class`가 아닌 `type`에 따라 한 페이지에 있는 모든 요소를 대상으로 삼고 싶다면 어떨까요? 간단히 type 선택자를 이용하세요. 순서가 정해지지 않은 목록 전부를 대상으로 해야 한다면 `ul {}`를 쓰세요.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/tagName.html)

### 호환성

- IE6+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 6. X:visited와 X:link

```
a:link { color: red; }
a:visted { color: purple; }
```

클릭하기 전 상태의 앵커 태그 전체를 대상으로 하려고 `:link` 가상 클래스를 사용합니다.

`:visited` 가상 클래스로 하기도 합니다. 예상하듯이 이는 *클릭했었거나* *방문했던* 페이지에 있는 앵커 태그에만 특정한 스타일을 적용할 수 있습니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/links.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 7. X + Y

```
ul + p {
   color: red;
}
```

인접 선택자로 부르는 선택자입니다. 앞의 요소 바로 뒤에 있는 요소*만* 선택합니다. 위 코드에서 각 `ul` 뒤에 오는 첫 번째 단락의 텍스트만 빨간색이 됩니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/adjacent.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 8. X > Y

```
div#container > ul {
  border: 1px solid black;
}
```

일반 `X Y`와 `X > Y`의 차이점은 후자가 직계 자식만을 선택한다는 것입니다. 가령, 아래 마크업을 생각해 보세요.

```
<div id="container">
   <ul>
      <li> List Item
        <ul>
           <li> Child </li>
        </ul>
      </li>
      <li> List Item </li>
      <li> List Item </li>
      <li> List Item </li>
   </ul>
</div>
```

`#container > ul `선택자는 `id`가 `container`인 `div`의 직계 자손인 `ul`만 대상으로 삼습니다. 예를 들어 첫 번째 `li`의 자식인 `ul`은 대상이 되지 않습니다.

이런 이유로 자식 선택자를 이용해 성능을 향상할 수 있습니다. 사실, 자바스크립트를 기반으로 하는 CSS 선택자 엔진으로 작업할 때 추천합니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/childcombinator.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 9. X ~ Y

```
ul ~ p {
   color: red;
}
```

이 형제 선택자는 `X + Y`와 유사하지만 덜 엄격합니다. 인접 선택자(`ul + p`)는 앞의 선택자 *바로* 뒤에 오는 첫 번째 요소만을 선택하지만, 이 선택자는 좀 더 관대합니다. 위의 예를 보면, `ul` 아래 있는 모든 `p` 요소를 선택할 것입니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/generalcombinator.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 10. X[title]

```
a[title] {
   color: green;
}
```

*속성 선택자(attributes selector)*라고 말하며, 앞의 예에서 `title` 속성이 있는 앵커 태그만을 선택합니다. title이 없는 앵커 태그에는 특정한 스타일이 적용되지 않습니다. 그런데 더 상세히 작업해야 한다면 어떨까요? 음...

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/attributes.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 11. X[href="foo"]

```
a[href="https://net.tutsplus.com"] {
  color: #1f6053; /* nettuts green */
}
```

위의 코드는 *[https://net.tutsplus.com;](https://net.tutsplus.com/)*로 연결된 전체 앵커 태그에 스타일을 적용할 것입니다. 우리 브랜드 컬러인 녹색이 적용되겠지요. 그 외의 앵커 태그는 스타일의 영향을 받지 않습니다.

> 값을 큰따옴표로 감쌌음을 기억하세요. 자바스크립트 CSS 선택자 엔진을 사용할 때 활용하는 것도 잊지 마세요. 가능하면, 비공식적인 선택자보다 CSS3 선택자를 항상 사용하세요.

동작은 잘하겠지만, 융통성은 낮습니다. 만약 링크가 Nettuts+로 직접 이어지지만, 경로를 전체 url이 아닌 *nettuts.com*으로 한다면 어떨까요? 그 경우에 우리는 정규식 표현 문장을 약간 사용할 수 있습니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/attributes2.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 12. X[href*="nettuts"]

```
a[href*="tuts"] {
  color: #1f6053; /* nettuts green */
}
```

야아. 우리에게 필요한 선택자네요. 별표는 입력값이 속성값 안 *어딘가에* 보여야 한다는 것을 표시합니다. 그렇게 이 구문은 *nettuts.com*, *net.tutsplus.com* 그리고 *tutsplus.com*까지도 적용하고 있습니다.

폭넓은 표현이라는 것을 알아 두세요. 만약 앵커 태그의 url에 *tuts* 문자열이 일부 Evato가 아닌 사이트로 연결되어 있다면 어떨까요? 더 자세히 작성해야 한다면, 문자열의 앞과 뒤에 `^`와 `$`를 붙이세요.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/attributes3.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 13. X[href^="http"] (시작 잡기)

```
a[href^="http"] {
   background: url(path/to/external/icon.png) no-repeat;
   padding-left: 10px;
}
```

웹사이트에서 외부로 연결된 링크 옆에 작은 아이콘을 어떻게 보이게 했는지 궁금해한 적이 있나요? 틀림없이 전에 본 적이 있을 것입니다. 링크를 클릭하면 전혀 다른 웹사이트로 이동하리라는 것을 알게 해주니까요.

캐럿 기호를 이용하는 쉬운 작업입니다. 문자열의 시작을 표기하는 정규 표현식에서 흔히 사용됩니다. 만약 `http`로 시작하는 `href` 값을 가진 앵커 태그를 대상으로 하고 싶다면, 위의 코드와 유사한 선택자를 사용하면 됩니다.

> `https://`로는 찾아지지 않습니다. 이 표현은 부적절하고 `https://`로 시작하는 url도 마찬가지입니다.

여러분이 사진으로 링크 걸린 앵커 전체에 스타일을 적용하고 싶다면 어떨까요? 그 경우에는 문자열의 *끝*을 찾아봅시다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/attributes4.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 14. X[href$=".jpg"]

```
a[href$=".jpg"] {
   color: red;
}
```

문자열 끝에 적용하도록 정규 표현식 기호인 `$`를 한번 더 사용하겠습니다. 이번 경우에는 이미지(나 최소한 `.jpg`로 끝나는 url)로 링크가 걸린 앵커 전체를 찾을 것입니다. `gif`와 `png`는 영향받지 않습니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/attributes5.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 15. X[data-*="foo"]

```
a[data-filetype="image"] {
   color: red;
}
```

8번 내용을 다시 참조합시다. 여러 가지 이미지 형식(`png`, `jpeg`, `jpg`, `gif`)은 어떻게 적용할 수 있을까요? 다음과 같이 우리는 선택자를 여러 개 만들 수 있습니다.

```
a[href$=".jpg"],
a[href$=".jpeg"],
a[href$=".png"],
a[href$=".gif"] {
   color: red;
}
```

그런데, 이 방식은 골치 아프고 비효율적입니다. 커스텀 속성을 사용하는 다른 해결 방식이 있습니다. 이미지로 링크 걸린 앵커마다 `data-filetype` 속성을 넣으면 어떨까요?

```
<a href="path/to/image.jpg" data-filetype="image"> Image Link </a>
```

그러면 *갈고리(hook)* 역할을 이용해 해당 앵커만 대상으로 삼는 일반 속성 선택자를 사용할 수 있습니다.

```
a[data-filetype="image"] {
   color: red;
}
```

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/attributes6.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 16. X[foo~="bar"]

```
a[data-info~="external"] {
   color: red;
}
 
a[data-info~="image"] {
   border: 1px solid black;
}
```

친구에게 깊은 인상을 남겨줄 특별한 선택자가 있습니다. 이 요령을 알고 있는 사람은 그리 많지 않습니다. 물결표(`~`)를 이용하면 띄어쓰기로 구분되는 값이 있는 속성을 대상으로 할 수 있습니다.

15번에 있는 커스텀 속성 방식으로 `data-info` 속성을 만들면 됩니다. 이 속성은 우리가 메모하는 무엇이든지 띄어쓰기로 구분한 목록을 받을 수 있습니다. 이 경우, 외부 링크와 이미지 링크를 메모할 수 있습니다. 단지 예를 들면 말이죠.

```
"<a href="path/to/image.jpg" data-info="external image"> Click Me, Fool </a>
```

위의 마크업을 적당한 위치에 쓰면 ~ 속성 선택자 방식을 이용해 두 개의 값 중 하나라도 있는 태그를 대상으로 삼을 수 있습니다.

```
/* Target data-info attr that contains the value "external" */
a[data-info~="external"] {
   color: red;
}
 
/* And which contain the value "image" */
a[data-info~="image"] {
  border: 1px solid black;
}
```

꽤 훌륭하지요?

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/attributes7.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 17. X:checked

```
input[type=radio]:checked {
   border: 1px solid black;
}
```

이 가상 클래스는 라디오 버튼이나 체크박스처럼 *체크되는* 사용자 인터페이스 요소만을 대상으로 합니다. 아래 코드처럼 간단합니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/checked.html)

### 호환성

- IE9+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 18. X:after

`before`과 `after` 가상 클래스는 매우 효과적입니다. 사람들이 늘 이 두 클래스를 효과적으로 사용하는 새롭고 창의적인 방법을 찾고 있는 듯합니다. 이 클래스는 선택된 요소 주변에 콘텐츠를 생성합니다.

많은 사람이 clear-fix 핵을 접했을 때 이 클래스를 맨 먼저 도입했었습니다.

```
.clearfix:after {
    content: "";
    display: block;
    clear: both;
    visibility: hidden;
    font-size: 0;
    height: 0;
    }
 
.clearfix { 
   *display: inline-block; 
   _height: 1%;
}
```

이 *핵*은 요소 뒤에 공간을 덧붙이고 float 효과를 제거하는데 `:after` 가상 클래스를 사용했습니다. 특히 `overflow: hidden;` 방법이 불가능한 경우 여러분이 사용할 방법 중에 가장 훌륭한 방법입니다.

다른 창의적 방식은 [그림자 제작에 관한 간단한 팁을 참조해 보세요.](https://net.tutsplus.com/tutorials/html-css-techniques/quick-tip-getting-clever-with-css3-shadows/)

> CSS3 선택자 명세서를 보면, 가상 요소는 엄밀히 말해 두 개의 콜론(::)으로 표현되어야 합니다. 그렇지만, 일관성을 위해 유저 에이전트는 콜론을 하나 사용한 경우도 허용합니다. 사실 현재, 프로젝트에서 콜론이 한 개인 버전을 사용하는 게 더 현명합니다.

### 호환성

- IE8+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 19. X:hover

```
div:hover {
  background: #e3e3e3;
}
```

에이. 이 선택자는 알고 있겠죠. 공식 용어는 `사용자 동작(user action) 가상 클래스`랍니다. 혼란스럽겠지만 그렇지는 않습니다. 사용자가 요소 위에 커서를 올릴 때 특정한 스타일을 적용하고 싶나요? 이 선택자로 처리하세요!

> 알아두세요. 앵커 태그가 아닌 태그에 `:hover` 가상 클래스를 적용했을 때 인터넷 익스플로러의 하위 버전에서는 반응하지 않습니다.

대부분 hover 상태에서, 가령 앵커 태그에 `border-bottom`을 적용할 때 이 선택자를 사용합니다.

```
a:hover {
 border-bottom: 1px solid black;
}
```

> **꿀팁** - `border-bottom: 1px solid black;`이 `text-decoration: underline;`보다 보기 더 좋습니다.

### 호환성

- IE6+ (IE6에서 :hover는 반드시 앵커 요소에 적용해야 합니다.)
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 20. X:not(선택자)

```
div:not(#container) {
   color: blue;
}
```

`negation` 가상 클래스는 특히 유용합니다. 제가 모든 div를 선택하고 싶은데, 그중에서 `id`가 `container`인 것만 빼고 싶다고 합시다. 위의 코드가 그 작업을 완벽하게 수행합니다.

혹은, (권장하지 않지만) 제가 단락 태그만 제외하고 요소 전체를 선택하고 싶다고 한다면 아래처럼 하면 됩니다.

```
*:not(p) {
  color: green;
}
```

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/not.html)

### 호환성

- IE9+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 21. X::가상 요소

```
p::first-line {
   font-weight: bold;
   font-size: 1.2em;
}
```

첫 번째 줄이나 첫 글자와 같이 요소 일부분에 스타일을 적용하는데 가상 요소(`::`로 표기되는)를 사용할 수 있습니다. 효과를 보려면 이 요소를 반드시 블록 레벨 요소에 적용해야 합니다.

> 가상 요소는 두 개의 콜론(`::`)으로 표시됩니다.

#### 단락의 첫 글자

```
p::first-letter {
   float: left;
   font-size: 2em;
   font-weight: bold;
   font-family: cursive;
   padding-right: 2px;
}
```

이 코드는 페이지에 있는 단락을 모두 찾은 다음 해당 요소의 첫 글자만을 대상으로 하는 추상 개념입니다.

신문처럼 글의 첫 글자를 스타일로 꾸미는 데 자주 사용됩니다.

#### 단락의 첫 줄

```
p::first-line {
   font-weight: bold;
   font-size: 1.2em;
}
```

마찬가지로 `::first-line` 가상 요소는 요소의 첫 번째 줄에만 스타일을 적용합니다.

> 기존 스타일 시트와 일관되도록 유저 에이전트는 CSS 레벨 1과 2 (즉 :first-line, :first-letter, :after)에서 도입한 가상 요소의 이전 표기인 하나의 콜론도 수용해야 합니다. 이 명세서에서 도입된 새 가상 요소에는 호환성이 부족합니다. - [출처](https://www.w3.org/TR/css3-selectors/)

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/pseudoElements.html)

### 호환성

- IE6+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 22. X:nth-child(n)

```
li:nth-child(3) {
   color: red;
}
```

여러 요소 중에서 특정 요소를 지목하는 방법이 없었던 시절이 기억나나요? 그 문제를 풀어줄 `nth-child` 가상 클래스가 있답니다!

`nth-child`는 변숫값을 정수(integer)로 받습니다. 0부터 시작하지는 않습니다. 두 번째 항목을 대상으로 하고 싶다면 `li:nth-child(2)`로 작성합니다.

자식 요소의 변수 집합을 선택하는 데에도 이 방식을 활용할 수 있습니다. 가령, 항목의 4번째마다 선택하려면 `li:nth-child(4n)`로 작성하면 됩니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/nth.html)

### 호환성

- IE9+
- 파이어폭스 3.5+
- 크롬
- 사파리

## 23. X:nth-last-child(n)

```
li:nth-last-child(2) {
   color: red;
}
```

만약 `ul`에 항목이 엄청 많고, 여러분은 끝에서 세 번째 항목만 필요하다고 한다면 어떨까요? `li:nth-child(397)`로 작성하지 말고 `nth-last-child` 가상 클래스를 쓰면 됩니다.

이 선택자는 16번과 거의 동일합니다. 다만 집합의 끝에서부터 출발하면서 동작한다는 게 다릅니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/nthLast.html)

### 호환성

- IE9+
- 파이어폭스 3.5+
- 크롬
- 사파리
- 오페라

## 24. X:nth-of-type(n)

```
ul:nth-of-type(3) {
   border: 1px solid black;
}
```

`child`를 선택하지 않고 요소의 `type`을 선택해야 하는 날이 있을 것입니다.

순서를 정하지 않은 목록 5개가 있는 마크업을 상상해 보세요. 세 번째 `ul`에만 스타일을 지정하고 싶은데 그것을 지정할 유일한 `id`가 없다면, `nth-of-type(n)` 가상 클래스를 이용할 수 있습니다. 위의 코드에서 세 번째 `ul`에만 테두리 선이 둘려집니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/nthOfType.html)

### 호환성

- IE9+
- 파이어폭스 3.5+
- 크롬
- 사파리

## 25. X:nth-last-of-type(n)

```
ul:nth-last-of-type(3) {
   border: 1px solid black;
}
```

일관성을 유지하도록 목록 선택자의 끝부터 출발해 지정한 요소를 대상으로 하는 `nth-last-of-type`을 사용할 수도 있습니다.

### 호환성

- IE9+
- 파이어폭스 3.5+
- 크롬
- 사파리
- 오페라

## 26. X:first-child

```
ul li:first-child {
   border-top: none;
}
```

이 구조적 가상 클래스를 이용해 부모 요소의 첫 번째 자식만 대상으로 삼을 수 있습니다. 목록에서 맨 처음과 맨 나중 항목에서 테두리 선을 제거하는데 이 방식을 흔히 사용합니다.

예를 들면, 가로 행 목록이 있다고 합시다. 행마다 `border-top`과 `border-bottom`이 적용되어 있습니다. 글쎄요. 그 정렬에서 맨 처음과 마지막 항목이 약간 어색해 보이겠네요.

많은 디자이너가 이를 보완하려고 `first`와 `last` 클래스를 적용합니다. 그 대신에 여러분은 이 가상 클래스를 사용하면 됩니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/firstChild.html)

### 호환성

- IE7+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 27. X:last-child

```
ul > li:last-child {
   color: green;
}
```

`first-child`와 반대로 `last-child`는 부모 요소의 마지막 항목을 대상으로 합니다.

### 예제

이 클래스 중에 활용 가능한 사례를 보여주는 간단한 예제를 만들어 봅시다. 스타일이 적용된 항목을 제작하겠습니다.

#### 마크업

```
<ul>
   <li> List Item </li>
   <li> List Item </li>
   <li> List Item </li>
</ul>
```

그냥 코드입니다. 단순한 목록일 뿐이지요.

#### CSS

```
ul {
 width: 200px;
 background: #292929;
 color: white;
 list-style: none;
 padding-left: 0;
}
 
li {
 padding: 10px;
 border-bottom: 1px solid black;
 border-top: 1px solid #3c3c3c;
}
```

이 스타일에 배경을 입히고, 브라우저상에서 `ul` 기본값을 제거하며, 깊이를 약간 주려고 `li`마다 테두리 선을 주겠습니다.

![Styled List](https://cdn.tutsplus.com/cdn-cgi/image/width=634/net/uploads/legacy/840_cssSelectors/extraBorders.png)

> 목록에 깊이를 더하기 위해 각각의 `li`에 `border-bottom`을 적용합니다. 이는 그림자가 되거나 `li` 배경보다 어두운색이 될 것입니다. 다음에 배경보다 더 *밝은 값*을 `border-top`에 적용합니다.

단 한 가지 문제점은, 위의 이미지에서 보이듯, 순서에 정해지지 않은 목록의 맨 위와 맨 아래에도 테두리 선이 적용된다는 것입니다. 자연스럽게 보이지 않죠. `:first-child`와 `:last-child` 가상 클래스를 사용해 이 문제를 고쳐봅시다.

```
li:first-child {
    border-top: none;
}
 
li:last-child {
   border-bottom: none;
}
```

![Fixed](https://cdn.tutsplus.com/cdn-cgi/image/width=618/net/uploads/legacy/840_cssSelectors/fixed.png)

야아. 고쳐졌군요!

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/firstChild.html)

### 호환성

- IE9+
- 파이어폭스
- 크롬
- 사파리
- 오페라

*맞아요. IE8은 `:first-child`를 지원하지만 `:last-child`를 지원하지 않습니다. 말도 안 되죠.*

## 28. X:only-child

```
div p:only-child {
   color: red;
}
```

솔직히 여러분은 아마 `only-child` 가상 클래스를 거의 사용하지 않을 것입니다. 그렇더라도 쓸 수 있으니 써봐야 하겠죠.

이 선택자는 부모의 *단 하나의* 자식 요소를 지정할 수 있습니다. 위의 코드를 참조하면, 가령, `div`의 단 하나의 자식인 문단만 빨간색으로 칠해질 것입니다.

아래의 마크업을 생각해 봅시다.

```
<div><p> My paragraph here. </p></div>
 
<div>
   <p> Two paragraphs total. </p>
   <p> Two paragraphs total. </p>
</div>
```

이 경우, 두 번째 `div`의 문단은 대상이 되지 않고 오직 첫 번째 `div`가 대상이 됩니다. 하나 이상의 자식을 요소에 적용하는 순간에 `only-child` 가상 클래스의 효과는 사라지게 됩니다.

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/onlyChild.html)

### 호환성

- IE9+
- 파이어폭스
- 크롬
- 사파리
- 오페라

## 29. X:only-of-type

```
li:only-of-type {
   font-weight: bold;
}
```

이 구조상의 가상 클래스는 기발한 방식으로 사용될 수 있습니다. 부모 컨테이너에 형제 요소가 없는 요소를 대상으로 합니다. 예로, 단 하나의 목록 아이템인 `ul` 전부를 대상으로 삼습니다.

우선, 이 작업을 어떻게 완료할지 자신에게 질문해 보세요. 여러분은 `ul li`로 하겠지만, 목록 아이템 *전체*가 대상이 됩니다. 유일한 해결 방법은 `only-of-type`을 사용하는 것입니다.

```
ul > li:only-of-type {
   font-weight: bold;
}
```

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/onlyOfType.html)

### 호환성

- IE9+
- 파이어폭스 3.5+
- 크롬
- 사파리
- 오페라

## 30. X:first-of-type

`first-of-type` 가상 클래스로 해당 type의 첫 번째 형제 선택자를 선택할 수 있습니다.

#### 테스트

이해를 돕도록 테스트를 해봅시다. 아래 마크업을 코드 편집기에 복사해 넣으세요.

```
<div>
   <p> My paragraph here. </p>
   <ul>
      <li> List Item 1 </li>
      <li> List Item 2 </li>
   </ul>
 
   <ul>
      <li> List Item 3 </li>
      <li> List Item 4 </li>
   </ul>   
</div>
```

다음 내용을 읽기 전에 "*List Item 2*"만 대상으로 하는 방법을 생각해 보세요. 생각났다면 (혹은 포기했더라도) 다음으로 넘어갑니다.

#### 해결 방법 1

이 테스트를 푸는 방법은 여러 가지입니다. 이 중에서 몇 가지를 살펴보겠습니다. `first-of-type`을 사용해서 시작해 보지요.

```
ul:first-of-type > li:nth-child(2) {
   font-weight: bold;
}
```

이 코드는 기본적으로 "페이지에서 순서를 중요시하지 않는 첫 번째 목록을 찾고 나서 목록 아이템인 직계 자식만 찾아라."라고 이야기합니다. 그다음, 그 결과 세트에서 두 번째 목록 아이템만 걸러냅니다.

#### 해결 방법 2

다른 방법은 인접 선택자를 사용하는 것입니다.

```
p + ul li:last-child {
   font-weight: bold;
}
```

이 시나리오에서는 `p` 태그 바로 뒤에 있는 `ul`을 찾고 나서 그 요소의 가장 마지막 자식을 찾습니다.

#### 해결 방법 3

이 선택자를 써서 원하는 대로 불쾌해하거나 쾌활해 할 수 있습니다.

```
ul:first-of-type li:nth-last-child(1) {
   font-weight: bold;   
}
```

이번에는 페이지에 있는 첫 번째 `ul`을 잡고 나서 가장 첫 번째 목록 아이템을 찾습니다. 바로 아래부터 시작해서요! :)

[데모 보기](https://cdn.tutsplus.com/net/uploads/legacy/840_cssSelectors/selectors/firstOfType.html)

### 호환성

- IE9+
- 파이어폭스 3.5+
- 크롬
- 사파리
- 오페라

## 결론

인터넷 익스플로러 6과 같이 하위 브라우저에서도 보이게 하려면, 새로운 선택자를 사용할 때 늘 조심해야 합니다. 그렇다고 해서 배움을 단념하지 마세요. 자신에게 막심한 해를 끼치는 것이니까요. [브라우저 호환선 목록을 여기에서 참고](http://www.quirksmode.org/css/contents.html)해 보세요. 아니면, 하위 브라우저에 위의 선택자들을 지원하는 [딘 에드워드의 멋진 IE9.js 스크립트](https://code.google.com/p/ie7-js/)를 사용할 수 있습니다.

둘째로, 널리 쓰이는 jQuery 같은 자바스크립트 라이브러리를 사용해서 작업할 때, 가능한 라이브러리에 있는 커스텀 메소드/선택자를 덮어쓰는 네이티브 CSS3 선택자를 만들어 보세요. 선택자 엔진이 자신이 아닌 브라우저의 네이티브 파싱을 사용하게 되어 [코드의 파싱 속도가 더 빨라집니다](https://jsperf.com/jquery-css3-not-vs-not).

읽어 주셔서 감사드립니다. 여러분이 여기에서 한두 가지 요령을 적용해 보길 바랍니다.