package br.ufs.pethotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("home")
@Controller
public class HomeController {

	@GetMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home.html");
		return mv;
	}
}
