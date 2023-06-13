package com.acro.ad.repository;
import com.acro.ad.dto.ContentResponse;
import com.acro.ad.model.Content;

import java.util.List;


public interface IContentRepository {
   Content createContent(Content content);
   List<Content> getContentByAdvertisementId(Long advId);
   Content getContentByContentName(String contentName);
   List<ContentResponse> getContentByAdvertisementCompanyId(Long companyId);

}

