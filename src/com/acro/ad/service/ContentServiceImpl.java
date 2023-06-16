package com.acro.ad.service;
import com.acro.ad.dto.ContentRequest;
import com.acro.ad.dto.ContentResponse;
import com.acro.ad.model.Content;
import com.acro.ad.repository.ContentRepositoryImpl;
import com.acro.ad.repository.IContentRepository;

import java.util.List;


public  class ContentServiceImpl implements IContentService {
    IContentRepository contentRepository = new ContentRepositoryImpl();


    public ContentResponse createContent(ContentRequest contentRequest) {
        ContentResponse contentResponse = null;
        if (contentRequest != null) {//CHECK IF CONTENT name  ALREADY EXISTS
            ContentResponse contentByName = getContentByContentName(contentRequest.getContentName());
            if (contentByName != null) {
                throw new RuntimeException("Content Name already exists");
            }
            Content content = new Content();
            content.setContentName(contentRequest.getContentName());
            content.setContentType(contentRequest.getContentType());
            content.setCreatedDate(contentRequest.getCreatedDate());
            content.setContentDuration(contentRequest.getContentDuration());
            content.setContentFile(contentRequest.getContentFile());
            content.setInternalOrExternal(contentRequest.isInternalOrExternal());
            content.setStaffId(contentRequest.getStaffId());
            content.setCompanyId(contentRequest.getCompanyId());
            Content contentVariable = contentRepository.createContent(content);
            contentResponse = createContentResponse(contentVariable);
            return contentResponse;

        }
        return null;
    }


    public ContentResponse getContentByContentName(String contentName) {
        ContentRequest contentRequest = new ContentRequest();
        if (contentRequest != null && contentRequest.getContentName() != null && contentRequest.getContentName().length() > 0) {
            Content displayContentName = contentRepository.getContentByContentName(contentRequest.getContentName());
            if (displayContentName != null) {
                System.out.println("ContentName retrieved successfully" + displayContentName.getContentName());
                ContentResponse contentResponse = createContentResponse(displayContentName);//doubt
                return contentResponse;
            }
        }
        return null;
    }

    @Override
    public List<Content> getContentByAdvertisementCompanyId(Long companyId) {
       return contentRepository.getContentByAdvertisementCompanyId(companyId);
    }

    private ContentResponse createContentResponse(Content content) {
        ContentResponse contentResponse = new ContentResponse();
        contentResponse.setContentId(content.getContentId());
        contentResponse.setContentName(content.getContentName());
        contentResponse.setContentType(content.getContentType());
        contentResponse.setContentFile(content.getContentFile());
        contentResponse.setContentDuration(content.getContentDuration());
        contentResponse.setCompanyId(content.getCompanyId());
        contentResponse.setStaffId(content.getStaffId());
        return contentResponse;


    }
}

  /*  public List<Content> saveContentList(List<Content> contents, Long advId) {
        List<Content> result = new ArrayList<>();
        for (Content r : contents)//for(type variablename:arraylistname)
            r.setAdvId(advId);
        Content content = saveContentList(r);
        if (content != null) {
            result.add(content);
            System.out.println("content save failed" + r);

        }
    }
    return result;
}
*/


