package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.UserType;


public interface UserTypeDao {
	public UserType save(UserType ut);
	public UserType update(UserType ut);
	public void delete (UserType ut);
	public List<UserType> findAll();
	public UserType findById(Long id);
	public boolean existsById(Long id);
}
