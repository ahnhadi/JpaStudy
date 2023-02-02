package me.haeri.jpa.my;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import me.haeri.jpa.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MyRepositoryImpl implements MyRepository2<User> {

  @Autowired
  EntityManager entityManager;

  // simpleJpaRepository의 delete X, 조회기능 빼고 그냥 삭제 기능만 불러오기
  @Override
  public void delete(User user) {
    entityManager.remove(user);
  }

  public List<String> findNameAll() {
    return entityManager.createQuery("SELECT u.username FROM User AS u", String.class)
        .getResultList();
  }
}
