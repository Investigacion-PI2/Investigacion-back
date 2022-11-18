package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.User;


public interface UserDao {
	public User save(User u);
	public User update(User u);
	public void delete (User u);
	public List<User> findAll();
	public User findById(Integer id);
	public boolean existsById(Integer id);
	User findByUsername(String username);
}