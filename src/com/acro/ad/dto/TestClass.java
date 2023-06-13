package com.acro.ad.dto;
import com.acro.ad.controller.AdvertisementController;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class TestClass {//advid-pk,advname,publisheddate,companyid-pk
     AdvertisementController advertisementController = new AdvertisementController();

     public static void main(String[] args) {
         TestClass test=new TestClass();
        //Long advId=null;

         try{
            AdvertisementRequest advertisementRequest = new AdvertisementRequest();
            advertisementRequest.setAdvId(7L);
           // advertisementRequest.setCompanyId(1L);

             AdvertisementResponse advertisementResponseById=test.advertisementController.getAdvertisementById(advertisementRequest.advId);
             System.out.println(advertisementResponseById);

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

}
