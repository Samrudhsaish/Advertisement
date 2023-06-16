package com.acro.ad.service;

import com.acro.ad.dto.AdViewResponse;
import com.acro.ad.dto.AdvertisementRequest;
import com.acro.ad.dto.AdvertisementResponse;

public interface IAdvertisementService {
    AdvertisementResponse createAdvertisement(AdvertisementRequest advertisementRequest);
    AdvertisementResponse getAdvertisementById(Long advId);
    AdvertisementResponse getAdvertisementByCompanyId(Long companyId);
     AdViewResponse getPopularAdvertisementByRegion(int regionId);


    }
