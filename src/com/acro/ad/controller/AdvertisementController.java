package com.acro.ad.controller;
import com.acro.ad.dto.AdViewRequest;
import com.acro.ad.dto.AdViewResponse;
import com.acro.ad.dto.AdvertisementRequest;
import com.acro.ad.dto.AdvertisementResponse;
import com.acro.ad.service.AdvertisementServiceImpl;
import com.acro.ad.service.IAdvertisementService;
//select adv_name from advertisement where adv_id;

public class AdvertisementController {
  IAdvertisementService advertisementService = new AdvertisementServiceImpl();

  public AdvertisementResponse saveAdvertisement(AdvertisementRequest advertisementRequest) {
    if (advertisementRequest != null && advertisementRequest.getAdvName() != null &&
            advertisementRequest.getContentRequests() != null && advertisementRequest.getContentRequests().size() > 0) {
      AdvertisementResponse response = advertisementService.createAdvertisement(advertisementRequest);
      return response;
    } else {
      throw new RuntimeException("Required fields are not passed");
    }
  }

  public AdvertisementResponse getAdvertisementById(Long advId) throws Exception {
    AdvertisementRequest advertisementRequest = new AdvertisementRequest();

    if (advertisementRequest!=null&& advertisementRequest.getAdvId() != null && advertisementRequest.getAdvId()>0) {
      AdvertisementResponse response = advertisementService.getAdvertisementById(advertisementRequest.advId);
      return response;
    } else {
      throw new RuntimeException("Required fields are not passed");
    }

  }
  public AdViewResponse getPopularAdvertisementByRegion(Long advId,int regionId) {
    AdViewRequest adViewRequest = new AdViewRequest();
    if (adViewRequest != null && adViewRequest.getAdvId() != null && adViewRequest.getAdvId() > 0 &&
            adViewRequest.getRegionId() > 0) {
      AdViewResponse response = advertisementService.getPopularAdvertisementByRegion(adViewRequest.advId, adViewRequest.regionId);
      return response;
    } else {
      throw new RuntimeException("Required fields are not passed");
    }
  }




}