package com.edu.daoimp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.edu.bean.Stream;
import com.edu.dao.StreamDao;
import com.edu.util.GetDBConnection;
import com.edu.util.TokenServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Repository
public class StreamDaoImp implements StreamDao {

	TokenServiceImp tokService = new TokenServiceImp();
	GetDBConnection getConn = new GetDBConnection();
	ObjectMapper objectMapper = new ObjectMapper();

	@SuppressWarnings("deprecation")
	@Override
	public ObjectNode getAllStreams() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		ObjectNode outNode = objectMapper.createObjectNode();
		ArrayNode arrayOutNode = objectMapper.createArrayNode();
		String sql = "SELECT id, streamname FROM streams WHERE isDeleted='N' ";

		try {
			conn = GetDBConnection.getConnection();
			stmt = conn.createStatement();

			System.out.println("----sql getAllStreams----" + sql);
			// Execute above query
			rs = stmt.executeQuery(sql);

			// While rows in result set, do following
			while (rs.next()) {
				ObjectNode objectInNode = objectMapper.createObjectNode();
				objectInNode.put("StreamId", rs.getString("id"));
				objectInNode.put("StreamName", rs.getString("streamname"));
				// objectInNode.put("")

				arrayOutNode.add(objectInNode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closeRS(rs);
			GetDBConnection.closeConn(conn);
		}

		outNode.put("result", arrayOutNode);
		return outNode;
	}

	@SuppressWarnings("deprecation")
	@Override
	public ObjectNode getStream(int sid) {
		System.out.print("BOOM");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ObjectNode outNode = objectMapper.createObjectNode();
		ArrayNode arrayOutNode = objectMapper.createArrayNode();
		String result = "error";
		String sql = "SELECT * FROM streams where id = " + sid;

		try {
			conn = GetDBConnection.getConnection();
			stmt = conn.createStatement();

			System.out.println("----sql Just One stream? ----" + sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ObjectNode objectInNode = objectMapper.createObjectNode();

				objectInNode.put("StreamName", rs.getString("streamname"));

				arrayOutNode.add(objectInNode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closeRS(rs);
			GetDBConnection.closeConn(conn);
		}

		outNode.put("result", arrayOutNode);
		return outNode;
	}

	public ObjectNode insertStream(Stream stream) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode objectOutNode = objectMapper.createObjectNode();
		Connection conn = null;
		PreparedStatement preparedStmt = null;

		boolean flag = false;

		String authString = "Authorised", userId;

		try {

			// String strauth = stream.getAuthKey();
//          userId = tokService.getUserIdFromToken(strauth);
//          if(tokService.isTokenValid(strauth))
//          {

			conn = GetDBConnection.getConnection();

			String SQL_QUERY = "INSERT INTO streams (streamname, IsDeleted ,createdBy, createdDate) "
					+ " VALUES (?,'N', '101', NOW())";

			System.out.println("QUERY For insertStream " + SQL_QUERY);

			preparedStmt = conn.prepareStatement(SQL_QUERY);

			preparedStmt.setString(1, stream.getStreamname());
			System.out.println(preparedStmt.toString());

			preparedStmt.executeUpdate();
			flag = true;
//          }
//          else{
//              authString="UnAuthorised";
//          }
			objectOutNode.put("result", flag);
			objectOutNode.put("message", authString);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			GetDBConnection.closePstmt(preparedStmt);
			GetDBConnection.closeConn(conn);
		}

		return objectOutNode;

	}

	public ObjectNode updateStream(Stream stream) {
		// TODO Auto-generated method stub
		boolean flag = false;
		ObjectNode objectOutNode = objectMapper.createObjectNode();
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		String authString = "Authorised", userId = "101";

		try {
			System.out.println("Inside try");
//			authString = stream.getAuthKey();
//			userId = tokService.getUserIdFromToken(authString);
//			if(tokService.isTokenValid(strauth))
//			{
			conn = GetDBConnection.getConnection();
			stmt = conn.createStatement();
			System.out.println("Prepared Statement");
			String query = "Update streams set  streamname = ? ," + " updatedBy = '" + userId
					+ "' , updatedDate = NOW() where id = " + stream.getId();

			System.out.println("Stream Update query => " + query);

			preparedStmt = conn.prepareStatement(query);

			preparedStmt.setString(1, stream.getStreamname());

			preparedStmt.executeUpdate();
			flag = true;
//			}
//			else
//			{
//				authString="UnAuthorised";
//			}
			objectOutNode.put("result", flag);
			objectOutNode.put("message", authString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closePstmt(preparedStmt);
			GetDBConnection.closeConn(conn);
		}
		return objectOutNode;
	}

	public ObjectNode inactivateStream(Stream stream) {
		boolean flag = false;
		ObjectNode objectOutNode = objectMapper.createObjectNode();
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement preparedStmt = null;
		String id = "101";
		String authString = "Authorised";
		try {

			conn = GetDBConnection.getConnection();
			stmt = conn.createStatement();
			String query = "UPDATE streams SET isDeleted = 'Y', updatedBy = '" + id
					+ "', updatedDate = NOW() where id = " + stream.getId();

			System.out.println("Update query => " + query);

			preparedStmt = conn.prepareStatement(query);
			flag = true;

			objectOutNode.put("result", flag);
			objectOutNode.put("message", authString);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closePstmt(preparedStmt);
			GetDBConnection.closeConn(conn);
		}
		return objectOutNode;
	}
}
