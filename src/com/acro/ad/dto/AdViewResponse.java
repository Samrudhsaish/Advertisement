package com.acro.ad.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AdViewResponse {
    public Long advId;
    public Long platformId;
    public int regionId;
    public int countryId;
    public LocalDate adViewDate;
    public LocalTime viewDuration;
    public AdViewResponse(){

    }
    public AdViewResponse(Long advId, Long platformId, int regionId, int countryId, LocalDate adViewDate, LocalTime viewDuration) {
        this.advId = advId;
        this.platformId = platformId;
        this.regionId = regionId;
        this.countryId = countryId;
        this.adViewDate = adViewDate;
        this.viewDuration = viewDuration;
    }

    public Long getAdvId() {
        return advId;
    }

    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    public Long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public LocalDate getAdViewDate() {
        return adViewDate;
    }

    public void setAdViewDate(LocalDate adViewDate) {
        this.adViewDate = adViewDate;
    }

    public LocalTime getViewDuration() {
        return viewDuration;
    }

    public void setViewDuration(LocalTime viewDuration) {
        this.viewDuration = viewDuration;
    }
}
