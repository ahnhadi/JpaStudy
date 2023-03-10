package me.haeri.jpa.my;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Import(MyRepositoryRegistrar.class) // 빈 주입!
@SpringBootTest
public class MyRepositoryTest {

    @Autowired
    MyRepository myRepository;

    @Test
    void myRepositoryTest() {
        // given
        var newData = "NEW DATA";
        var savedId = myRepository.save(newData);

        // when
        var newDataList = myRepository.find(savedId);

        // then
        System.out.println(newDataList);
    }
}