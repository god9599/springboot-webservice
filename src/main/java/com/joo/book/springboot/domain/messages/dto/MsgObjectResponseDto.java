package com.joo.book.springboot.domain.messages.dto;

import com.joo.book.springboot.domain.messages.MsgObject;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MsgObjectResponseDto {
    private String msgLang;
    private String msgCode;
    private String msgText;
    private String msgDefinition;
    private Long cusrId;
    private Long musrId;

    public MsgObjectResponseDto(MsgObject entity) {
        this.msgLang = entity.getMsgLang();
        this.msgCode = entity.getMsgCode();
        this.msgText = entity.getMsgText();
        this.msgDefinition = entity.getMsgDefinition();
        this.cusrId = entity.getCusrId();
        this.musrId = entity.getMusrId();
    }
}
