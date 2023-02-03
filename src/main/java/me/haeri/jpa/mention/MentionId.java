package me.haeri.jpa.mention;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class MentionId implements Serializable {

//  @Serial
//  private static final long serialVersionUID = ;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "thread_id")
  private Long threadId;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MentionId mentionId = (MentionId) o;
    return Objects.equals(getUserId(), mentionId.getUserId()) && Objects.equals(getThreadId(),
        mentionId.getThreadId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserId(), getThreadId());
  }


}
