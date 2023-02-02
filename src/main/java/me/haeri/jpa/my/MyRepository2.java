package me.haeri.jpa.my;

import java.util.List;

public interface MyRepository2<T> {

  void delete(T entity);

  List<String> findNameAll();
}
