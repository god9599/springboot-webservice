package com.joo.book.springboot.domain.messages.dto;

import com.joo.book.springboot.domain.messages.MsgObject;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MsgObjectInsertDto {
    private String msgLang;
    private String msgCode;
    private String msgText;
    private String msgDefinition;
    private Long cusrId;

    @Builder
    public MsgObjectInsertDto(String msgLang, String msgCode, String msgText, String msgDefinition, Long cusrId) {
        this.msgLang = msgLang;
        this.msgCode = msgCode;
        this.msgText = msgText;
        this.msgDefinition = msgDefinition;
        this.cusrId = cusrId;
    }

    public MsgObject toEntity() {
        return MsgObject.builder()
                .msgLang(msgLang)
                .msgCode(msgCode)
                .msgText(msgText)
                .msgDefinition(msgDefinition)
                .cusrId(cusrId)
                .build();
    }
}
