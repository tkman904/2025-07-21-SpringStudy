package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// => Spring에서는 클래스 관리 (생성 = 소멸)
// 생성 => 생성시에 필요한 데이터를 추가 => DI 
// => 필요시에 공통으로 사용되는 부분을 모아서 처리가 가능 : Callback => AOP
//  AOP => Transaction / Security 
// => VO , interface외에 모든 클래스는 스프링에 맡긴다 
/*
 *   클래스 기능별 구분 
 *   @Component : 일반 클래스 / AOP 
 *                => ChatManager / NaverManager 
 *   @Repository : 저장소 => 데이터 관리 : ~DAO
 *   @Service : BI => 처리기능을 여러개 통합해서 사용 
 *   @Controller : Model = 브라우저와 연결 : JSP관리 
 *   @RestController : Model = 다른 언어와 연동 => 화면이동(X)
 *                     => JavaScript / Kotlin
 *   @ControllerAdvice : Controller에 대한 공통 예외처리 
 *   @RestControllerAdvice : RestController에 대한 공통 예외처리
 *   
 *   생성 =====> 개발자 사용 ======> 소멸 (객체의 생명주기 관리 : 스프링)
 *   => 스프링은 경량 컨테이너 
 */
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
   // 스프링에서 구현된 Mapper를 가지고 온다 
   @Autowired
   private RecipeMapper mapper;
   
   /*
    *   @Select("SELECT no,title,poster,num "
		 +"FROM (SELECT no,title,poster,rownum as num "
		 +"FROM (SELECT no,title,poster "
		 +"FROM recipe WHERE no IN(SELECT no FROM recipe "
		 +"INTERSECT SELECT no FROM recipedetail) "
		 +"ORDER BY no ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  // recipe와 recipedetail에 동일한 no가 있는 데이터만 추출 
		  public List<RecipeVO> recipeListData(@Param("start") int start,
				  @Param("end") int end);
		  
		  // 총페이지 
		  @Select("SELECT COUNT(*) FROM recipe "
				 +"WHERE no IN(SELECT no FROM recipe "
				 +"INTERSECT SELECT no FROM recipedetail)")
		  public int recipeCount();
    */
   public List<RecipeVO> recipeListData(int start,int end)
   {
	   return mapper.recipeListData(start, end);
   }
   public int recipeCount()
   {
	   return mapper.recipeCount();
   }
}