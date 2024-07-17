package model.dao;

import db.DB;
import model.dao.impl.UsersDaoJDBC;

public class DaoFactory {
	public static UsersDao createUsersDao() {
		return new UsersDaoJDBC(DB.getConnection());
	}
}
