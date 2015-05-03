package com.hogan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hogan.dao.base.BaseDao;
import com.hogan.dao.proxy.DaoProxy;
import com.hogan.model.Book;
import com.hogan.model.common.Pagination;

public class BookDao extends BaseDao<Book> {
	public BookDao() {
	}

	public Pagination<Book> query(Pagination<Book> pagination) {
		Pagination<Book> resultPagination = pagination;

		List<Book> list = this.executeActionWithResult(new DaoProxy() {

			@Override
			public void action(Session session) {
				Query query = session
						.createQuery("select book from Book book")
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
