package me.haeri.jpa.channel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ChannelRepository extends JpaRepository<Channel, Long>,
    QuerydslPredicateExecutor<Channel> {

}

//@Repository
//public class ChannelRepository {
//
//  @PersistenceContext
//  EntityManager entityManager;
//
//  public Channel save(Channel channel) {
//    entityManager.persist(channel);
//    return channel;
//  }
//
//  public Channel findById(Long id) {
//    return entityManager.find(Channel.class, id);
//  }
//}