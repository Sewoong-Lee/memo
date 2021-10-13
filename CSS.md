# CSS 

https://flukeout.github.io/ 선택자 게임
caniuse.com 호환성 확인
https://css-tricks.com/snippets/css/a-guide-to-flexbox/  플렉스박스 간단 확인
https://studiomeal.com/archives/197  1분코딩
https://flexboxfroggy.com/#ko  플렉스박스 게임



#### 기본 태그 정리

```css
text-align: center; //글자 정렬 가운데로
line-height: 36px; //글의 높이 맞추기
cursor: pointer; //마우스 올리면 손가락으로 변경
border-radius: 3px 3px 3px 3px;  //모서리 둥글리기

position: relative;  //내 현재위치를 기준으로 잡음
position: absolute;  //html 전체 좌표를 기준
position: fixed; //브라우저를 기준으로 잡음 (스크롤을 내려도 그대로 따라옴)

display: block; //타입을 블록으로 변경
display: inline; //인라인 타입으로 변경
display: flex; //자식에 flex:1; 씩 주면 한자리씩 공평하게 공간 차지
display: none;
```



#### 선택자

```html
div > span:first-child {
	div 안의 첫번쨰 span 선택.
}
div > span {
	div 안의 span 전체 선택.
}

<div>
    <span>1</span>
	<span>2</span>
</div>

모두 선택 * 
type - Tag (div, butten 등)
Class - .class
State - :상태
Attribute - []

butten: hover {
	: 뒤에는 상태
}

a[href] {
	a의 속성 중 href가 있는경우의 css
	(a[href^="naver"] 로 시작하는 것들만 선택 가능)
	(a[href$=".com"] 로 끝나는 것들만 선택 가능)
	(a[href*=".com"] 이 들어가는 모든 하이퍼링크)
}

li#sp {
	만약 아이디가 중복될경우 li로 테그를 따로 선택 가능
}

각 패딩을 따로 줄떄
padding: 20px 20px 20px 20px; // 위 오른쪽 아래 왼쪽
padding: 20px 0px;  //위 옆


보더 한번에 하기
border: 2px solid red; //보더는 2px 이고 솔리드스타일에 레드컬러

a의 링크를 누르면 다음부턴 색이 보라색으로 보이게 해라
a:link { color: red; }
a:visted { color: purple; }

각 요소의 바로 뒤에있는 타입 선택
ul + p {
   color: red; //각 ul 뒤에있는 p를 선택
}


자식 선택
div#container > ul {
  border: 1px solid black;  //컨테이너 안에 있는 ul만 선택
} 

각 요소 뒤에있는 타입을 모두 선택
ul ~ p {
   color: red;  //ul의 뒤에있는  p를 모두 선택
}

태그에 data-filetype="image"을 주고 타입 자체를 잡음
<a href="path/to/image.jpg" data-filetype="image"> Image Link </a>
a[data-filetype="image"] {
   color: red;
}
```



#### margin & padding

margin은 해당 태그의 거리를 띄운다

padding은 해당 태그의 덩치를 키운다.



#### 기본으로 죽이는 효과

```css
*{
    boder-collapse : collapes; //윤곽선 기본 2줄인걸 하나로 잡아줌
    margin : 0px;
    padding : 0px;
    text-decoration: none;  //하이퍼링크등의 글자 효과를 삭제
    color; black; //글자 기본색상 지정
    list-style: none; //리스트의 스타일 제거
}
```



####  Inline & Block 차이

div는 block 타입으로 한줄의 공간을 차지

span은 inline 타입으로 텍스트의 공간만 차지



#### div 한줄로 만드려면

display: inline-block 를 넣자



#### position

statick(기본 디폴트) - html의 기본 순서대로 
relative - 원래 있던 자리를 기준으로 이동 (상대적)
absolute - 가장 가까운 아이템의 상자를 기준으로 이동
fixed - 상자 안에서 완전히 벗어나서 웹페이지를 기준으로
sticky - 원래있던 자리에 있는데 아래로 내려도 움직이지 않는다 (고정)



## FLEX BOX

#### 컨테이너 속성값

```css
.con { //컨테이너 속성값
    height: 100vh; //화면의 100파센토 사용
    display: flex;

    //중심축을 정하기
    flex-direction: row; //왼쪽에서 오른쪽
    flex-direction: row-reverse; //오른쪽에서 왼쪽
    flex-direction: colunm; //위에서 아래 reverse; 는 반대

    flex-wrap: nowrap; //기본값 (한줄에 꽉차면 그냥 삐저나감)
    flex-wrap: wrap; //한줄에 꽉차면 아래로 떨어짐 reverse; 는 반대

    flex-flow: colunm wrap; //위의 두개를 한번에 합침

    //중심축에서 아이템을 어떻게 배치할건지
    justify-content: flex-start; //왼쪽에서 오른쪽
    justify-content: flex-end; //반대로 배치
    justify-content: center; //아이템을 가운데로 배치
    justify-content: space-around; //박스를 둘러싸게 공간을 띄움
    justify-content: space-evenly; //아이템들은 같은 간격으로 띄움
    justify-content: space-between; //왼쪽과 오른쪽은 딱 붙고 나머지는 간격 띄움

    //반대축에서 아이템을 어떻게 배치할지
    align-items: center; //반대축 가운데로 이동
    align-items: baseline; //만약 아이템의 크기가 다르다면 텍스트를 중심으로 정렬
    //아이템의 반대축 정렬
    align-content: center; //중심으로 모임 
}
```



#### 플랙스 박스 아이템 설정값

```jsp
<div class="con">
	<div class="item item1">1</div>
	<div class="item item1">2</div>
	<div class="item item1">3</div>
</div>
```

```css
.con {
	display: flex; //컨테이너에 이거만 지정
}

.item{
	width: 40px;
	height: 40px;
	border: 1px; solid black;
}

.item1{
	order: 2;  //order를 통해 기본 html의 순서를 변경 가능 (거의 안씀....)
	flex-grow: 1; //뷰 화면의 공간을 채우려고 늘어남
	flex-shrink: 1; //뷰가 줄어들때 사이즈가 얼마나 차지하며 줄어들지 정함
	
	flex-basis: 60%; //뷰가 늘어나든 줄어들든 상관없이 공간 비율을 얼마나 차지할지 정함
			//위에 저거 필요 없는듯....
	
	//컨테이너에 벗어나서 하나만 정렬하고 싶으면 ...
	align-self: center;
}

.item2{
	flex-grow: 2; //뷰 화면의 공간을 채우려고 늘어남
	flex-basis: 20%;
}

.item3{
	flex-grow: 2; //뷰 화면의 공간을 채우려고 늘어남
	flex-basis: 20%;
}


```

