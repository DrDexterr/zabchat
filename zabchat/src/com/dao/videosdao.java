package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.videosdto;
import com.servlets.DatabaseController;

public class videosdao {
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("insert into videos(id,link) values (?, ?)");
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
			stmt = conn.prepareStatement("update videos set link=?"+" where id=?");
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
			stmt = conn.prepareStatement("delete from videos where id=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public videosdto retrieve() {
		final videosdto video = new videosdto();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from videos where id=?");
			result = stmt.executeQuery();
			while (result.next()) {

				video.setId(result.getInt("id"));
				video.setLink(result.getString("link"));
				video.setPostId(result.getInt("postId"));

			}
			return video;
		} catch (final Exception e) {
			e.printStackTrace();
			return video;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}
