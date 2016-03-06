package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.picturesdto;
import com.servlets.DatabaseController;

public class picturesdao {
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("insert into pictures(id,image values (?, ?)");
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
			stmt = conn.prepareStatement("update pictures set image=? "+" where id=?");
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
			stmt = conn.prepareStatement("delete from pictures where id=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public picturesdto retrieve() {
		final picturesdto pics = new picturesdto();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from pictures where id=?");
			result = stmt.executeQuery();
			while (result.next()) {
				
				pics.setId(result.getInt("id"));
				pics.setImage(result.getBlob("image"));
				pics.setPostId(result.getInt("postId"));

			}
			return pics;
		} catch (final Exception e) {
			e.printStackTrace();
			return pics;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}
