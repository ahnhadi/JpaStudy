package me.haeri.jpa.my;

import java.util.List;
import me.haeri.jpa.user.User;
import me.haeri.jpa.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class MyUserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Autowired
  MyUserRepository myUserRepository;

  @Test
  void myUserRepositoryDeleteTest() {

    // given
    var newUser = User.builder().username("new").password("pass").build();
    userRepository.save(newUser);

    // when
    userRepository.delete(newUser);

    // then
  }

  @Test
  void myUserRepositoryFindNameAllTest() {
    // given
    var newUser1 = User.builder().username("new1").password("pass1").build();
    var newUser2 = User.builder().username("new2").password("pass2").build();
    userRepository.save(newUser1);
    userRepository.save(newUser2);

    // when
    var userNameList = myUserRepository.findNameAll();

    // then
    Assertions.assertThat(
        userNameList.containsAll(List.of(newUser1.getUsername(), newUser2.getUsername())));
  }
}
