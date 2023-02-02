//package me.haeri.jpa.thread;
//
//import me.haeri.jpa.channel.Channel;
//import me.haeri.jpa.channel.ChannelRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Set;
//
//@SpringBootTest
//@Transactional
//@Rollback(value = false)
//class ThreadRepositoryTest {
//
//    @Autowired
//    private ThreadRepository threadRepository;
//
//    @Autowired
//    private ChannelRepository channelRepository;
//
//    @Test
//    void insertSelectThreadTest() {
//        // given
//        var newChannel = Channel.builder().name("new-channel").build();
//        var newThread = Thread.builder().message("new-messeage").build();
//        var newThread2 = Thread.builder().message("new-messeage2").build();
//        newThread.setChannel(newChannel);
//        newThread2.setChannel(newChannel);
//
//        // when
//        var savedChannel = channelRepository.insertChannel(newChannel);
//        var savedThread = threadRepository.insertThread(newThread);
//        var savedThread2 = threadRepository.insertThread(newThread2);
//
//
//        // then
////        var foundThread = threadRepository.selectThread(savedThread.getId());
////        assert foundThread.getChannel().getName().equals(newChannel. getName());
//        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
//        assert foundChannel.getThreads().containsAll(Set.of(savedThread, savedThread2));
//    }
//
//    @Test
//    void deleteThreadbyOrphanRemovalTest() {
//        // given
//        var newChannel = Channel.builder().name("new-channel").build();
//        var newThread = Thread.builder().message("new-messeage").build();
//        var newThread2 = Thread.builder().message("new-messeage2").build();
//        newThread.setChannel(newChannel);
//        newThread2.setChannel(newChannel);
//        var savedChannel = channelRepository.insertChannel(newChannel);
//        var savedThread = threadRepository.insertThread(newThread);
//        var savedThread2 = threadRepository.insertThread(newThread2);
//
//        // when
//        var foundChannel = channelRepository.selectChannel(savedChannel.getId());
//        foundChannel.getThreads().remove(savedThread);
//
//
//        // then
////        delete
////                from
////        thread
////                where
////        id=?
//    }
//
//}