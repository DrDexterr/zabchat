package com.model;

import java.util.Date;

public class friendrequestsdto {
private int id;
private String status;
private Date date;
private int sourceId;
private int targetId;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getSourceId() {
	return sourceId;
}
public void setSourceId(int sourceId) {
	this.sourceId = sourceId;
}
public int getTargetId() {
	return targetId;
}
public void setTargetId(int targetId) {
	this.targetId = targetId;
}
}
