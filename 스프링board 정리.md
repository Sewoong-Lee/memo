## model

```java
@GetMapping("detail")
public void detail(Model model, int bnum, HttpSession seeeion) throws Exception{
		//임시로 새션 아이디를 정할 수 있다
		//seeeion.setAttribute("userid", "www");
		//조회수 +1
		String userid = (String)seeeion.getAttribute("userid"); //접속된 아이디
		boardservice.readcountadd(bnum, userid); //잠깐 하드코딩
		
		//한건 조회
		Map<String, Object> bfmap = boardservice.selectone(bnum, userid);
		model.addAttribute("bfmap", bfmap);

	}
```

Model 로 선언하며 뷰에서는 따로 ${bfmap.board.LIKEGUBUN} 등으로 받을 수 있다.

${bfmap} 등으로 먼저 확인하고 나누어 받자!!



## 세션에 데이터 저장



```jav
//컨트롤러에
@Controller
@RequestMapping("board")
@SessionAttributes("page") // @ModelAttribute("page") 의 내용을 세션에도 담는다

//세션 생성
	@RequestMapping("/")  // 항상 얘 먼저 시작해서 세션이 생성되게 만들어야함
	public String home(Page page, Model model) { 
		//모델을 생성해서 @SessionAttributes 에 생성
		model.addAttribute("page", page);  //맨 위의 @SessionAttributes("page")에도 생성
		
		return "redirect:list";  //세션에 저장후 리스트 실행
	}
```



## 뷰까지 내용을 전달 하기

```java
//리스트 조회 후 폼으로 이동
	//@ModelAttribute("page") : 뷰까지 페이지 내용 전달
	//@ModelAttribute 1.단독 : 내용을 뷰까지 전달 / 2.@SessionAttributes("page")와 함께 : 세션에도 내용 저장
	@GetMapping("list")
	public void list(Model model,@ModelAttribute("page") Page page) throws Exception{
		
		List<Map<String,Object>> blist = boardservice.selectlist(page);
		model.addAttribute("blist", blist);
		//model.addAttribute("page", page);
	}
```



## 세션에 아이디 저장 및 가져오기

```java
//상세조회 폼으로 이동
	@GetMapping("detail")
	public void detail(Model model, int bnum, HttpSession seeeion) throws Exception{
		//임시로 새션 아이디를 정할 수 있다
		//seeeion.setAttribute("userid", "www");
		//조회수 +1
		String userid = (String)seeeion.getAttribute("userid"); //접속된 아이디
		boardservice.readcountadd(bnum, userid); //잠깐 하드코딩
		
		//한건 조회
		Map<String, Object> bfmap = boardservice.selectone(bnum, userid);
		model.addAttribute("bfmap", bfmap);

	}
```



## 에이젝스로 번호를 url로 넘기기

```ja
//게시물 처리
	//좋아요 버튼을 클릭 했다면
	$('#btnlike').click(function() {
		alert(likegubun);
		if(likegubun == '0'){ //조회 상태일때만 좋아요/싫어요 가능
			//좋아요 처리
			//alert('좋아요');
			var bnum = '${bfmap.board.BNUM}';
			console.log(bnum);
			
			$.ajax({
				url: '${path}/board/like/'+bnum,
				type: 'get',
				dataType: 'text',
				success: function(data){
					likegubun = '1'; //좋아요 상태로 변경
					//alert(data);
					statechange(); //버튼상태 변경
					//좋아요 +1
					$('#likecnt').text(parseInt($('#likecnt').text()) + 1); 
				},
				error: function(err){
					console.log(err);
					alert('실패');
				}
			});
			
@ResponseBody
	@GetMapping("like/{bnum}")
	public String like(@PathVariable("bnum") int bnum, HttpSession seeeion) throws Exception{
		String userid = (String)seeeion.getAttribute("userid"); //접속된 아이디
		
		boardservice.updatelikecnt(bnum, userid);
		return "ok";
	}
```



## @RequestParam & required

```java
<th>기존 파일</th>
			<td> <c:forEach var="bflist" items="${bfmap.bflist}">
					<img alt="사진" src="${path}/uploadimg/${bflist.filename}" width="100">
					<input type="checkbox" name="filedelete" value="${bflist.fnum}">삭제
				</c:forEach> 
			</td>

//게시물 수정 
	@PostMapping("modify")  //@RequestParam 보내온 데이터 형식을 바꿔줌 //required : 데이터가 없어도 에러가 안생김
	public String modify(Board board, 
			@RequestParam(value = "filedelete", required = false) List<Integer> filedeletelist, 
			HttpServletRequest request) throws Exception{ 
		
		//보드에 아이피 세팅
		board.setIp(request.getRemoteAddr());
		boardservice.update(board, filedeletelist);
		
		return "redirect:list";
	}
```



## 세션 삭제 (로그아웃)

```java
//로그아웃
	@GetMapping("logout") 
	public String logout(HttpSession session) {
		//모든 세션변수 삭제
		session.invalidate();
		
		return "redirect:/";
	}
```



## ip 가져오기

```java
//게시물 등록으로
	@PostMapping("add")
	public String add(Board board, HttpServletRequest request) throws Exception{
		//사용자의 아이피 주입
		board.setIp(request.getRemoteAddr());
		boardservice.insert(board);
		
		return "redirect:list";
	}
```



## redirectAttributes

```java
@RequestMapping(value = "/kor/sdfac/testmap/mapInsert.do", method = RequestMethod.POST)
	public String MapInsert(@RequestParam Map<String, Object> commandMap, Model model,
			HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
        
        redirectAttributes.addFlashAttribute("Confirm", "success");
		redirectAttributes.addFlashAttribute("Confirm_alert", "정상적으로 등록 되었습니다.");
		redirectAttributes.addFlashAttribute("Confirm_url", "/kor/sdfac/rent/application_result.do");
		
		//return "redirect:/common/kor/sdfac/Confirm.do";
		System.out.println("commandMap2 "+commandMap.toString());
		
        return "redirect:list";
	}
```

redirectAttributes 를 사용하여 redirect 작동시 정보 전달 가능
