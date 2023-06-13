package com.acro.ad.model;

public class Region {
     int regionId;
     String regionName;
     String regionCode;
     Region(int regionId,String regionName,String regionCode){
         this.regionId=regionId;
         this.regionName=regionName;
         this.regionCode=regionCode;
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
