package com.hogan.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hogan.AppContext;
import com.hogan.model.User;
import com.hogan.util.PathUtil;
import com.hogan.util.SessionUtil;

public abstract class BaseController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView modelAndview = new ModelAndView(new RedirectView(
				AppContext.getContextPath() + "/static/500.html"));
		return modelAndview;
	}

	protected User getUser() {
		return AppContext.getContext().getUser();
	}

	public String getUserName() {
		User user = getUser();
		if (user != null) {
			return user.getName();
		}
		return "";
	}

	public int getUserId() {
		User user = getUser();
		if (user != null) {
			return user.getId();
		}
		return 0;
	}

	protected RedirectView getRedirectView(String path) {
		return new RedirectView(PathUtil.getFullPath(path));
	}

	protected void addSession(String key, Object object) {
		SessionUtil.addSession(key, object);
	}

	protected void getSession(String key) {
		SessionUtil.getSession(key);
	}

	protected void removeSession(String key) {
		SessionUtil.removeSession(key);
	}

	protected void invalidate() {
		SessionUtil.invalidate();
	}
}
