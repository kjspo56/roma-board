package com.kjs.roma.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public class CommonField implements Serializable {

    @Serial
    private static final long serialVersionUID = -7159249708329738350L;

    @Column(name = "reg_date", nullable = false, updatable = false)
    private Timestamp regDate;
    @Column(name = "mod_date", nullable = true)
    private Timestamp modDate;
    @Column(name = "reg_member", nullable = true, updatable = false)
    private Integer regMember;
    @Column(name = "mod_member", nullable = true, updatable = true)
    private Integer modMember;

    @PrePersist
    protected void onCreate() {
        regDate = Timestamp.valueOf(LocalDateTime.now());
        modDate = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        modDate = Timestamp.valueOf(LocalDateTime.now());
    }

    public void setMember(int member) {
        this.regMember = member;
        this.modMember = member;
    }
}
