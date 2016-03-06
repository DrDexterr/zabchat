package com.model;

import java.awt.Image;
import java.sql.Blob;

public class picturesdto {
private int id;
private Blob image;
private int postId;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Blob getImage() {
	return image;
}
public void setImage(Blob blob) {
	this.image = blob;
}
public int getPostId() {
	return postId;
}
public void setPostId(int postId) {
	this.postId = postId;
}

}
