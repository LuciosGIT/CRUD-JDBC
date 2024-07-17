package model.entities;

import java.util.Objects;

public class Users {
	private Integer id;
	private String name;
	private String email;
	private Integer age;
	private String phoneNumber;
	
	public Users() {
		
	}

	public Users(Integer id, String name, String email, Integer age, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	
}
