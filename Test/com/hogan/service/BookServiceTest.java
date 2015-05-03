package com.hogan.service;

import org.junit.Before;
import org.junit.Test;

import com.hogan.model.BorrowRecord;
import com.hogan.model.common.Pagination;
import com.hogan.util.ApplicationContextUtil;

public class BookServiceTest {
	private BookService bookService;

	@Before
	public void initUserService() {
		bookService = ApplicationContextUtil.getBean("bookService");
	}

	@Test
	public void getBorrowRecordTest() {
		Pagination<BorrowRecord> pagination = bookService
				.getBorrowRecord(new Pagination<BorrowRecord>(), 4);
		System.out.println(pagination.getCurrentCount());
		System.out.println(pagination.getTotalCount());
	}
}
