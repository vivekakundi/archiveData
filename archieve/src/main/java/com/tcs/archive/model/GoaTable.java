package com.tcs.archive.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class GoaTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int form6Id;
    @Column(unique = true)
    private String formSubmissionReferenceNumber;
    private String residingInIndia;
    private String stateCd;
    private String districtCd;
    private int assemblyConstituencyNumber;
    private char firstTimeVoter;
    private char shiftingFromConstituency;
}
