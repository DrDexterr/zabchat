package com.model;

import java.util.Date;

public class postsdto {

private int	id;
private String	title;
private Date  date;
private String	text;
private int posterId;
private int ownerId;
private int	popularity;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getPosterId() {
	return posterId;
}
public void setPosterId(int posterId) {
	this.posterId = posterId;
}
public int getOwnerId() {
	return ownerId;
}
public void setOwnerId(int ownerId) {
	this.ownerId = ownerId;
}
public int getPopularity() {
	return popularity;
}
public void setPopularity(int popularity) {
	this.popularity = popularity;
}
	
}
