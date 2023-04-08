package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

  
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String getHello() {
    return "hello world";
  }
  
  @RequestMapping(value = "/name", method = RequestMethod.GET)
  public String getName() {
    return "Flature";
  }
  
  // 매서드 매개변수 {String}을 받는 GetMapping
  // 기본주소는 /api/v1/get-api/variable/{String}
  // return 값은 variable
  @RequestMapping(value = "/api/v1/get-api/variable/{variable}", method = RequestMethod.GET)
  public String getApi(@PathVariable String variable) {
    return variable;
  }
  
  
  /**
   * GetTest
   * RESTful 웹 서비스의 GET 요청을 처리하는 함수입니다.
   *
   * @return 요청 경로에서 추출된 변수의 값
   * @param str 요청 경로에서 추출
   *            ex) /api/v1/get-api/variable/{str} 에서 str 값
   *
   */
  @GetMapping("/variable/{var}")
  public String getTest(@PathVariable("var") String str) {
    return str;
  }
  
  /**
   * requestParmsTest
    * RESTful 웹 서비스의 GET 요청을 처리하는 함수입니다.
   */
   @GetMapping("/request1")
    public String requestParmsTest(@RequestParam("name") String name, // name이라는 변수를 받아서 String name에 저장,
                                    @RequestParam("email") String email, // mail이라는 변수를 받아서 String mail에 저장
                                    @RequestParam("organization") String organization // organization이라는 변수를 받아서 String organization에 저장
                                       ) {

      return "name : " + name + ", email : " + email + ", organization : " + organization;
    }
  
  /**
   * requestParamTest2
   * @RequestParam Map<String String> param
   */
  @GetMapping("/request2")
  public String requestParamTest2(@RequestParam Map<String, String> param) {
    
    StringBuilder sb = new StringBuilder();
    
    param.forEach((key, value) -> {
      System.out.println(key + " : " + value);
      sb.append(key).append(" : ").append(value).append("\n");
    });
    
    return sb.toString();
  }
  
  /**
   * requestParamTest3 ("/request3")
   * @param memberDto memberDto
   */
  @GetMapping("/request3")
  public String requestParamTest3(MemberDto memberDto) {
    System.out.println(memberDto);
    return memberDto.toString();
  }
  


//  /**
//   * requestParmsTest
//   * RESTful 웹 서비스의 GET 요청을 처리하는 함수입니다.
//   */
//  @GetMapping("/request1")
//  public String requestParmsTest(
//    @RequestParam("name") String name // name이라는 변수를 받아서 String name에 저장,
//  ) {
//    return "HELLO WORLD";
//  }

  
  
  

  
  
  
  
  
  
  
}
