https://aljjabaegi.tistory.com/310



# iBatis, myBatis 동적 태그 비교 정리 Dynamic SQL

 iBatis 에서 사용되는 기본 동적 태그(Binary Conditional Tag)는 아래와 같다.

여기서 사용되는 속성에는

------------------------------------------------------------------------

prepend - 태그 조건에 맞아 실행될 sql문에 선행하여 붙을 속성

property - 매개변수 명

compareProperty - 비교할 다른 매개변수명

compareValue - 비교대상이 될 값

---------------------

이 있습니다.

### **<iBatis 동적 태그>**

* **<isEqual>** 

property의 값이 같을때만 태그내 쿼리를 실행합니다.

```xml
WHERE 1=1
 <isEqual prepend="AND" property="useYn" compareValue="Y">
        EQUIP_TYPE = 1
</isEqual>
useYn 이 Y 일때만 EQUIP_TYPE =1 조건을 실행합니다.
```



- **<isNotEqual>**

 property의 값이 같지 않을 때만 태그내 쿼리를 실행합니다.

```xml
WHERE 1=1
<isNotEqul prepend="AND" property="useYn" compareValue="N">
            EQUIP_TYPE = 1
</isNotEqual>
useYn 이 N이 아닐 때만 EQUIP_TYPE=1 조건을 실행합니다.
```



- **<isGreaterThan>**

property의 값이 비교값보다 클경우 쿼리를 실행합니다.

```xml
WHERE 1=1
<isGreaterThan prepend="AND" property="age" compareValue="19">
             JOIN_YN = 'Y'
</isGreaterThan>
age 값이 19 보다 클경우 JOIN_YN='Y' 조건을 실행합니다.
```



- **<isLessEqual>**

property의 값이 비교값보다 작거나 같을 경우 쿼리를 실행합니다.

```XML
WHERE 1=1
<isLessEqual prepend="AND" property="age" compareValue="18">
            JOIN_YN = 'N'
</isLessEqual>
```



#### 단일 태그

- **<isPropertyAvailable>**

   property값이 유효할 경우 쿼리를 실행합니다.

- **<isNotPropertyAvailable>**

  property값이 유효하지 않을 경우 쿼리를 실행합니다.

- **<isNull>**

  property값이 null일 경우 쿼리를 실행합니다.

- **<isNotNull>**

  property값이 null이 아닐 경우 쿼리를 실행합니다.

- **<isEmpty>**

  property값이 비어있을경우 쿼리를 실행합니다.

- **<isNotEmpty>**

  property값이 비어있지 않을 경우 쿼리를 실행합니다.



#### 파라메터 조건 태그

- **<isParameterPresent>**

  파라메터가 있을 경우 쿼리를 실행합니다.

  ```xml
  <isParameterPresent prepend="WHERE"> 
            1=1
  </isParameterPresent>
  파라메터값이 넘어왔을 경우에만 WHERE 조건 붙음
  ```

  

- **<isNotParameterPresent>**

  파라메터값이 없을 경우 쿼리를 실행합니다.

  ```xml
  WHERE 1=1
  <isNotParameterPresent prepend="AND">
           TYPE = 'DEFAULT'
  <isNotParameterPresent>
  파라메터값이 없을 경우에만 TYPE = 'DEFAULT' 쿼리 실행
  ```



#### Iterate 태그

파라메터로 배열을 넘겨 IN 쿼리문을 사용할 때 유용합니다.

-  **<iterate>**

  배열 타입의 파라메터를 받을 때 활용합니다.

  ```xml
  WHERE 1=1
  <isNotEmpty prepend="AND" property="empIdArray">
         EMP_ID IN <iterate open="(" close=")" conjunction="," property="empIdArray">#empIdArray[]#</iterate>
  </isNotEmpty>
  
  배열의 값을 빼내어 콤마로 구분하여 괄호 '(' , ')' 내에 넣게 되죠.
  ex) ('111', '222', 333', '444') 
  ```

  

#### dynamic 태그

- **<dynamic>**

  하위 태그에 일치되는 내용이 존재할 경우 where절을 붙인다.

  가장 처음 일치요소의 prepend="AND" 는 생략된다.

  ```XM
  <dynamic prepend="WHERE">
          <isEqual prepend="AND" property="empId" comapareValue="123">
                      VACATION = 'TRUE'
          </isEqual>
  </dynamic>
  
  empId 파라메터 값 123이라면 <isEqual>태그의 prepend는 생략되고
  WHERE 절이 붙어 WHERE VACATION = 'TRUE' 쿼리가 실행된다.
  ```

  