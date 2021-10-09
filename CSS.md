# CSS 

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



#### 선택법

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



