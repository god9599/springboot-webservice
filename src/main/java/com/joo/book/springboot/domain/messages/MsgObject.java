package com.joo.book.springboot.domain.messages;

import com.joo.book.springboot.domain.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@IdClass(MsgObjectPk.class)
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MsgObject extends BaseTimeEntity {

    @Id
    @Column(nullable = false, columnDefinition = "varchar(200)")
    private String msgLang;

    @Id
    @Column(nullable = false, columnDefinition = "varchar(10)")
    private String msgCode;

    @Column(nullable = false, columnDefinition = "varchar(10)")
    private String msgType;

    @Column(nullable = false, columnDefinition = "varchar(4000)")
    private String msgText;

    @Column(columnDefinition = "varchar(4000)")
    private String msgDefinition;

    @Column
    private Long cusrId;

    @Column
    private Long musrId;

    @Builder
    public MsgObject(String msgLang, String msgCode, String msgType, String msgText, String msgDefinition, Long cusrId, Long musrId){
        this.msgLang = msgLang;
        this.msgCode = msgCode;
        this.msgType = msgType;
        this.msgText = msgText;
        this.msgDefinition = msgDefinition;
        this.cusrId = cusrId;
    }

    public String update(String msgLang, String msgCode, String msgType, String msgText, String msgDefinition, Long musrId) {
        this.msgLang = msgLang;
        this.msgCode = msgCode;
        this.msgType = msgType;
        this.msgText = msgText;
        this.msgDefinition = msgDefinition;
        this.musrId = musrId;

        return msgCode;
    }
}

