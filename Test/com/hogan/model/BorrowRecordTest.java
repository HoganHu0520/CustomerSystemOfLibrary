package com.hogan.model;

import org.junit.Before;
import org.junit.Test;

import com.hogan.dao.BorrowRecordDao;
import com.hogan.util.ApplicationContextUtil;
import com.hogan.util.DateUtil;

public class BorrowRecordTest {

	private BorrowRecordDao borrowRecordDao = null;

	@Before
	public void initBorrowRecordDao() {
		borrowRecordDao = ApplicationContextUtil.getBean("borrowRecordDao");
	}

	@Test
	public void createBorrowRecordDao() {
		BorrowRecord borrowRecord = new BorrowRecord();
		borrowRecord.setBookId(7);
		borrowRecord.setBorrowDate(DateUtil.date(2015, 2, 10));
		borrowRecord.setUserId(4);

		borrowRecordDao.saveOrUpdate(borrowRecord);
	}
}
