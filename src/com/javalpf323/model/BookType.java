package com.javalpf323.model;

/**
 * 书的类型
 * @author Fife
 *
 */
public class BookType {

	private int id;
	private String bookTypeName;
	private String bookDesc;
	
	
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookType(String bookTypeName, String bookDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookDesc = bookDesc;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
}
