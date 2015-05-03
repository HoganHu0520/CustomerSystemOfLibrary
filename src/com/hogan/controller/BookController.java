package com.hogan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hogan.Constants;
import com.hogan.model.BorrowRecord;
import com.hogan.model.common.Pagination;
import com.hogan.service.BookService;

@Controller
@RequestMapping(Constants.APP_URL_BOOK_PREFIX)
public class BookController extends BaseController {

	private final String MYBOOK_JSP = "myBook";
	private final String BORROW_RECORD_INFO_JSP = "borrowRecordList";
	
	private BookService bookService;
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/mybook", method=RequestMethod.GET)
	public String loadMainView(ModelMap modelMap) {
		modelMap.addAttribute("test", "test");
		return MYBOOK_JSP;
	}
	
	@RequestMapping(value = "/borrowRecord", method = RequestMethod.GET)
	public String loadBorrowRecordInfoPage(ModelMap modelMap) {
		Pagination<BorrowRecord> pagination = bookService.getBorrowRecord(new Pagination<BorrowRecord>());
		modelMap.addAttribute("pagination", pagination);
		return BORROW_RECORD_INFO_JSP;
	}
	
}
