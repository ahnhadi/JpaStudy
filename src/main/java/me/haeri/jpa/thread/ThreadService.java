package me.haeri.jpa.thread;

import java.util.List;
import me.haeri.jpa.user.User;

public interface ThreadService {

  List<Thread> getMentionedThreadList(User user);

}
