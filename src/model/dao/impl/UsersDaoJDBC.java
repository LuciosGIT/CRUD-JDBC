package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.UsersDao;
import model.entities.Users;

public class UsersDaoJDBC implements UsersDao{
	Connection conn = null;
	
	public UsersDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Users findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("SELECT * FROM users WHERE Id =  ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Users user = instantiateUser(rs);
				return user;
				
			}
			return null;
		}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
			
			
		
	}

	private Users instantiateUser(ResultSet rs) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt("Id"));
		user.setName(rs.getString("Name"));
		user.setEmail(rs.getString("Email"));
		user.setAge(rs.getInt("Age"));
		user.setPhoneNumber(rs.getString("PhoneNumber"));
		return user;
		
	}

	@Override
	public List<Users> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			List<Users> usersList = new ArrayList<>();
			conn = DB.getConnection();
			st = conn.prepareStatement("SELECT * FROM users");
			rs = st.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("Id");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				Integer age = rs.getInt("Age");
				String phoneNumber = rs.getString("PhoneNumber");
				usersList.add(new Users(id, name, email, age, phoneNumber));
			}
			return usersList;
		}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
				
			finally {
				DB.closeResultSet(rs);
				DB.closeStatement(st);
			}
	}

	@Override
	public void insert(Users obj) {
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("INSERT INTO users (Name, Email, Age, PhoneNumber) VALUES (?,?,?,?)");
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setInt(3, obj.getAge());
			st.setString(4, obj.getPhoneNumber());
			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Users obj) {
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("UPDATE USERS SET Name = ?, Email = ?, Age = ? , PhoneNumber = ? WHERE Id = ?");
			st.setString(1, obj.getName());
			st.setString(2, obj.getEmail());
			st.setInt(3, obj.getAge());
			st.setString(4, obj.getPhoneNumber());
			st.setInt(5, obj.getId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement("DELETE FROM users WHERE Id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

}
