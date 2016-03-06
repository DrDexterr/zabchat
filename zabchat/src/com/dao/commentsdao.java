package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import com.model.commentsdto;
import com.servlets.DatabaseController;

public class commentsdao {
	

	

		private DatabaseController databaseController = DatabaseController.getDatabaseController();

		public int create() {
			Connection conn = null;
			PreparedStatement stmt = null;

			try {
				conn = databaseController.getConnection();
				stmt = conn.prepareStatement("insert into comments(id,text,date) values (?, ?, ?)");
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
				stmt = conn.prepareStatement("update comments set text=?, date=? "+" where id=?");
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
				stmt = conn.prepareStatement("delete from comments where id=?");
				final int result = stmt.executeUpdate();
				return result;

			} catch (final Exception e) {
				e.printStackTrace();
				return 0;
			} finally {
				databaseController.close(stmt, conn);
			}
		}

		public commentsdto retrieve() {
			final commentsdto comment = new commentsdto();
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet result = null;
			try {
				conn = databaseController.getConnection();
				stmt = conn.prepareStatement("select * from comments where id=?");
				result = stmt.executeQuery();
				while (result.next()) {

					comment.setId(result.getInt("Id"));
					comment.setText(result.getString("text"));
					comment.setDate(result.getDate("date"));
					comment.setPersonId(result.getInt("personId"));
					comment.setPostId(result.getInt("postId"));

				}
				return comment;
			} catch (final Exception e) {
				e.printStackTrace();
				return comment;
			} finally {
				databaseController.close(result, stmt, conn);
			}
		}

	}


