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

  public AdvertisementResponse getAdvertisementById(Long advId) {
    AdvertisementResponse advertisementResponse = new AdvertisementResponse();
    if (advId != null && advId > 0) {
      System.out.println("Retrieve Advertisement Id");
      return advertisementService.getAdvertisementById(advertisementResponse.getAdvId());
    } else if (advId == null) {
      System.out.println("Not Retrieve Advertisement Id");
    }
    return null;
  }

  public AdvertisementResponse getAdvertisementByCompanyId(Long companyId) {
    AdvertisementResponse advertisementResponse = new AdvertisementResponse();
    if (companyId != null && companyId > 0) {
      System.out.println("Received Advertisement Company Id");
      return advertisementService.getAdvertisementByCompanyId(advertisementResponse.getCompanyId());
    } else if (companyId == null) {
      System.out.println("Advertisement company Id is null");
    }
    return null;
  }


  public AdViewResponse getPopularAdvertisementByRegion(int regionId) {
    AdViewResponse adViewResponse = new AdViewResponse();
    if (regionId > 0) {
      System.out.println("Received popular Advertisement by Region Id");
      return advertisementService.getPopularAdvertisementByRegion(adViewResponse.getRegionId());
    } else {
      throw new RuntimeException("Not valid Region Id");
    }

  }
}
