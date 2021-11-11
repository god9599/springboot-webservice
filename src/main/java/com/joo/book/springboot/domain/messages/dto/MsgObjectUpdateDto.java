package com.joo.book.springboot.domain.messages.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MsgObjectUpdateDto {
    private String msgLang;
    private String msgCode;
    private String msgType;
    private String msgText;
    private String msgDefinition;
    private Long musrId;

    @Builder
    public MsgObjectUpdateDto(String msgLang,
                              String msgCode,
                              String msgType,
                              String msgText,
                              String msgDefinition,
                              Long musrId) {
        this.msgLang = msgLang;
        this.msgCode = msgCode;
        this.msgType = msgType;
        this.msgText = msgText;
        this.msgDefinition = msgDefinition;
        this.musrId = musrId;
    }
}
