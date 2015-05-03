package com.hogan.model;

import java.util.ArrayList;

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
		ArrayList<BorrowRecord> list = new ArrayList<BorrowRecord>();
		BorrowRecord borrowRecord = new BorrowRecord();
		borrowRecord.setBookId(7);
		borrowRecord.setBorrowDate(DateUtil.date(2015, 2, 10));
		borrowRecord.setUserId(4);
		
		BorrowRecord borrowRecord2 = new BorrowRecord();
		borrowRecord2.setBookId(8);
		borrowRecord2.setBorrowDate(DateUtil.date(2015, 5, 1));
		borrowRecord2.setUserId(4);
		
		BorrowRecord borrowRecord3 = new BorrowRecord();
		borrowRecord3.setBookId(5);
		borrowRecord3.setBorrowDate(DateUtil.date(2015, 5, 1));
		borrowRecord3.setUserId(4);
		
		for (int i = 0; i < 3; i++) {
			list.add(borrowRecord);
			list.add(borrowRecord2);
			list.add(borrowRecord3);
		}
		
		for (BorrowRecord record : list) {
			borrowRecordDao.saveOrUpdate(record);
		}
		
	}
}
