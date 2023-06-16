package com.acro.ad.repository;
import com.acro.ad.model.Content;

import java.util.List;


public interface IContentRepository {
   Content createContent(Content content);
   Content getContentByContentName(String contentName);
   List<Content> getContentByAdvertisementId(Long advId);
   List<Content> getContentByAdvertisementCompanyId(Long companyId);

}

