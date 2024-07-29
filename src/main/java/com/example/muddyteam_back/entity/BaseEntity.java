package com.example.muddyteam_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @PackageName : com.example.muddyteam_back.entity
 * @FileName : BaseEntity
 * @Author : noglass_gongdae
 * @Date : 2024-07-28
 * @Blog : https://blog.naver.com/noglass_gongdae
 * @GitHub :
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(name = "use_yn")
    private boolean useYn;

    @Column(name = "create_code", updatable = false)
    private String createCode = "Muddyteam_back";

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @LastModifiedBy
    @Column(name = "modify_code")
    private String modifyCode;

    @LastModifiedDate
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    @Column(name = "delete_code")
    private String deleteCode;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    public void markDeleted(String delete_code){
        this.deleteDate = LocalDateTime.now();
        this.deleteCode = delete_code;
        this.useYn = false;
    }
}
