package com.acro.ad.repository;
import com.acro.ad.dbconnection.DbConnection;
import com.acro.ad.dto.AdvertisementResponse;
import com.acro.ad.model.AdView;
import com.acro.ad.model.Advertisement;
import com.acro.ad.model.Content;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdvertisementRepositoryImpl implements IAdvertisementRepository {
    DbConnection dbConnection = new DbConnection();

    public Advertisement createAdvertisement(Advertisement advertisement) {
        //Long advId = null;
        Connection connection = dbConnection.getConnection();
        try {

            String mysqlInsert = "Insert into advertisement" +
                    "(adv_name,company_id,published-date)" +
                    "values(?,?,?,)";
            PreparedStatement pst = connection.prepareStatement(mysqlInsert, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, advertisement.getAdvName());
            pst.setLong(2, advertisement.getCompanyId());
            pst.setDate(3, Date.valueOf(advertisement.getPublishedDate()));
            int res = pst.executeUpdate();
            System.out.println("Advertisement created");

            ResultSet resultSet = pst.getGeneratedKeys();
            if (resultSet.next()) {
                Long id = resultSet.getLong(1);
                advertisement.setAdvId(id);
                return advertisement;
            }

        } catch (SQLException e) {
            System.err.println(e.getStackTrace());
        } finally {
            dbConnection.closeConnection(connection);
        }
        return null;

    }


    public Advertisement getAdvertisementById(Long advId) {
        Connection connection = dbConnection.getConnection();

        try {
            String mySql = "select * from advertisement where adv_id =?";
            PreparedStatement pst = connection.prepareStatement(mySql);
            pst.setLong(1, advId);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Advertisement advertisement = new Advertisement();
                advertisement.setAdvId(resultSet.getLong("adv_id"));
                advertisement.setAdvName(resultSet.getString("adv_name"));
                advertisement.setCompanyId(resultSet.getLong("company_id"));
                Date publishedDate = resultSet.getDate("publishedDate");
                advertisement.setPublishedDate(publishedDate.toLocalDate());
                return advertisement;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbConnection.closeConnection(connection);
        }
        return null;
    }


    public List<Content> getContentByAdvertisementId(Long advId) {
        Connection connection = dbConnection.getConnection();
        List<Content> contents = new ArrayList<>();
        try {
            String mySql = "select * from content where adv_id=?";
            PreparedStatement pst = connection.prepareStatement(mySql);
            pst.setLong(1, advId);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Content content = new Content();
                content.setContentId(resultSet.getLong("content_id"));
                content.setContentName(resultSet.getString("content_name"));
                content.setContentFile(resultSet.getString("content_file"));
                Date createdDate = (resultSet.getDate("created_date"));
                content.setCreatedDate(createdDate.toLocalDate());
                content.setContentDuration(resultSet.getDouble("content_duration"));
                content.setInternalOrExternal(resultSet.getBoolean("isinternal"));
                content.setCompanyId(resultSet.getLong("company_id"));
                content.setStaffId(resultSet.getLong("staff_id"));
                content.setAdvId(resultSet.getLong("adv_id"));
                contents.add(content);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            dbConnection.closeConnection(connection);
        }
        return contents;

    }


    public List<Content> getContentByAdvertisementCompanyId(Long companyId) {
        Connection connection = dbConnection.getConnection();
        List<Content> contents = new ArrayList<>();
        try {
            String mysql = "select * from content where company_id=?";
            PreparedStatement pst = connection.prepareStatement(mysql);
            pst.setLong(1, companyId);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Content content = new Content();
                content.setContentId(resultSet.getLong("content_id"));
                content.setContentName(resultSet.getString("content_name"));
                content.setContentFile(resultSet.getString("content_file"));
                Date createdDate = (resultSet.getDate("created_date"));
                content.setCreatedDate(createdDate.toLocalDate());
                content.setContentDuration(resultSet.getDouble("content_duration"));
                content.setInternalOrExternal(resultSet.getBoolean("isinternal"));
                content.setCompanyId(resultSet.getLong("company_id"));
                content.setStaffId(resultSet.getLong("staff_id"));
                content.setAdvId(resultSet.getLong("adv_id"));
                contents.add(content);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbConnection.closeConnection(connection);
        }
        return contents;

    }

    @Override
    public Advertisement getAdvertisementByCompanyId(Long companyId) {
        Connection connection = dbConnection.getConnection();
        {

            try {
                String mySql = "select * from advertisement where company_id =? ";
                PreparedStatement pst = connection.prepareStatement(mySql);
                pst.setLong(1, companyId);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    Advertisement advertisement = new Advertisement();
                    advertisement.setAdvId(resultSet.getLong("adv_id"));
                    advertisement.setAdvName(resultSet.getString("adv_name"));
                    advertisement.setCompanyId(resultSet.getLong("company_id"));
                    Date publishedDate = resultSet.getDate("publishedDate");
                    advertisement.setPublishedDate(publishedDate.toLocalDate());
                    return advertisement;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                dbConnection.closeConnection(connection);
            }
            return null;
        }

    }

    @Override
    public AdView getPopularAdvertisementByRegion(int regionId) {
        Connection connection = dbConnection.getConnection();
        {
            try {
                String mySql = "select top  10 * from adv_view where region_id=?";
                PreparedStatement pst = connection.prepareStatement(mySql);
                pst.setInt(1, regionId);
                ResultSet resultSet = pst.executeQuery();
                while (resultSet.next()) {
                    AdView adView = new AdView();
                    adView.setAdvId(resultSet.getLong("adv_id"));
                    adView.setPlatformId(resultSet.getLong("platform_id"));
                    adView.setRegionId(resultSet.getInt("region_id"));
                    adView.setCountryId(resultSet.getInt("country_id"));

                    Date adViewDate = resultSet.getDate("ad_viewdate");
                    adView.setAdViewDate(adViewDate.toLocalDate());

                    Time viewDuration = resultSet.getTime("view_duration");
                    adView.setViewDuration(viewDuration.toLocalTime());

                    return adView;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                dbConnection.closeConnection(connection);
            }
            return null;
        }
    }
}