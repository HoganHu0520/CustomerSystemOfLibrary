package com.hogan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hogan.Constants;
import com.hogan.model.BorrowRecord;
import com.hogan.model.User;
import com.hogan.model.common.Pagination;
import com.hogan.service.BookService;

@Controller
@RequestMapping(Constants.APP_URL_BOOK_PREFIX)
public class BookController extends BaseController {

	private final String MYBOOK_JSP = "myBook";
	private final String BORROW_RECORD_INFO_JSP = "borrowRecordList";
	private final String BOOK_INFO_JSP = "bookInfo";

	private BookService bookService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/mybook", method = RequestMethod.GET)
	public String loadMainView(ModelMap modelMap) {
		modelMap.addAttribute("test", "test");
		return MYBOOK_JSP;
	}

	@RequestMapping(value = "/borrowRecord", method = RequestMethod.GET)
	public String loadBorrowRecordInfoPage(
			@RequestParam(value = "page", defaultValue = "1") Integer pageInteger,
			ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute(Constants.USER);
		Pagination<BorrowRecord> parameterPagination = new Pagination<BorrowRecord>();
		parameterPagination.setPageIndex(pageInteger);
		Pagination<BorrowRecord> pagination = bookService.getBorrowRecord(
				parameterPagination, user.getId());
		modelMap.addAttribute("pagination", pagination);
		
		return BORROW_RECORD_INFO_JSP;
	}

	@RequestMapping(value = "/bookInfo", method = RequestMethod.GET)
	public String loadBookInfoPage(
			@RequestParam(value = "id") Integer idInteger, ModelMap modelMap) {
		modelMap.addAttribute("book", bookService.getBookInfo(idInteger));
		
		return BOOK_INFO_JSP;
	}

}
