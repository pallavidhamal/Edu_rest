package com.edu.daoimp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.edu.bean.Task;
import com.edu.dao.TaskDao;
import com.edu.util.GetDBConnection; 
import com.edu.util.TokenServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Repository
public class TaskDaoImp implements TaskDao {
	/*private PreparedStatement preparedStmt = null;
	private Connection conn = null;
	private Statement stmt 	= null;
	private ResultSet rs	= null;*/
	TokenServiceImp tokService=new TokenServiceImp();
	GetDBConnection getConn = new GetDBConnection();
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public ObjectNode getTasks(int userid) {
		// TODO Auto-generated method stub
		 Connection conn 	= null;
		 Statement stmt 	= null;
		 ResultSet rs		= null;
		
		ObjectNode objectOutNode =objectMapper.createObjectNode();
		ArrayNode arrayOutNode = objectMapper.createArrayNode();
		
		//String sql = "Select * from task_master where IsDeleted = 'N' ";
		//String sql = "Select * from task_master ";
		
		String sql = "Select * from test ";
		
			try
			{
				conn = GetDBConnection.getConnection();
				stmt = conn.createStatement();
				
				System.out.println("----sql getAllPorders----"+sql);
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					ObjectNode objectInNode = objectMapper.createObjectNode();
					
				/*
				 * objectInNode.put("TaskId", rs.getString("TaskId"));
				 * objectInNode.put("TaskName", rs.getString("TaskName"));
				 * objectInNode.put("IsDeleted", rs.getString("IsDeleted"));
				 * 
				 * 
				 */
					
					objectInNode.put("TaskId", rs.getString("id"));
					  objectInNode.put("TaskName", rs.getString("name"));
					
					arrayOutNode.add(objectInNode);
				}
				
			}
			catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
			finally {
				GetDBConnection.closeStmt(stmt);
				GetDBConnection.closeRS(rs);
				GetDBConnection.closeConn(conn);
			}
			
			objectOutNode.put("result", arrayOutNode);
		
		return objectOutNode;
	
	}


	
	public ObjectNode getTaskDetail(int id) {
		// TODO Auto-generated method stub
		 Connection conn 	= null;
		 Statement stmt 	= null;
		 ResultSet rs		= null;
		
		ObjectNode objectOutNode =objectMapper.createObjectNode();
		ArrayNode arrayOutNode = objectMapper.createArrayNode();
		String result="error";
		String sql = "SELECT * FROM task_master rm where TaskId = "+id;
		
			try
			{
				conn = GetDBConnection.getConnection();
				stmt = conn.createStatement();
				
				System.out.println("----sql----"+sql);
				
				rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					ObjectNode objectInNode = objectMapper.createObjectNode();

					objectInNode.put("TaskId",rs.getString("TaskId"));
					objectInNode.put("TaskName",rs.getString("TaskName"));
					
					arrayOutNode.add(objectInNode);
				}
				objectOutNode.put("data", arrayOutNode.toString());
				result= "success";
			}
			catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
			finally {
				GetDBConnection.closeStmt(stmt);
				GetDBConnection.closeRS(rs);
				GetDBConnection.closeConn(conn);
			}
			objectOutNode.put("result", result);
			
		return objectOutNode;
		
	}

	
	public ObjectNode insertTask(Task task) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		ObjectNode objectOutNode =objectMapper.createObjectNode();
		 Connection conn 	= null;
		 PreparedStatement preparedStmt = null;
		 
		boolean flag = false;
		
		String strAuth="Authorised", userId;
		
		try{
			
			String strauth = task.getAuthKey();
			userId = tokService.getUserIdFromToken(strauth);
			if(tokService.isTokenValid(strauth))
			{
			
			conn = GetDBConnection.getConnection();
			
			String SQL_QUERY = "INSERT INTO task_master(TaskName,CreatedBy,CreatedDate,IsDeleted) "+
					" VALUES (?,'"+userId+"',NOW(),'N')";
			
			System.out.println("QUERY For insertTask "+SQL_QUERY);
			
			preparedStmt = conn.prepareStatement(SQL_QUERY);

			preparedStmt.setString(1, task.getTask()); 
			
			preparedStmt.executeUpdate();
			flag = true;
			}else
			{
				strAuth="UnAuthorised";
			}
			objectOutNode.put("result",flag);
			objectOutNode.put("message",strAuth);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			GetDBConnection.closePstmt(preparedStmt);
			GetDBConnection.closeConn(conn);
		}
		
		// TODO Auto-generated method stub
		return objectOutNode;
		
	}

	
	public ObjectNode updateTask(Task task) {
		// TODO Auto-generated method stub
		boolean flag = false;
		ObjectNode objectOutNode =objectMapper.createObjectNode();
		 Connection conn 	= null;
		 Statement stmt 	= null;
		 PreparedStatement preparedStmt = null;
		
		 String strAuth="Authorised",userId;
		 
		try
		{
			
			String strauth = task.getAuthKey();
			userId = tokService.getUserIdFromToken(strauth);
			if(tokService.isTokenValid(strauth))
			{
			conn = GetDBConnection.getConnection();
			stmt = conn.createStatement();
			
			String query = "Update task_master set  TaskName = ? ,"
					+ " UpdatedBy = '"+userId+"' , UpdatedDate = NOW() where TaskId = " + task.getId();
			
			System.out.println("updateCustomer query"+query);
			
			preparedStmt = conn.prepareStatement(query);
	    
		    preparedStmt.setString(1, task.getTask());

		      // execute the java preparedstatement
		   preparedStmt.executeUpdate();
		      flag = true;
			}else
			{
				strAuth="UnAuthorised";
			}
			objectOutNode.put("result",flag);
			objectOutNode.put("message",strAuth);
			
			}
		
		catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		finally {
			
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closePstmt(preparedStmt);
			GetDBConnection.closeConn(conn);
		}
	return objectOutNode;
	}
	


	public ObjectNode inactivateTask(Task task) {
		// TODO Auto-generated method stub
		 boolean flag = false;
		 Connection conn 	= null;
		 Statement stmt 	= null;
		 PreparedStatement preparedStmt = null;
		 String userId;
		 String strAuth="Authorised";
		 ObjectNode objectOutNode =objectMapper.createObjectNode();
		try
		{
			String strauth= task.getAuthKey();
			userId = tokService.getUserIdFromToken(strauth);
			if(tokService.isTokenValid(strauth))
			{
			conn = GetDBConnection.getConnection();
			stmt = conn.createStatement();
			String query = "Update task_master set  IsDeleted = 'Y' ,"
					+ " UpdatedBy = '"+userId+"' , UpdatedDate = NOW() where TaskId = " + task.getId();
			
			System.out.println("InactivateTask query = "+query);
			
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.executeUpdate();
		    flag = true;
			}else
			{
				strAuth="UnAuthorised";
			}
			objectOutNode.put("result",flag);
			objectOutNode.put("message",strAuth);
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		finally {
			
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closePstmt(preparedStmt);
			GetDBConnection.closeConn(conn);
		}
		return objectOutNode;
	}
	
	public ObjectNode activateTask(Task task) {
		// TODO Auto-generated method stub
		 boolean flag = false;
		 Connection conn 	= null;
		 Statement stmt 	= null;
		 PreparedStatement preparedStmt = null;
		 String userId;
		 String strAuth="Authorised";
		 ObjectNode objectOutNode =objectMapper.createObjectNode();
		try
		{
			String strauth= task.getAuthKey();
			userId = tokService.getUserIdFromToken(strauth);
			if(tokService.isTokenValid(strauth))
			{
			conn = GetDBConnection.getConnection();
			stmt = conn.createStatement();
			String query = "Update task_master set  IsDeleted = 'N' ,"
					+ " UpdatedBy = '"+userId+"' , UpdatedDate = NOW() where TaskId = " + task.getId();
			System.out.println("activateTask query"+query);
			
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.executeUpdate();
		    flag = true;
			}else
			{
				strAuth="UnAuthorised";
			}
			objectOutNode.put("result",flag);
			objectOutNode.put("message",strAuth);
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		finally {
			
			GetDBConnection.closeStmt(stmt);
			GetDBConnection.closePstmt(preparedStmt);
			GetDBConnection.closeConn(conn);
		}
		return objectOutNode;
	}
}
