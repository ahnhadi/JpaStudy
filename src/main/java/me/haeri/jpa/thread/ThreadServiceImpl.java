package me.haeri.jpa.thread;

import com.mysema.commons.lang.IteratorAdapter;
import java.util.List;
import me.haeri.jpa.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadServiceImpl implements ThreadService {

  @Autowired
  ThreadRepository threadRepository;

  @Override
  public List<Thread> getMentionedThreadList(User user) {
    var thread = QThread.thread;

    var predicate = thread.mentions.any().user.eq(user);
    var threads = threadRepository.findAll();
    return IteratorAdapter.asList(threads.iterator());
  }
}
