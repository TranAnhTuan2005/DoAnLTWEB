package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.Users;

import java.time.LocalDateTime;

public class UserDAO extends BaseDao {

    //    public Users findByUsername(String username) {
//        String sql = "SELECT * FROM users WHERE username = :username";
//
//        return getJdbi().withHandle(handle ->
//                handle.createQuery(sql)
//                        .bind("username", username)
//                        .mapToBean(Users.class)
//                        .findOne()
//                        .orElse(null)
//        );
//    } 


    public void insert(Users user) {
        String sql = """
                    INSERT INTO users(full_name, email, phone_number, password_hash, birthday, user_role)
                    VALUES (:fullName, :email, :phoneNumber, :password_hash, :birthday, :userRole)
                """;

        getJdbi().withHandle(h ->
                h.createUpdate(sql)
                        .bindBean(user)
                        .execute()
        );
    }


    public Users findByEmail(String email) {
        String sql = """
                SELECT *
                FROM users
                WHERE email = :email""";
        return getJdbi().withHandle(h -> h.createQuery(sql)
                .bind("email", email)
                .mapToBean(Users.class)
                .findOne()
                .orElse(null));
    }


    public void saveResetToken(String email, String token, LocalDateTime expired) {
        String sql = """
                UPDATE users
                SET reset_token = :token, reset_expired = :expired
                WHERE email = :email""";

        getJdbi().withHandle(h -> h.createUpdate(sql)
                .bind("token", token)
                .bind("expired", expired)
                .bind("email", email)
                .execute());
    }

    public Users findByResetToken(String token) {
        String sql = """
                SELECT *
                FROM users
                WHERE reset_token = :token AND reset_expired > NOW()""";
        return getJdbi().withHandle(h -> h.createQuery(sql)
                .bind("token", token)
                .mapToBean(Users.class)
                .findOne()
                .orElse(null)
        );
    }

    public void updatePasswordByToken(String token, String passwordHash) {
        String sql = """
                UPDATE users
                SET password_hash = :password
                WHERE reset_token = :token""";
        getJdbi().withHandle(h -> h.createUpdate(sql)
                .bind("password", passwordHash)
                .bind("token", token)
                .execute()
        );
    }

    public void clearResetToken(String token) {
        String sql = """
                UPDATE users
                SET reset_token = NULL, reset_expired = NULL
                WHERE reset_token = :token""";
        getJdbi().withHandle(h -> h.createUpdate(sql)
                .bind("token", token)
                .execute()
        );
    }

}
