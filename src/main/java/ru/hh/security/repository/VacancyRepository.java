package ru.hh.security.repository;

import org.springframework.stereotype.Repository;
import ru.hh.security.model.Vacancy;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VacancyRepository {

  private final EntityManager entityManager;

  public VacancyRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List<Vacancy> getVacanciesByTitle(String title) {
    return entityManager.createQuery("FROM Vacancy v WHERE lower(v.title) LIKE ?1", Vacancy.class)
        .setParameter(1, '%' + title.toLowerCase() + '%')
        .getResultList();
  }
}
