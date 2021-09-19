package com.devolon.virta.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_company")
public class Company extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "C_NAME", nullable = false)
    private String name;

    @Column(name = "C_CODE", nullable = false)
    private String code;

    @Column(name = "C_COMMENT", nullable = false)
    private String comment;

    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "N_PARENT_ID", insertable = false, updatable = false)
    private Company parent;

    @Column(name = "N_PARENT_ID")
    private Long parentId;

}
