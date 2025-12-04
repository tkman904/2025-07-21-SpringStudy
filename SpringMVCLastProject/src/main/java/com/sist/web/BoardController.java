package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
/*
 *    Spring => MVC (DI / AOP) , Security
 *    MVC 동작 순서 
 *    1) 클라이언트 요청 
 *       HTML : <a href="요청"> <form action="">
 *       JS : location.href="요청"
 *       Ajax : $.ajax({
 *                 url:요청주소
 *              })
 *       Axios: axios.get('요청주소') => react / vue
 *              fetch('요청주소')
 *    2) DispatcherServlet (스프링에서 지원)
 *       ---------- 배달부 (request를 받아서 (주문) => request에 요청결과를 담아서 전송)
 *       요청을 받는다 
 *       => 요청 처리 => 개발자가 제작 : Model(Controller,RestController)
 *                     ---------------------------------------------
 *                     | HandlerMapping => 해당 Model 찾기 
 *                       | url주소 메소드 찾기 
 *                         ---------------
 *                         @RequestMapping 
 *                         @GetMapping
 *                         @PostMapping
 *                         @PutMapping
 *                         @DeleteMapping 
 *                         ------------------ RestFul
 *    3) HandlerMapping => 해당 Controller 찾기 
 *    4) 해당기능을 수행하는 메소드 수행 
 *    5) request/model에 담기 데이터를 => DispatcherServlet이 받아서 
 *    6) ViewResolver => JSP를 찾아서 request를 전송 
 *    7) JSP에서 화면 출력 
 *       => JSP / Vue / ThymeLeaf / React
 *                                  | UI 
 *                      | 다음주 => UI ==> 2주 정도 : CI / CD
 *                        --------------------------------
 *                        | 우분투 : docker , docker-compose 
 *                                 => minikube / jenkins 
 *    JSP(요청) == DispatcherServlet = HandlerMapping 
 *                                        |
 *                                     @Controller (Model)
 *                                        |
 *                                      -------------
 *                                       Mapper
 *                                         |
 *                                        DAO
 *                                         |
 *                                      Service
 *                                      -------------
 *                                         |
 *                                      DispatcherServlet
 *                                         |
 *                                       ViewResolver
 *                                         |
 *                                        JSP
 *      => DispatcherServlet : 모든 요청을 받아서 router
 *                 => FrontController 
 *                 => 요청 : 응답 => 서빙 
 *      => HandlerMapping : 어떤 모델을 호츌할지 찾는 역할 
 *      => @Controller/@RestController 
 *          => 개발자 담당 : 비니지스로직 (요청 처리) 
 *                        => DAO / Service / VO 
 *      => Model : JSP로 전송할 데이터를 저장 
 *                 addAttribute() => request.setAttribute()
 *      => ViewResolver : JSP를 찾아주는 역할 
 *      => View : 화면 UI (JSP , HTML , Vue , React)
 *      
 *    --------------------------------------------------------
 *      DI (주입) => 객체 생성 => 객체 소멸 
 *                  | 필요한 데이터가 있는 경우 => 값을 채워준다 
 *                  | setter / 생성자 => 멤버변수의 초기화 
 *                  | 객체 생성 호출 : init-method
 *                  | 객체 소멸시 호출 : destory_method
 *                  | => 사용자 정의 클래스(X) , MyBatis / JPA 
 *                  | <bean id="" class=""
 *                     p:변수명=""/>
 *                     ----------
 *                    <bean id="" class=""
 *                     c:변수명=""/> 생성자의 매개변수 
 *                    
 *                    
 *     AOP : 공통 모듈 (모든 기능시에서 사용이 되는 기능을 모아서 관리 => 필요시에 자동 호출)
 *     
 *      public String display1() => 메소드 구분 (PointCut)
 *      {
 *         
 *         try
 *         {
 *            @Before : getConnection()
 *            --------------1) @Around setAutoCommit(false)
 *            1
 *            2
 *            3
 *            --------------2) commit()
 *         }catch(Exception e)
 *         {
 *            4 => @After-Throwable  rollback()
 *         }
 *         finally
 *         {
 *             @After  disConnection()
 *         }
 *         return "" @After-Returning => 출력   
 *      }
 *      public String display2()
 *      {
 *         try
 *         {
 *         }catch(Exception e)
 *         {
 *         }
 *         return "" 
 *      }
 *      
 *      JoinPoint : 어디서 사용할지  
 *      PointCut : 어떤 메소드 안에 처리 
 *      --------- +
 *      Advice 
 *      ------------ Aspect
 *      
 *      => 위빙 : 모든 기능을 묶어서 => 호출 
 *      => 사용자 정의 거의 없다 (쿠키) 
 *         ----------------
 *         이미 제작 : 트랜젝션 / 보안 
 *      => 
 *         public void boardInsert()
 *         {
 *            try
 *            {
 *                getConnection()
 *                setAutoCommit(false)
 *                insert()
 *                insert()
 *                insert()
 *                commit()
 *            }catch(Exception e)
 *            {
 *                rollback()
 *            }
 *            finally
 *            {
 *               setAutoCommit(true)
 *            }
 *         }
 *         
 *         @Transactional
 *         public void boardInsert()
 *         {
 *            insert()
 *            insert()
 *            insert()
 *         }
 *         
 *     @Controller / @RestController
 *                    | => 데이터 전송만 (JSON)
 *     |=>View제어 => router => 화면 이동 
 *     
 *     @Controller + @ResponseBody => @RestController
 *                   ------------- 5버전 이전 
 *     @PathVariable 
 *      /board/list/1
 *      https://v.daum.net/v/20251204060544180
 *      => *.do => / => boot는 기본이 /
 *     @RequestBody => VO
 *      => JSON => 객체로 변환 
 *      axios.post('',{
 *                   name:this.name,
 *                   subject:this.subject,
 *                   content:this.content,
 *                   pwd:this.pwd
 *                })
 *      @ResponseStatus => 응답 HTTP 상태 
 *         => 200 : OK , 500 , 404 ...
 *         
 *      => DI 
 *      @Autowired : 스프링에 등록된 객체를 찾아서 => 메모리 주소값 대입 
 *      
 *      => ResponseEntity : 응답 전체를 직접 제어 
 *         => HTTP 상태 코드 , 헤더 , Body => 제어할 수 있는 객체
 *         => HttpStatus , Body
 *      ----------------------------------------------------
 *      사용법 / => 어떤 실행 / 어떤 데이터가 필요한지 ...
 *      -----------------------------------------
 *      
 */
@Controller
public class BoardController {
	@GetMapping("board/list.do")
	public String board_list(Model model) {
		model.addAttribute("main_jsp", "../board/list.jsp");
		return "main/main";
	}
	
	@GetMapping("board/insert.do")
	public String board_insert(Model model) {
		model.addAttribute("main_jsp", "../board/insert.jsp");
		return "main/main";
	}
	
	@GetMapping("board/update.do")
	public String board_update(int no,Model model) {
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../board/update.jsp");
		return "main/main";
	}
	
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model) {
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../board/detail.jsp");
		return "main/main";
	}
}