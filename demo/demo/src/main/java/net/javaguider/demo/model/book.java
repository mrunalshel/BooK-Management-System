package net.javaguider.demo.model;

import javax.persistence.*;

@Entity
@Table(name="booksinformation")
public class book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String bookname;
private String category;
private String author;

private String emailId; 


public book() {
	super();
	// TODO Auto-generated constructor stub
}
public book(String bookname, String category, String author, String emailId) {
	super();
	this.bookname = bookname;
	this.category = category;
	this.author = author;
	this.emailId = emailId;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}



}
