package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.Users;

public class UserDAO extends BaseDao {

    public Users findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = :username";

        return getJdbi().withHandle(handle ->
                handle.createQuery(sql)
                        .bind("username", username)
                        .mapToBean(Users.class)
                        .findOne()
                        .orElse(null)
        );
    }


    public void insert(Users user) {
        String sql = """
            INSERT INTO users(name, username, password, birthday, role)
            VALUES (:name, :username, :password, :birthday, :role)
        """;

        getJdbi().withHandle(h ->
                h.createUpdate(sql)
                        .bindBean(user)
                        .execute()
        );
    }


}
