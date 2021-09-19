package com.devolon.virta.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "C_NAME", nullable = false)
    private String name;

    @Column(name = "C_CODE", nullable = false)
    private String code;

    @Column(name = "N_LATITUDE")
    private Double latitude;

    @Column(name = "N_LONGITUDE")
    private Double longitude;

    @Column(name = "C_COMMENT", nullable = false)
    private String comment;

    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "N_COMPANY_ID", insertable = false, updatable = false)
    private Company company;

    @Column(name = "N_COMPANY_ID")
    private Long companyId;

}
