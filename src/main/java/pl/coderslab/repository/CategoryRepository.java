package pl.coderslab.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

}
