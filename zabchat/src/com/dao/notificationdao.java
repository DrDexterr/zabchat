package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.notificationdto;
import com.servlets.DatabaseController;

public class notificationdao {
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("insert into notification(id,text,url,date) values (?, ?, ?, ?)");
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
			stmt = conn.prepareStatement("update notification set text=?, url=?, date=? "+" where id=?");
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
			stmt = conn.prepareStatement("delete from notification where id=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public notificationdto retrieve() {
		final notificationdto notification = new notificationdto();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from notification where id=?");
			result = stmt.executeQuery();
			while (result.next()) {

				notification.setId(result.getInt("id"));
				notification.setText(result.getString("text"));
				notification.setUrl(result.getString("url"));
				notification.setDate(result.getDate("date"));
				notification.setPersonId(result.getInt("personId"));
				

			}
			return notification;
		} catch (final Exception e) {
			e.printStackTrace();
			return notification;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}
