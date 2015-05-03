package com.hogan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hogan.dao.BookDao;
import com.hogan.dao.BorrowRecordDao;
import com.hogan.dao.UserDao;
import com.hogan.model.Book;
import com.hogan.model.BorrowRecord;
import com.hogan.model.User;
import com.hogan.model.common.Pagination;
import com.hogan.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	private UserDao userDao;
	private BorrowRecordDao borrowRecordDao;

	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setBorrowRecordDao(BorrowRecordDao borrowRecordDao) {
		this.borrowRecordDao = borrowRecordDao;
	}

	@Override
	public Pagination<BorrowRecord> getBorrowRecord(
			Pagination<BorrowRecord> pagination) {
		Pagination<BorrowRecord> resultPagination = borrowRecordDao
				.query(pagination);

		for (BorrowRecord itemBorrowRecord : pagination.getResults()) {
			User user = new User();
			user.setId(itemBorrowRecord.getUserId());

			User userResult = userDao.getById(user);
			Book book = new Book();
			book.setId(itemBorrowRecord.getBookId());
			Book bookReuslt = bookDao.getById(book);
			itemBorrowRecord.setUser(userResult);
			itemBorrowRecord.setBook(bookReuslt);
		}

		return resultPagination;
	}

}
