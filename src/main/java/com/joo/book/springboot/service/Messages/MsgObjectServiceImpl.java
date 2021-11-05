package com.joo.book.springboot.service.Messages;

import com.joo.book.springboot.domain.messages.MsgObejctRepository;
import com.joo.book.springboot.domain.messages.MsgObject;
import com.joo.book.springboot.domain.messages.dto.MsgObjectInsertDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectResponseDto;
import com.joo.book.springboot.domain.messages.dto.MsgObjectUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Transactional
    @Override
    public MsgObjectResponseDto findMsgObject(String msgLang, String msgCode) {
        MsgObject msgObjects = msgObjectRepository.findByMsgLangAndMsgCode(msgLang, msgCode);
        return new MsgObjectResponseDto(msgObjects);
    }

    @Transactional
    @Override
    public void updateMsgObject(String msgLang, String msgCode, MsgObjectUpdateDto msgObjectUpdateDto) {
        MsgObject msgObject = msgObjectRepository.findByMsgLangAndMsgCode(msgLang, msgCode);
        msgObject.update(msgObjectUpdateDto.getMsgLang(), msgObjectUpdateDto.getMsgCode(), msgObjectUpdateDto.getMsgType(), msgObjectUpdateDto.getMsgText(), msgObjectUpdateDto.getMsgDefinition(), msgObjectUpdateDto.getMusrId());
    }

    @Transactional
    @Override
    public void deleteMsgObject(String msgLang, String msgCode) {
        MsgObject msgObjectPk = msgObjectRepository.findByMsgLangAndMsgCode(msgLang, msgCode);
        msgObjectRepository.delete(msgObjectPk);
    }
}