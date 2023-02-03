package me.haeri.jpa.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ChannelRepositoryTest {

  @Autowired
  private ChannelRepository channelRepository;

//  @Test
//  void insertSelectGroupTest() {
//    // given
//    var newChannel = Channel.builder().name("new-group").build();
//
//    // when
//    var savedChannel = channelRepository.save(newChannel);
//
//    // then
//    var foundChannel = channelRepository.findById(savedChannel.getId());
////        assert foundChannel.getId().equals(savedChannel.getId());

}

//  @Test
//  void queryDslTest() {
//    // given
//    var newChannel = Channel.builder().name("haeri").build();
//    channelRepository.save(newChannel);
//
//    Predicate predicate = QChannel.channel
//        .name.equalsIgnoreCase("HAERI");
//
//    // when
//    Optional<Channel> optional = channelRepository.findOne(predicate);
//
//    // then
//    assert optional.get().getName().equals(newChannel.getName());
//  }
//}