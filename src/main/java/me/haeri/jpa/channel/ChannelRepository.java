package me.haeri.jpa.channel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}

//@Repository
//public class ChannelRepository {
//
//  @PersistenceContext
//  EntityManager entityManager;
//
//  public Channel insertChannel(Channel channel){
//    entityManager.persist(channel);
//    return channel;
//  }
//
//  public Channel selectChannel(Long id){
//    return entityManager.find(Channel.class, id);
//  }