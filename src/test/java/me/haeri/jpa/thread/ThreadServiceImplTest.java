package me.haeri.jpa.thread;

import me.haeri.jpa.user.User;
import me.haeri.jpa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadServiceImplTest {

  @Autowired
  UserRepository userRepository;

  @Autowired
  ThreadService threadService;

  @Test
  void getMentionedThreadList() {
    // given
    var newUser = User.builder().username("new").password("1").build();
    var savedUser = userRepository.save(newUser);

    // when
    var mentionedThreads = threadService.getMentionedThreadList(savedUser);

    // then
    System.out.println(mentionedThreads);
  }

}