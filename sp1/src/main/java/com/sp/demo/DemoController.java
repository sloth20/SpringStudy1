package com.sp.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* 
 * @RequestParam : 
 * 일반적으로 GET 방식으로 넘어온 query string(패러미터)를 넘겨받을 때 사용
 * 기본적으로 필수이므로 넘어온 패러미터가 없으면 400 에러 발생
 * 
 * */

@Controller("demo.demoController")
public class DemoController {

	@RequestMapping("/demo/main")
	public String main() {
		return "demo/main"; 
	}

	@RequestMapping("/demo/request")
	public String submit(@RequestParam(name = "a", defaultValue = "0") int age,
			@RequestParam(defaultValue = "m") String gender, Model model) {
		// 패러미터와 넘겨 받는 이름이 다른 경우 name 속성에 패러미터 이름을 명시
		// defaultValue는 넘어오는 값이 없으면 초기값 설정
		String s = "결과 -> ";
		try {
			s += "나이 : " + age + ", 성별 : " + (gender.equals("m") ? "남자" : "여자");
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("result", s);

		return "demo/view";
	}
}
