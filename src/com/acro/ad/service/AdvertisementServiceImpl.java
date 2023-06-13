package com.acro.ad.service;
import com.acro.ad.dto.AdViewResponse;
import com.acro.ad.dto.AdvertisementRequest;
import com.acro.ad.dto.AdvertisementResponse;
import com.acro.ad.dto.ContentResponse;
import com.acro.ad.model.Advertisement;
import com.acro.ad.model.Content;
import com.acro.ad.repository.AdvertisementRepositoryImpl;
import com.acro.ad.repository.ContentRepositoryImpl;
import com.acro.ad.repository.IAdvertisementRepository;
import com.acro.ad.repository.IContentRepository;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementServiceImpl implements IAdvertisementService {
    IAdvertisementRepository advertisementRepository = new AdvertisementRepositoryImpl();
    IContentRepository contentRepository = new ContentRepositoryImpl();

    public AdvertisementResponse createAdvertisement(AdvertisementRequest advertisementRequest) {
        if (advertisementRequest != null) {
            if (advertisementRequest.getAdvId() == null ||
                    advertisementRequest.getAdvName().length() <= 9 ||
                    advertisementRequest.getCompanyId() == null ||
                    advertisementRequest.getPublishedDate() == null) {
                throw new RuntimeException("Invalid advertisement request");

            }

            Advertisement advertisement = new Advertisement();
            advertisement.setAdvName(advertisementRequest.getAdvName());
            advertisement.setCompanyId(advertisementRequest.getCompanyId());
            advertisement.setPublishedDate(advertisementRequest.getPublishedDate());
            Advertisement advertisementOne = advertisementRepository.createAdvertisement(advertisement);
            AdvertisementResponse advertisementResponse = createAdvertisementResponse(advertisementOne);

            if (advertisementRequest.getContentRequests() != null &&
                    advertisementRequest.getContentRequests().size() > 0) {
                advertisementRequest.getContentRequests().forEach(contentRequest -> {
                    Content content = new Content();
                    content.setContentName(contentRequest.getContentName());//request conerts to model conent
                    content.setContentDuration(contentRequest.getContentDuration());
                    content.setContentFile(contentRequest.getContentFile());
                    content.setContentType(contentRequest.getContentType());
                    content.setCreatedDate(contentRequest.getCreatedDate());
                    content.setCompanyId(contentRequest.getCompanyId());
                    content.setStaffId(contentRequest.getStaffId());
                    content.setAdvId(advertisementOne.getAdvId());//newly created advid29line
                    Content contentOne = contentRepository.createContent(content);
                    populateContentResponse(advertisementResponse, content);
                });
                return advertisementResponse;
            } else {
                throw new RuntimeException("failed Request");
            }
        } else {
            throw new RuntimeException("Invalid Request");
        }

    }

    private void populateContentResponse(AdvertisementResponse advertisementResponse, Content content) {
        ContentResponse contentResponse = new ContentResponse();
        contentResponse.setContentId(content.getContentId());
        contentResponse.setContentName(content.getContentName());
        contentResponse.setContentFile(content.getContentFile());
        contentResponse.setCreatedDate(content.getCreatedDate());
        contentResponse.setContentType(content.getContentType());
        contentResponse.setContentDuration(content.getContentDuration());
        contentResponse.setCompanyId(content.getCompanyId());
        contentResponse.setStaffId(content.getStaffId());
        contentResponse.setAdvId(content.getAdvId());

        advertisementResponse.getContentResponses().add(contentResponse);//ADDING IN ADV RESPONSE

    }

    private AdvertisementResponse createAdvertisementResponse(Advertisement advertisement) {
        AdvertisementResponse advertisementResponse = new AdvertisementResponse();
        advertisementResponse.setAdvId(advertisement.getAdvId());
        advertisementResponse.setAdvName(advertisement.getAdvName());
        advertisementResponse.setCompanyId(advertisement.getCompanyId());
        advertisementResponse.setPublishedDate(advertisement.getPublishedDate());
        advertisementResponse.setContentResponses(new ArrayList<>());
        return advertisementResponse;
    }

    public AdvertisementResponse getAdvertisementById(Long advId) {
        AdvertisementRequest advertisementRequest = new AdvertisementRequest();
        if (advertisementRequest.getAdvId() != null && advertisementRequest.getAdvId() > 0
                && advertisementRequest.getCompanyId() != null && advertisementRequest.getCompanyId() > 0) {
            Advertisement advertisement = advertisementRepository.getAdvertisementById(advertisementRequest.getAdvId());
            if (advertisement != null) {
                System.out.println("Retrieve Advertisement by advId" + advertisement.getAdvId());
                AdvertisementResponse advertisementResponse = createAdvertisementResponse(advertisement);
                List<Content> contentByAdvertisementId = advertisementRepository.getContentByAdvertisementId(advertisementResponse.getAdvId());
                contentByAdvertisementId.forEach(content -> populateContentResponse(advertisementResponse, content));
                return advertisementResponse;
            }
        }

        return null;
    }

    public AdvertisementResponse getAdvertisementByCompanyId(Long companyId) {
        AdvertisementRequest advertisementRequest = new AdvertisementRequest();
        if (advertisementRequest.getCompanyId() != null && advertisementRequest.getCompanyId() > 0) {
            Advertisement advertisement = advertisementRepository.getAdvertisementByCompanyId(advertisementRequest.getCompanyId());
            if (advertisement != null) {
                System.out.println("Retrieve Advertisement By Company Id " + advertisement.getCompanyId());
                AdvertisementResponse advertisementResponse = createAdvertisementResponse(advertisement);
                List<Content> contentByCompanyId = advertisementRepository.getContentByAdvertisementCompanyId(advertisementResponse.getCompanyId());
                contentByCompanyId.forEach(content -> populateContentResponse(advertisementResponse, content));
                return advertisementResponse;

            }
        }
        return null;
    }


    public AdViewResponse getPopularAdvertisementByRegion(Long advId, int regionId) {


        return null;
    }
}





