package com.wyk.library.model;

public class Book extends BaseModel {

	private static final long serialVersionUID = 3474323268481100686L;
	
	/** 书籍编号 */
	private String bookNo;
	
	/** 书名 */
	private String bookName;
	
	/** 作者 */
	private String author;
	
	/** 出版社 */
	private String publisher;

	/** 书籍位置 */
	private String location;
	
	/** 简介 */
	private String synopsis;

	/**
	 * @return the bookNo
	 */
	public String getBookNo() {
		return bookNo;
	}
	
	/**
	 * @param bookNo the bookNo to set
	 */
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}

	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
}
