package com.acro.ad.model;

import java.time.LocalDate;
import java.util.Date;

public class Advertisement {
    //adv_id bigint PK

    public Long advId;//pk
    public String advName;
    public Long companyId;
    public Long contentId;
    public LocalDate publishedDate;
    public Advertisement(Long advId, String advName, Long companyId, Long contentId, LocalDate publishedDate){
        this.advId=advId;
        this.advName=advName;
        this.companyId=companyId;
        this.contentId=contentId;
        this.publishedDate=publishedDate;
    }

    public Advertisement() {

    }

    public Long getAdvId() {
        return advId;
    }

    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    public String getAdvName() {
        return advName;
    }

    public void setAdvName(String advName) {
        this.advName = advName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public LocalDate getPublishedDate() {
        return  publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}

