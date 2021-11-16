package com.joo.book.springboot.service.Messages;

import com.joo.book.springboot.domain.messages.MsgObejctRepository;
import com.joo.book.springboot.domain.messages.MsgObject;
import com.joo.book.springboot.domain.messages.dto.MsgObjectInsertDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectResponseDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MsgObjectServiceImpl implements MsgObjectService{

    private final MsgObejctRepository msgObjectRepository;

    @Transactional
    @Override
    public MsgObjectResponseDto insertMsgObject(MsgObjectInsertDto msgObjectDto) {
        MsgObject msgObject = msgObjectRepository.save(msgObjectDto.toEntity());
        return new MsgObjectResponseDto(msgObject);
    }

    @Transactional(readOnly = true)
    @Override
    public MsgObjectResponseDto findMsgObject(String msgLang, String msgCode) {
        Optional<MsgObject> msgObject = msgObjectRepository.findByMsgLangAndMsgCode(msgLang, msgCode);
        return msgObject.map(MsgObjectResponseDto::new).orElseGet(MsgObjectResponseDto::new);
    }

    @Transactional
    @Override
    public void updateMsgObject(String msgLang, String msgCode, MsgObjectUpdateDto msgObjectUpdateDto) {
        MsgObject msgObject = msgNullCheck(msgLang, msgCode);
        msgObject.update(msgObjectUpdateDto.getMsgLang(),
                msgObjectUpdateDto.getMsgCode(),
                msgObjectUpdateDto.getMsgType(),
                msgObjectUpdateDto.getMsgText(),
                msgObjectUpdateDto.getMsgDefinition(),
                msgObjectUpdateDto.getMusrId());
    }

    @Transactional
    @Override
    public void deleteMsgObject(String msgLang, String msgCode) {
        MsgObject msgObject = msgNullCheck(msgLang, msgCode);
        msgObjectRepository.delete(msgObject);
    }

    public MsgObject msgNullCheck(String msgLang, String msgCode) {

        return msgObjectRepository.findByMsgLangAndMsgCode(msgLang, msgCode)
                .orElseThrow(() -> new IllegalArgumentException("해당 메시지가 없습니다."));
    }

    public void duplicateCheck(String msgLang, String msgCode) {
        msgObjectRepository.findByMsgLangAndMsgCode(msgLang, msgCode)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 메시지입니다.");
                });
    }
}