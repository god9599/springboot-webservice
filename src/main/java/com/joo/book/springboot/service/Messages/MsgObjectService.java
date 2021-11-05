package com.joo.book.springboot.service.Messages;

import com.joo.book.springboot.domain.messages.dto.MsgObjectInsertDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectResponseDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectUpdateDto;

public interface MsgObjectService {
    MsgObjectResponseDto insertMsgObject(MsgObjectInsertDto msgObjectInsertDto);

    MsgObjectResponseDto findMsgObject(String msgLang, String msgCode);

    void updateMsgObject(String msgLang, String msgCode, MsgObjectUpdateDto msgObjectUpdateDto);

    void deleteMsgObject(String msgLang, String msgCode);
}
