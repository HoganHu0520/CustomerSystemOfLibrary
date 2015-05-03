package com.hogan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hogan.dao.base.BaseDao;
import com.hogan.dao.proxy.DaoProxy;
import com.hogan.model.BorrowRecord;
import com.hogan.model.common.Pagination;

public class BorrowRecordDao extends BaseDao<BorrowRecord> {
	public BorrowRecordDao() {
	}

	public Pagination<BorrowRecord> query(Pagination<BorrowRecord> pagination) {
		Pagination<BorrowRecord> resultPagination = pagination;

		List<BorrowRecord> list = this.executeActionWithResult(new DaoProxy() {

			@Override
			public void action(Session session) {
				Query query = session
						.createQuery("select borrowRecord from BorrowRecord borrowRecord")
						.setFirstResult(
								(pagination.getPageIndex() - 1)
										* pagination.getPageSize())
						.setMaxResults(pagination.getPageSize());
				result = query.list();
			}
		});

		resultPagination.setResults(list);
		return resultPagination;
	}
}
