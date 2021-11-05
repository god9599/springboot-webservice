package com.joo.book.springboot.service.Messages;

import com.joo.book.springboot.domain.messages.MsgObejctRepository;
import com.joo.book.springboot.domain.messages.MsgObject;
import com.joo.book.springboot.domain.messages.dto.MsgObjectInsertDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectResponseDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectUpdateDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MsgObjectServiceImplTest {

    @Autowired
    private MsgObejctRepository msgObejctRepository;

    @AfterEach
    void clean() {
        msgObejctRepository.deleteAll();
    }

    @Test
    void insertMsgObject() {
        MsgObjectInsertDto msgObjectInsertDto = MsgObjectInsertDto.builder()
                .msgLang("kr")
                .msgCode("code1")
                .msgText("i'm code")
                .msgDefinition("introduce")
                .cusrId(1L)
                .build();

        MsgObject msgObject = msgObjectInsertDto.toEntity();

        Assertions.assertEquals(msgObject.getMsgCode(), "code1");
        Assertions.assertEquals(msgObject.getMsgDefinition(), "introduce");
    }

    @Test
    void findMsgObject() {
        MsgObject save = MsgObject.builder()
                .msgLang("z")
                .msgCode("f")
                .msgType("zz")
                .msgText("z")
                .msgDefinition("gg")
                .cusrId(1L)
                .musrId(1L)
                .build();

        msgObejctRepository.save(save);

        MsgObject byMsgLangAndMsgCode = msgObejctRepository.findByMsgLangAndMsgCode("z", "f");

        MsgObjectResponseDto msgObjectResponseDto = new MsgObjectResponseDto(byMsgLangAndMsgCode);

        Assertions.assertEquals(msgObjectResponseDto.getMsgCode(), "f");


    }

    @Test
    void updateMsgObject() {
        MsgObject save = MsgObject.builder()
                .msgLang("z")
                .msgCode("f")
                .msgType("zz")
                .msgText("z")
                .msgDefinition("gg")
                .cusrId(1L)
                .build();

        msgObejctRepository.save(save);

        MsgObject byMsgLangAndMsgCode = msgObejctRepository.findByMsgLangAndMsgCode("z", "f");

        MsgObjectUpdateDto msgObjectUpdateDto = MsgObjectUpdateDto.builder()
                .msgLang("z")
                .msgCode("fff")
                .msgType("zzz")
                .msgText("zz")
                .msgDefinition("gg")
                .musrId(2L)
                .build();

        String update = byMsgLangAndMsgCode.update(msgObjectUpdateDto.getMsgLang(),
                msgObjectUpdateDto.getMsgCode(),
                msgObjectUpdateDto.getMsgType(),
                msgObjectUpdateDto.getMsgText(),
                msgObjectUpdateDto.getMsgDefinition(),
                msgObjectUpdateDto.getMusrId());

        Assertions.assertEquals(update, "fff");
    }

    @Test
    void deleteMsgObject() {
        MsgObject save = MsgObject.builder()
                .msgLang("z")
                .msgCode("f")
                .msgType("zz")
                .msgText("z")
                .msgDefinition("gg")
                .cusrId(1L)
                .build();

        msgObejctRepository.save(save);
        msgObejctRepository.delete(msgObejctRepository.findByMsgLangAndMsgCode("z", "f"));
        Assertions.assertNull(msgObejctRepository.findByMsgLangAndMsgCode("z", "f"));
    }
}
