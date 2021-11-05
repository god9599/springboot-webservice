package com.joo.book.springboot.domain.messages;

import lombok.Data;

import java.io.Serializable;

@Data
public class MsgObjectPk implements Serializable {

    private String msgLang;

    private String msgCode;

}
