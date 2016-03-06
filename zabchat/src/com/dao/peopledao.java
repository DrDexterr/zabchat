package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.peopledto;
import com.servlets.DatabaseController;

public class peopledao {
	private DatabaseController databaseController = DatabaseController.getDatabaseController();

	public int create() {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("insert into people(id,firstname,lastName,dateOfBirth,sex,email,password,place,website,occupation,employment,picture) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
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
			stmt = conn.prepareStatement("update people set firstname=?, lastName=?, dateOfBirth=?, sex=?, email=?, password=?, place=?, website=?, occupation=?, employment=?, picture=?  "+" where id=?");
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
			stmt = conn.prepareStatement("delete from people where id=?");
			final int result = stmt.executeUpdate();
			return result;

		} catch (final Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			databaseController.close(stmt, conn);
		}
	}

	public peopledto retrieve() {
		final peopledto people = new peopledto();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		try {
			conn = databaseController.getConnection();
			stmt = conn.prepareStatement("select * from people where id=?");
			result = stmt.executeQuery();
			while (result.next()) {

				people.setId(result.getInt("id"));
				people.setFirstName(result.getString("firstName"));
				people.setLastName(result.getString("lastName"));
				people.setDateOfBirth(result.getDate("dateOfBirth"));
				people.setLastName(result.getString("sex"));
				people.setEmail(result.getString("email"));
				people.setPassword(result.getInt("password"));
				people.setPlace(result.getString("place"));
				people.setWebsite(result.getString("website"));
				people.setOccupation(result.getString("occupation"));
				people.setEmployment(result.getString("employment"));
				people.setPicture(result.getBlob("picture"));
			}
			return people;
		} catch (final Exception e) {
			e.printStackTrace();
			return people;
		} finally {
			databaseController.close(result, stmt, conn);
		}
	}

}
