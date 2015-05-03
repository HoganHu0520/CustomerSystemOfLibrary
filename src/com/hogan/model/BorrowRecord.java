package com.hogan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hogan.model.base.BaseModel;

@Entity
@Table(name = "t_borrow_record")
public class BorrowRecord extends BaseModel {
	private Integer userId;
	private Integer bookId;
	private Date borrowDate;
	private Date givebackDate;
	private User user;
	private Book book;

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return super.id;
	}

	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "book_id")
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@Column(name = "borrow_date")
	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	@Column(name = "giveback_date")
	public Date getGivebackDate() {
		return givebackDate;
	}

	public void setGivebackDate(Date givebackDate) {
		this.givebackDate = givebackDate;
	}

	@Transient
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Transient
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
