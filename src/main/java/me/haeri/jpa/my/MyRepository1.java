package me.haeri.jpa.my;

import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface MyRepository1<User, ID extends Serializable> extends Repository<User, ID> {

  Optional<User> findByUsername(String username);
}
