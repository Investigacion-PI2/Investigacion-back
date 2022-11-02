package co.edu.icesi.researchgroupmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.icesi.researchgroupmanagement.model.ResearchGroup;

@Repository
public class ResearchGroupDao {
    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public ResearchGroup save(ResearchGroup researchGroup) {
        return entityManager.merge(researchGroup);
    }

    @Transactional
    public ResearchGroup update(ResearchGroup researchGroup) {
        return entityManager.merge(researchGroup);
    }

    @Transactional
    public void delete(ResearchGroup researchGroup) {
        entityManager.remove(researchGroup);
    }

    public List<ResearchGroup> findAll() {
        String jpql = "SELECT rg FROM ResearchGroup rg";
        return entityManager.createQuery(jpql).getResultList();
    }

    public ResearchGroup findById(Long id) {
        String jpql = "SELECT rg FROM ResearchGroup rg WHERE rg.id = :id";
        Query q = entityManager.createQuery(jpql);
        q.setParameter("id", id);
        return (ResearchGroup) q.getSingleResult();
    }

    public List<ResearchGroup> findByFaculty(String name) {
        String jpql = "SELECT rg FROM ResearchGroup rg WHERE rg.faculty.name = :name";
        Query q = entityManager.createQuery(jpql);
        q.setParameter("name", name);
        return q.getResultList();
    }

}