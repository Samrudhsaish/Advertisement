package com.acro.ad.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AdvertisementResponse {
    public Long advId;//pk
    public String advName;
    public Long companyId;
    public Long contentId;
    public LocalDate publishedDate;
    List<ContentResponse> contentResponses;
    public AdvertisementResponse(){

    }

    public AdvertisementResponse(Long advId, String advName, Long companyId, Long contentId, LocalDate publishedDate) {
        this.advId = advId;
        this.advName = advName;
        this.companyId = companyId;
        this.contentId = contentId;
        this.publishedDate = publishedDate;
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
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
    public List<ContentResponse>getContentResponses(){
        return contentResponses;
    }
    public void setContentResponses(List<ContentResponse>contentResponses){
        this.contentResponses=contentResponses;
    }


}
