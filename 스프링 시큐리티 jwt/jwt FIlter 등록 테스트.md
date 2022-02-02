# jwt FIlter 등록 테스트



```
import javax.servlet.Filter;

public class MyFilter1  implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터 1");
		chain.doFilter(request, response); //필터체인 등록 (이걸 안하면 여기서 끝남)
		
	}

}
```

필터를 만들어줌

SecurityConfig에 필터를 걸어줌

```
protected void configure(HttpSecurity http) throws Exception {
		http.addFilter(new MyFilter1());
```

이러면 시큐리티 필터가 아니어서 에러뜸



```
protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new MyFilter1(), BasicAuthenticationFilter.class);
```

로 변경 

BasicAuthenticationFilter가 실행되기 전에 필터를 거치게끔

사실 이거처럼 할필요 없음 지워주센



내가 만든 필터보다 시큐리티 필터가 먼저 실행된다.

