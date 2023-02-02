package me.haeri.jpa.my;

import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MyUserRepository {

  @Autowired
  EntityManager entityManager;

  List<String> findNameAll() {
    return entityManager.createQuery("SELECT u.username FROM User AS u", String.class)
        .getResultList();
  }
}
