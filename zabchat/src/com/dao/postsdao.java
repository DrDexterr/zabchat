package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.postsdto;
import com.servlets.DatabaseController;

public class postsdao {
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("insert into posts(id,title,date,text,popularity) values (?, ?, ?, ?, ?)");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public int update() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("update posts set title, date=?, text=?, popularity=? "+" where id=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public int delete() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("delete from posts where id=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public postsdto retrieve() {
		final postsdto post = new postsdto();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from posts where id=?");
			result = stmt.executeQuery();
			while (result.next()) {

				post.setId(result.getInt("id"));
				post.setTitle(result.getString("title"));
				post.setDate(result.getDate("date"));
				post.setText(result.getString("text"));
				post.setPosterId(result.getInt("posterId"));
				post.setOwnerId(result.getInt("ownerId"));
				post.setPopularity(result.getInt("popularity"));
				

			}
			return post;
		} catch (final Exception e) {
			e.printStackTrace();
			return post;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}
