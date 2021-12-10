## 자바스크립트 각종 null 처리 방법

자바스크립트에서 null을 어떻게 보냐에 따라 다르다.

1. "" 만 null로 보는 경우

```javascript
//""만 null로 볼경우
function nullChk(data) { 
    if(data === "") { // 함수로 사용
        // 맞을 경우
        return true;
    } else {
        // 안맞을 경우
        return false;
    }
}
	
console.log(nullChk(""));    // true
console.log(nullChk("ABC")); // false
```



2. null의 범위를 넓게 잡을 경우 ( **"", " ", undefined, null, {}, [], 0 NaN** )

```javascript
// "", " ", null, undefined, {}, [], NaN, 0 도 NULL이라고 봤을 때
var isEmpty = function(data) {
    if(typeof(data) === 'object'){
        if(JSON.stringify(data) === '{}' || JSON.stringify(data) === '[]'){
            return true;
        }else if(!data){
            return true;
        }
        return false;
    }else if(typeof(data) === 'string'){
        if(!data.trim()){
            return true;
        } 
        return false;
    }else if(typeof(data) === 'undefined'){
        return true;
    }else if(isNaN(data) == true){ // 신규 NaN 처리
        return true;
    }else if(data === 0){ // 신규 0 처리
        return true;
    }else{
        return false;
    }
}

console.log("new test");
console.log(isEmpty(parseInt(10) * "ABC")); // NaN을 만들기 위해 숫자 * 문자 true 
console.log(isEmpty(0)); // true
console.log("ABC"); // false
```



#### 자바스크립트 새로고침 코드 3가지



```javascript
location.reload(true);
location.href = location.href;
history.go(0);
```

