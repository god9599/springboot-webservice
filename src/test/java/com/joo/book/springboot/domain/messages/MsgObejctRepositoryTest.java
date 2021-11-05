package com.joo.book.springboot.domain.messages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MsgObejctRepositoryTest {
    @Autowired
    MsgObejctRepository messagesRepository;

    @BeforeEach
    public void cleanUp() {
        messagesRepository.deleteAll();
    }

    @Test
    public void insert() {
        MsgObject save = MsgObject.builder()
                .msgLang("z")
                .msgCode("f")
                .msgType("zz")
                .msgText("z")
                .msgDefinition("gg")
                .cusrId(1L)
                .build();

        MsgObject save1 = messagesRepository.save(save);

        System.out.println(messagesRepository.findAll());

        MsgObject msgObject = messagesRepository.findByMsgLangAndMsgCode("z", "f");

        Assertions.assertEquals(msgObject.getMsgCode(), "f");
    }
}