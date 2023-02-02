package me.haeri.jpa.userChannel;

import me.haeri.jpa.channel.ChannelRepository;
import me.haeri.jpa.common.PageDTO;
import me.haeri.jpa.user.User;
import me.haeri.jpa.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class UserChannelRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ChannelRepository channelRepository;

//  @Test
//  void userJoinChannelTest() {
//    // given
//    var newChannel = Channel.builder().name("new-channel").build();
//    var newUser = User.builder().username("new-user").password("new-pass").build();
//    var newUserChannel = newChannel.joinUser(newUser);
//
//    // when
//    var savedChannel = channelRepository.insertChannel(newChannel);
//    var savedUser = userRepository.save(newUser);
//
//    // then
//    var foundChannel = channelRepository.selectChannel(savedChannel.getId());
//    assert foundChannel.getUserChannels().stream()
//        .map(UserChannel::getChannel)
//        .map(Channel::getName)
//        .anyMatch(name -> name.equals(newChannel.getName()));
//  }
//
//  @Test
//  void userJoinChannelWithCascadeTest() {
//    // given
//    var newChannel = Channel.builder().name("new-channel").build();
//    var newUser = User.builder().username("new_user").password("new-pass").build();
//    newChannel.joinUser(newUser);
//
//    // when
//    var savedChannel = channelRepository.insertChannel(newChannel);
//    var savedUser = userRepository.save(newUser);
//
//    // then
//    var foundChannel = channelRepository.selectChannel(savedChannel.getId());
//    assert foundChannel.getUserChannels().stream()
//        .map(UserChannel::getChannel)
//        .map(Channel::getName)
//        .anyMatch(name -> name.equals(newChannel.getName()));
//  }

  @Test
  void userCustomFieldSortingTest() {
    // given
    var newUser2 = User.builder().username("new_user").password("new_pass2").build();
    var newUser1 = User.builder().username("new_user").password("new_pass1").build();
    var newUser3 = User.builder().username("new_user").password("3").build();
    userRepository.save(newUser1);
    userRepository.save(newUser2);
    userRepository.save(newUser3);

    // when
    var users = userRepository.findByUsernameWithCustomField("new_user", Sort.by("customField"));
    // customfield의 길이 기준으로 정렬하고 싶을 때
//    var users = userRepository.findByUsername("new_user", JpaSort.unsafe("LENGTH(password"));

    // then
    assert users.get(0).getPassword().equals(newUser1.getPassword());
//    assert users.get(0).getPassword().equals(newUser3.getPassword());
  }

  @Test
  void pageDTOTest() {
    // given
    var newUser2 = User.builder().username("new_user").password("new_pass2").build();
    var newUser1 = User.builder().username("new_user").password("new_pass1").build();
    var newUser3 = User.builder().username("new_user").password("new_pass3").build();
    userRepository.save(newUser1);
    userRepository.save(newUser2);
    userRepository.save(newUser3);
    var PageDTO = new PageDTO(1, 2, "password");

    // when
    var page = userRepository.findAll(PageDTO.toPageable());

    // then
    assert page.getContent().size() == 2;
  }


}