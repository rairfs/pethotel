package br.ufs.pethotel.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.servlet.ModelAndView;

public class ErrorControllerImpl implements ErrorController {
	public ModelAndView handleError() {
		ModelAndView mv = new ModelAndView("/error");
		return mv;
	}
	
	public String getErrorPath() {
		return "/error";
	}
}
