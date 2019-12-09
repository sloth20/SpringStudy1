package com.sp.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("blog.BlogController")
public class BlogController {

	@Autowired
	private BlogService service;

	@RequestMapping("/blog")
	public String blog(Model model) {

		List<Blog> list = service.listBlog();

		model.addAttribute("list", list);

		return "blog/list";
	}

	// @PathVariable : 동적인 주소의 패러미터를 받을 때 사용(URI 경로에 변수를 넣어줄 때)
	// 매핑의 {}안의 이름과 @PathVariable이 붙은 패러미터의 이름이 같아야 함
	@RequestMapping("/blog/b{seq}/main")
	public String main(@PathVariable int seq, Model model) {
		List<Blog> list = service.listBlog();

		Blog dto = null;

		for (Blog vo : list) {
			if (vo.getUserSeq() == seq) {
				dto = vo;
				break;
			}
		}

		model.addAttribute("dto", dto);

		return "blog/main";
	}
}
