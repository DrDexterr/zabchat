package com.model;

import java.awt.Image;
import java.sql.Blob;
import java.util.Date;

public class peopledto {
private int id;
private String firstName;
private String lastName;
private Date dateOfBirth;
private String sex;
private String email;
private int password;
private String place;
private String  website;
private String occupation;
private String employment;
private Blob picture;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public String getEmployment() {
	return employment;
}
public void setEmployment(String employment) {
	this.employment = employment;
}
public Blob getPicture() {
	return picture;
}
public void setPicture(Blob blob) {
	this.picture = blob;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
private String education;
}
