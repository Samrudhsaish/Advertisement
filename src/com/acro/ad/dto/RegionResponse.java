package com.acro.ad.dto;

public class RegionResponse {
    int regionId;
    String regionName;
    String regionCode;
    RegionResponse(){

    }

    public RegionResponse(int regionId, String regionName, String regionCode) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionCode = regionCode;
    }

    public int getRegionId() {


        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
}
