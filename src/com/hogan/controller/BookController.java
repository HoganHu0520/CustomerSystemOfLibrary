package com.hogan.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

import com.hogan.Constants;
import com.hogan.model.User;

@Controller
@RequestMapping(Constants.APP_URL_BOOK_PREFIX)
public class BookController extends BaseController {

	private final String MYBOOK_JSP = "myBook";
	
	@RequestMapping(value="/mybook", method=RequestMethod.GET)
	public String loadMainView(ModelMap modelMap) {
		modelMap.addAttribute("test", "test");
		return MYBOOK_JSP;
	}
	
}
