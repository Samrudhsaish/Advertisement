package com.acro.ad.repository;
import com.acro.ad.dbconnection.DbConnection;
import com.acro.ad.dto.ContentResponse;
import com.acro.ad.model.Content;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public  class ContentRepositoryImpl implements IContentRepository {
    DbConnection dbconnection = new DbConnection();

    public Content createContent(Content content) {
        //Long contentId = null;

        Connection connection = dbconnection.getConnection();
        try {
            String mysqlInsert = "Insert into content(content_name,content_file," +
                    "created-date,content_type,contentduration,isinternalorexternal,company_id,staff_id,adv_id) " +
                    "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(mysqlInsert, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, content.getContentName());
            pst.setString(2, content.getContentFile());
            pst.setDate(3,Date.valueOf(content.getCreatedDate()));
            pst.setString(4, content.getContentType());
            pst.setDouble(5, content.getContentDuration());
            pst.setBoolean(6, content.isInternalOrExternal());
            pst.setLong(7, content.getCompanyId());
            pst.setLong(8, content.getStaffId());
            pst.setLong(9,content.getAdvId());
            int result=pst.executeUpdate();
            System.out.println("content created");

            ResultSet resultSet = pst.getGeneratedKeys();
            if(resultSet.next()) {
                long  id = resultSet.getLong(1);
                content.setContentId(id);
                return content;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
            //System.err.println(e.getStackTrace());
        }finally{
            dbconnection.closeConnection(connection);
        }
    }

    @Override
    public List<Content> getContentByAdvertisementId(Long advId) {
        Connection connection = dbconnection.getConnection();
        List<Content> contents=new ArrayList<>();
        try {
            String mySqlQuery = "select * from content where adv_id=?";
            PreparedStatement pst = connection.prepareStatement(mySqlQuery);
            pst.setLong(1, advId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Content content=new Content();
                content.setContentName(rs.getString("content_name"));
                content.setContentFile(rs.getString("content_file"));
                Date createdDate = rs.getDate("created_date");
                content.setCreatedDate(createdDate.toLocalDate());
                content.setContentType(rs.getString("content_type"));
                content.setContentDuration(rs.getDouble("contentduration"));
                content.setInternalOrExternal(rs.getBoolean("isInternalOrExternal"));
                content.setCompanyId(rs.getLong("company_id"));
                content.setStaffId(rs.getLong("staff_id"));
                content.setAdvId(rs.getLong("advId"));
                contents.add(content);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Content getContentByContentName(String contentName) {
        try {
            Connection connection = dbconnection.getConnection();
            String mySqlQuery = "select * from content where content_name=?";
            PreparedStatement pst = connection.prepareStatement(mySqlQuery);
            pst.setString(1, contentName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("content_name");
                String contentFile = rs.getString("content_file");
                Date createdDate = rs.getDate("created_date");
                LocalDate createdDateLocalDate=createdDate.toLocalDate();
                String contentType = rs.getString("content_type");
                double contentDuration = rs.getDouble("contentduration");
                Boolean isInternalOrExternal = rs.getBoolean("isInternalOrExternal");
                Long companyId = rs.getLong("company_id");
                Long staffId = rs.getLong("staff_id");
                Long advId=rs.getLong("advId");
                return new Content(contentName, contentFile, createdDateLocalDate, contentType, contentDuration,
                        isInternalOrExternal, companyId, staffId,advId);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public List<ContentResponse> getContentByAdvertisementCompanyId(Long companyId) {
        Connection connection= dbconnection.getConnection();
        List<Content> contents=new ArrayList<>();

        try{
            String mysql="select * from content where company_id=?";
            PreparedStatement pst= connection.prepareStatement(mysql);
            pst.setLong(1,companyId);
            ResultSet resultSet=pst.executeQuery();
            while(resultSet.next()){
                Content content=new Content();
                content.setContentName(resultSet.getString("content_-name"));
                content.setContentFile(resultSet.getString("content_file"));
                Date createdDate=resultSet.getDate("created_date");
                content.setCreatedDate(createdDate.toLocalDate());
                content.setContentType(resultSet.getString("content_type"));
                content.setContentDuration(resultSet.getDouble("contentduration"));
                content.setInternalOrExternal(resultSet.getBoolean("isinternalorexternal"));
                content.setCompanyId(resultSet.getLong("company_id"));
                content.setStaffId(resultSet.getLong("staff_id"));
                content.setAdvId(resultSet.getLong("adv_id"));
                contents.add(content);

            }
        }catch(SQLException e){
         throw new RuntimeException();
        }finally{
            dbconnection.closeConnection(connection);
        }
        return null;
    }
}