package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.News;

import java.util.List;

public class NewsDAO extends BaseDao{

        public int getTotalNews() {
            return getJdbi().withHandle(handle ->
                    handle.createQuery("SELECT COUNT(*) FROM news WHERE is_published = 1")
                            .mapTo(Integer.class)
                            .one()
            );
        }
        public List<News> getNewsByPage(int offset, int limit) {
            String sql = "SELECT id, title, content, short_description as shortDescription, image_url as imageURL," +
                    "user_id as userID, date_post as datePost, is_published as isPublished " +
                    "FROM news WHERE is_published = 1 ORDER BY date_post DESC LIMIT :limit OFFSET :offset";

            return getJdbi().withHandle(handle ->
                    handle.createQuery(sql)
                            .bind("limit", limit)// số lượng
                            .bind("offset", offset)// vị trí lấy
                            .mapToBean(News.class)
                            .list()
            );
        }
        public List<News> getRecentNews(int limit) {
            String sql = "SELECT  id, title, content, short_description as shortDescription, image_url as imageURL," +
                    "user_id as userID, date_post as datePost, is_published as isPublished " +
                    "FROM news WHERE is_published = 1 ORDER BY date_post DESC LIMIT :limit";

            return getJdbi().withHandle(handle ->
                    handle.createQuery(sql)
                            .bind("limit", limit)
                            .mapToBean(News.class)
                            .list()
            );
        }
}
