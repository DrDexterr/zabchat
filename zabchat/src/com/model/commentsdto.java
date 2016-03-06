package com.model;

import java.util.Date;

public class commentsdto {
private int id;
private String text;
private Date date;
private int personId;
private int postId;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}

public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}
public int getPostId() {
	return postId;
}
public void setPostId(int postId) {
	this.postId = postId;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}
