package com.acro.ad.repository;
import com.acro.ad.dto.AdvertisementRequest;
import com.acro.ad.model.Advertisement;
import com.acro.ad.model.Content;
import java.util.List;

public interface IAdvertisementRepository {

    Advertisement createAdvertisement(Advertisement advertisement);
    Advertisement getAdvertisementById( Long advId);
    List<Content> getContentByAdvertisementId(Long advId);
    List<Content> getContentByAdvertisementCompanyId(Long companyId);
    Advertisement getAdvertisementByCompanyId(Long companyId);
}



