package kr.green.spring.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class TestController{
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("test2"); //test2를 view
		mv.addObject("serverTime", "데이터"); //되는지 확인용
		
		return mv;
	}
}