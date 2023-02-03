package me.haeri.jpa.user;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 방법 1
//@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
//public interface UserRepository {
//
//  // findByPassword를 막기위해
//  public Optional<User> findByUsername(String username);
//}

// 방법 2
// MyRepoisotry1을 상속 받아서 해결하기
//public interface UserRepository extends JpaRepository<User, Long>, MyRepository1<User, Long> {
//
//}

//// MyRepository 사용 시
//public interface UserRepository extends JpaRepository<User, Long>, MyRepository2<User> {
//}

// Sort, Pageable 할 때
public interface UserRepository extends JpaRepository<User, Long> {

  // 아래와 같이 AS user_password로 Alias(AS)를 걸어주면
  @Query("SELECT u, u.password AS customField FROM User u WHERE u.username = ?1")
  List<User> findByUsernameWithCustomField(String username, Sort sort);

  @Query("SELECT u FROM User u WHERE u.username = ?1")
  List<User> findByUsername(String username, Sort sort);
}

