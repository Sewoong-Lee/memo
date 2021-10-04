# MSSQL

#### **Select(검색)**

```sql
--My_Table로 부터 모든 칼럼 조회
SELECT * FROM My_Table

--My_Table의 No_Emp,Nm_Kor,Age 칼럼 조회
SELECT No_Emp,Nm_Kor,Age FROM My_Table
```



#### **Where(조건문)**

```sql
--이름이 '홍길동'인사람 검색
SELECT * FROM My_Table WHERE Nm_Kor ='홍길동' 

--나이가 25살인 사원의 한국이름과 나이 조회
SELECT Nm_Kor,Age FROM My_Table WHERE Age=25 

--나이가 25살이 아닌 사원 조회
SELECT * FROM My_Table WHERE Age<>25

--사원번호가 '0315' 이고 나이가 25살보다 작거나 이름이 '홍길동'인 사원 조회
SELECT * FROM My_Table WHERE No_Emp = '0315' AND (Age<25  OR Nm_Kor = '홍길동')

--사원번호가 '0315' 이거나 나이가 25살 이상이면서 이름이 '홍길동'인 사원 조회
SELECT * FROM My_Table WHERE No_Emp = '0315' OR (Age>=25 AND Nm_Kor = '홍길동')
```



#### **Like(~로 시작,포함,끝나는 단어)**

```sql
--'김'으로 시작하는 사원 조회
SELECT * FROM My_Talbe WHERE Nm_Kor LIKE '김%'

--김이 들어가는 시작하는 사원 조회
SELECT * FROM My_Talbe WHERE Nm_Kor LIKE '%김%'

--김으로 끝나는 사원의 사원번호 조회
SELECT No_Emp FROM My_Talbe WHERE Nm_Kor LIKE '%김'
```



#### **In(~이거나)**

```sql
--나이가 20살,24살,26살인 사원 조회
SELECT * FROM My_Table WHERE Age IN(20,24,26)

사원번호가 '0000','0004','0008'이고 나이가 20살 24살 28살인 사원 조회
SELECT * FROM My_Table Where No_Emp IN('0000','0004','0008)AND Age IN(20,24,28)
```



#### **Between(~부터~까지)**

```sql
나이가 20살~25살까지의 사원조회
SELECT * FROM My_Table WHERE Age Between 20 AND 24

나이가 사원번호가 '0000'~'0010'까지이거나 나이가 30살~40살인 사원의 이름 조회
SELECT Age FROM My_Table WHERE (No_Emp BETWEEN '0000' AND '0010') OR (Age BETWEEN 30 AND 40)
```



