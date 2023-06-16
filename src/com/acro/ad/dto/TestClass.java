package com.acro.ad.dto;
import com.acro.ad.controller.AdvertisementController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TestClass {//advid-pk,advname,publisheddate,companyid-pk
     AdvertisementController advertisementController = new AdvertisementController();

     public static void main(String[] args) {
         TestClass test=new TestClass();


         try{
            AdvertisementRequest advertisementRequest = new AdvertisementRequest();
            AdViewRequest adViewRequest=new AdViewRequest();
            advertisementRequest.setAdvId(7L);
            advertisementRequest.setCompanyId(1L);
            adViewRequest.setRegionId(105);

             AdvertisementResponse advertisementResponseById=test.advertisementController.getAdvertisementById(advertisementRequest.getAdvId());
             System.out.println(advertisementResponseById);
             AdvertisementResponse advertisementResponseByCompanyId=test.advertisementController.getAdvertisementByCompanyId(advertisementRequest.getCompanyId());
             System.out.println(advertisementResponseByCompanyId);
             AdViewResponse adViewResponseByGetPopularAdByRegionId=test.advertisementController.getPopularAdvertisementByRegion(adViewRequest.getRegionId());
             System.out.println(adViewResponseByGetPopularAdByRegionId);


         } catch (Exception e) {
              throw new RuntimeException(e);
         }

    }
    private AdvertisementRequest createAdvertisementRequest(){
         AdvertisementRequest advertisementRequest=new AdvertisementRequest();
         List<ContentRequest> contentRequest=new ArrayList<>();
         advertisementRequest.setAdvName("Colgate Toothpaste");
         advertisementRequest.setCompanyId(1L);
         advertisementRequest.setPublishedDate(LocalDate.now());
         contentRequest.add(createContentRequest());
         advertisementRequest.setContentRequests(contentRequest);
         return advertisementRequest;
    }

    private ContentRequest createContentRequest() {
       ContentRequest contentRequest=new ContentRequest();
       contentRequest.setContentName("Colgate Optic White");
       contentRequest.setContentDuration(1.0D);
       contentRequest.setContentFile("C:\\Users\\mangi\\Videos\\Captures\\layout.mp4");
       contentRequest.setContentType(" video ");
       contentRequest.setCreatedDate(LocalDate.now());
       contentRequest.setCompanyId(1L);
       contentRequest.setStaffId(1L);
       return contentRequest;

    }
    /*private AdViewRequest createAdViewRequest(){
        AdViewRequest adViewRequest=new AdViewRequest();
        adViewRequest.setAdv("Colgate Toothpaste");
        adViewRequest.setCompanyId(1L);
        adViewRequest.setPublishedDate(LocalDate.now());
        adViewRequest.setContentRequests(contentRequest);
        return adViewRequest;
    }*/

}
