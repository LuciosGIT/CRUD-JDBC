package application;

import model.dao.DaoFactory;
import model.dao.UsersDao;
import model.entities.Users;

public class Program {

	public static void main(String[] args) {
		UsersDao userDao = null;
		userDao = DaoFactory.createUsersDao();
		System.out.println("=== TEST 1 : findById ===");
		
		System.out.println(userDao.findById(2));
		System.out.println();
		System.out.println("=== TEST 2 : findAll ===");
		
		
		for(Users user : userDao.findAll()) {
			System.out.println(user);
		}
		System.out.println();
		System.out.println("=== TEST 3: insert");
		Users user = new Users();
		user.setId(8);
		user.setName("Wilma");
		user.setEmail("wilma@gmail.com");
		user.setAge(42);
		user.setPhoneNumber("8392876542");
		userDao.insert(user);
		System.out.println("User inserted with success!");
		System.out.println();
		
		System.out.println("=== TEST 4 : update");
		user.setAge(74);
		userDao.update(user);
		System.out.println("User updated with success!");
		
		System.out.println();
		System.out.println("=== TEST 5: deleteById ===");
		userDao.deleteById(9);
		System.out.println("Deletion completed with success!");
	}

}
