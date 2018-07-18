package com.wyk.library.model;

public class Bag extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 608122822333746130L;
	
	/** 当前用户 */
	private User user;
	
	/** 用户借的书 */
	private Book book;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

}
