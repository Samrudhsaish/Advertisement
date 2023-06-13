package com.acro.ad.service;
import com.acro.ad.dto.ContentRequest;
import com.acro.ad.dto.ContentResponse;
import com.acro.ad.model.Content;

import java.util.List;

public interface IContentService {
    ContentResponse createContent(ContentRequest contentRequest);
  //  List<Content> saveContentList(List<Content>content);
    ContentResponse getContentByContentName(String contentName);
    List<ContentResponse> getContentByAdvertisementCompanyId(Long companyId);




    }
