package com.acro.ad.model;

import java.time.LocalDate;

public class Content {
    public Long contentId;
    public String contentName;
    public String contentFile;
    public LocalDate createdDate;
    public String contentType;
    public double contentDuration;
    boolean isInternalOrExternal;
    public Long companyId;
    public Long staffId;
    public Long advId;
    public Content(){
        //default constructor
    }



    public Content(String contentName, String contentFile, LocalDate createdDate,
                   String contentType, double contentDuration, Boolean isInternalOrExternal, Long companyId, Long staffId,Long advId) {
        this.contentName = contentName;
        this.contentFile = contentFile;
        this.createdDate = createdDate;
        this.contentType = contentType;
        this.contentDuration = contentDuration;
        this.isInternalOrExternal = isInternalOrExternal;
        this.companyId = companyId;
        this.staffId = staffId;

    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Long getAdvId() {
        return advId;
    }

    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentFile() {
        return contentFile;
    }

    public void setContentFile(String contentFile) {
        this.contentFile = contentFile;
    }


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public double getContentDuration() {
        return contentDuration;
    }

    public void setContentDuration(double contentDuration) {

        this.contentDuration = contentDuration;
    }

    public boolean isInternalOrExternal() {
        return this.isInternalOrExternal;
    }

    public void setInternalOrExternal(boolean internalOrExternal) {
        isInternalOrExternal = internalOrExternal;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
