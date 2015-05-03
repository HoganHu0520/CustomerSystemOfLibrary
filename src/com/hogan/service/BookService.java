package com.hogan.service;

import com.hogan.model.BorrowRecord;
import com.hogan.model.common.Pagination;

public interface BookService {
	public Pagination<BorrowRecord> getBorrowRecord(Pagination<BorrowRecord> pagination, Integer userId);
}
