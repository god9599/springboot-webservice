package com.joo.book.springboot.domain.messages;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MsgObejctRepository extends JpaRepository<MsgObject, MsgObjectPk> {
    Optional<MsgObject> findByMsgLangAndMsgCode(String msgLang, String msgCode);
}
