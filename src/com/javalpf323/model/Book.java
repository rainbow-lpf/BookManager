package com.javalpf323.model;

public class Book {
	
	private int id;
	private String bookName;
	private String author;
	private String sex;
	private float price;
	private String bookDesc;
	private int bookTypeId;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName, String author, String sex, float price, String bookDesc, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookDesc = bookDesc;
		this.bookTypeId = bookTypeId;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getBookName() {
		return bookName;
	}
	public String getAuthor() {
		return author;
	}
	public String getSex() {
		return sex;
	}
	public float getPrice() {
		return price;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
}
