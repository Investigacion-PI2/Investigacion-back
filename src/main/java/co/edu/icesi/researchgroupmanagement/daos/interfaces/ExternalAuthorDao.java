package co.edu.icesi.researchgroupmanagement.daos.interfaces;

import java.util.List;


import co.edu.icesi.researchgroupmanagement.model.ExternalAuthor;


public interface ExternalAuthorDao {
	public ExternalAuthor save(ExternalAuthor ea);
	public ExternalAuthor update(ExternalAuthor ea);
	public void delete (ExternalAuthor ea);
	public List<ExternalAuthor> findAll();
	public ExternalAuthor findById(Integer id);
	public boolean existsById(Integer id);
}