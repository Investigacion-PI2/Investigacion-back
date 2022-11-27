package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;

import co.edu.icesi.researchgroupmanagement.model.User;


public interface UserDao {
	public User save(User u);
	public User update(User u);
	public void delete (User u);
	public List<User> findAll();
	public boolean existsById(Long id);
	User findByUsername(String username);
	public User findById(Long userId);
}
