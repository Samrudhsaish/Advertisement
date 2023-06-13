package com.acro.ad.controller;

import com.acro.ad.dto.ContentRequest;
import com.acro.ad.dto.ContentResponse;
import com.acro.ad.service.ContentServiceImpl;
import com.acro.ad.service.IContentService;


public class ContentController {
 IContentService contentService=new ContentServiceImpl();

    public ContentResponse saveContent(ContentRequest contentRequest) {
        if(contentRequest!=null && contentRequest.getContentName()!=null && contentRequest.getContentFile()!=null &&
                contentRequest.getCompanyId()!=null &&contentRequest.getAdvId()>0 && contentRequest.getCompanyId()>0
        &&contentRequest.getStaffId()>0&&contentRequest.getCreatedDate()!=null&&contentRequest.getContentType()!=null
        &&contentRequest.getContentDuration()== contentRequest.contentDuration){
            ContentResponse response=contentService.createContent(contentRequest);
            return response;
        }else{
            throw new RuntimeException("Required fields are not passed");
        }
      }

}
