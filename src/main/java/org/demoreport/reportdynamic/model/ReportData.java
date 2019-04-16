package org.demoreport.reportdynamic.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class ReportData {
    @Id
    private String ampid;
    private String project_title;
    private String creator;
    private String modified_date;
    private String locationname;
    private String actual_start_date;
    private String primary_sector;
    private String budget_code;
    @NotNull
    private Long first_commitment=0L;
    @NotNull
    private Long first_disbursement=0L;
    @NotNull
    private Long second_commitment=0L;
    @NotNull
    private Long second_disbursement=0L;
    @NotNull
    private Long third_commitment=0L;
    @NotNull
    private Long third_disbursement=0L;
    @NotNull
    private Long four_commitment=0L;
    @NotNull
    private Long four_disbursement=0L;
    @NotNull
    private Long five_commitment=0L;
    @NotNull
    private Long five_disbursement=0L;

    public Long getFirst_commitment() {
        return first_commitment;
    }

    public void setFirst_commitment(Long first_commitment) {
        if(first_commitment==null)
            this.first_commitment=0L;
        else
            this.first_commitment = first_commitment;
    }

    public Long getFirst_disbursement() {
        return first_disbursement;
    }

    public void setFirst_disbursement(Long first_disbursement) {
        if(first_disbursement==null)
            this.first_disbursement=0L;

        else   this.first_disbursement = first_disbursement;

    }

    public Long getSecond_commitment() {
        return second_commitment;
    }

    public void setSecond_commitment(Long second_commitment) {
        if(second_commitment==null)
            this.second_commitment=0L;
        else
            this.second_commitment = second_commitment;
    }

    public Long getSecond_disbursement() {
        return second_disbursement;
    }

    public void setSecond_disbursement(Long second_disbursement) {
        if(second_disbursement==null)
            this.second_disbursement=0L;
        else
            this.second_disbursement = second_disbursement;

    }

    public Long getThird_commitment() {
        return third_commitment;
    }

    public void setThird_commitment(Long third_commitment) {
        if(third_commitment==null)
            this.third_commitment=0L;
        else
            this.third_commitment = third_commitment;
    }

    public Long getThird_disbursement() {
        return third_disbursement;
    }

    public void setThird_disbursement(Long third_disbursement) {
        if(third_disbursement==null)
            this.third_disbursement=0L;
        else
            this.third_disbursement = third_disbursement;
    }

    public Long getFour_commitment() {
        return four_commitment;
    }

    public void setFour_commitment(Long four_commitment) {
        if(four_commitment==null)
            this.four_commitment=0L;
        else
            this.four_commitment = four_commitment;
    }

    public Long getFour_disbursement() {
        return four_disbursement;
    }

    public void setFour_disbursement(Long four_disbursement) {
        if(four_disbursement==null)
            this.four_disbursement=0L;
        else
            this.four_disbursement = four_disbursement;
    }

    public Long getFive_commitment() {
        return five_commitment;
    }

    public void setFive_commitment(Long five_commitment) {
        if(five_commitment==null)
            this.five_commitment=0L;
        else
            this.five_commitment = five_commitment;
    }

    public Long getFive_disbursement() {
        return five_disbursement;
    }

    public void setFive_disbursement(Long five_disbursement) {
        if(five_disbursement==null)
            this.five_disbursement=0L;
        else
            this.five_disbursement = five_disbursement;
    }
}
