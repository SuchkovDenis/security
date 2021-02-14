package ru.hh.security.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VacancyRepository {

  private final EntityManager entityManager;

  public VacancyRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public List getVacanciesByTitle(String title) {
    return entityManager.createNativeQuery("SELECT * FROM vacancies WHERE title ILIKE '%" + title + "%'").getResultList();
  }
}
