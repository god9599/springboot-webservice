package com.joo.book.springboot.domain.messages;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MsgObejctRepository extends JpaRepository<MsgObject, MsgObjectPk> {
    MsgObject findByMsgLangAndMsgCode(String msgLang, String msgCode);
}
