package com.hogan.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hogan.AppContext;
import com.hogan.Constants;
import com.hogan.exception.ParameterException;
import com.hogan.exception.ServiceException;
import com.hogan.model.User;
import com.hogan.service.UserService;
import com.hogan.util.StringUtil;

@Controller
@RequestMapping(Constants.APP_URL_USER_PREFIX)
public class UserController extends BaseController {

	private final String LOGIN_JSP = "login";
	private final String BOOK_MYBOOK_PAGE = "book/mybook";

	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "go", defaultValue = "") String go) {

		User user = this.getUser();
		ModelAndView modelAndView = new ModelAndView();

		if (user != null) {
			modelAndView.setView(this.getRedirectView(BOOK_MYBOOK_PAGE));
		} else {
			modelAndView.addObject("go", go);
			modelAndView.setViewName(LOGIN_JSP);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView saveLogin(
			@RequestParam(value = "userId", defaultValue = "") String userId,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "queryString", defaultValue = "") String queryString,
			@RequestParam(value = "go", defaultValue = "") String go) {

		ModelAndView modelAndView = new ModelAndView();

		try {
			User user = null;
			user = userService.login(userId, password);
			user.setPassword(null);
			this.addSession(Constants.USER, user);

			if (!StringUtil.isEmpty(queryString)) {
				if (queryString.startsWith("#")) {
					queryString = queryString.substring(1);
				}
				go = go + "?" + queryString;
			}

			RedirectView redirectView = StringUtil.isEmpty(go) || go.equals("null") ? this
					.getRedirectView(BOOK_MYBOOK_PAGE) : new RedirectView(
					AppContext.getContextPath() + "/" + go);
			modelAndView.setView(redirectView);
		} catch (ParameterException parameterException) {
			Map<String, String> errorFields = parameterException
					.getErrorFields();
			modelAndView.addObject(Constants.ERROR_FIELDS, errorFields);
			modelAndView.setViewName(LOGIN_JSP);
		} catch (ServiceException serviceException) {
			modelAndView.addObject(
					Constants.TIP_MESSAGE,
					serviceException.getMessage() + "["
							+ serviceException.getCode() + "]");
			modelAndView.setViewName(LOGIN_JSP);
		}
		return modelAndView;
	}
}
