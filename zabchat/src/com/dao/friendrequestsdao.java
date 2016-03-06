package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.friendrequestsdto;
import com.servlets.DatabaseController;

public class friendrequestsdao {
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("insert into friendrequests(id,status,date,sourceId,targetId) values (?, ?, ?, ?, ?)");
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
			stmt = conn.prepareStatement("update friendrequests set status=?, date=? "+" where id=?");
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
			stmt = conn.prepareStatement("delete from friendrequests where id=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public friendrequestsdto retrieve() {
		final friendrequestsdto fr = new friendrequestsdto();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from friendrequests where id=?");
			result = stmt.executeQuery();
			while (result.next()) {

				fr.setId(result.getInt("id"));
				fr.setStatus(result.getString("status"));
				fr.setDate(result.getDate("Date"));
				fr.setSourceId(result.getInt("sourceId"));
				fr.setTargetId(result.getInt("targetID"));
				
				

			}
			return fr;
		} catch (final Exception e) {
			e.printStackTrace();
			return fr;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}
