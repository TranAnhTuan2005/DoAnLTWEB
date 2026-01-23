package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.dao.UserDAO;
import vn.edu.nlu.fit.model.Users;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    private static final String email_regrex =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; //nhập đúng định dajg email

    private static final String password_regrex =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$"; //có chử cái, số, kí tự đặc biệt, từ 8 kí tự trở lên

    //login
    public Users login(String email, String password) {
        Users user = userDAO.findByEmail(email);

        if (user == null) {
            return null;
        }
        String hashPass = HashMD5.md5(password);
        // sai mật khẩu
        if (!user.getPassword_hash().equals(hashPass)) {
            return null;
        }
        // tài khoản bị khóa
        if (!user.isActive()) {
            throw new IllegalArgumentException("Tài khoản đã bị khóa");
        }
        return user; // OK
    }

    //đk tk
    public boolean register(String fullName, String email, String phoneNumber, String password, String birthday) {

        // check trống
        if (fullName == null || fullName.isEmpty() || email == null || email.isEmpty() || phoneNumber == null  || phoneNumber.isEmpty()
                || password == null || password.isEmpty()  || birthday == null || birthday.isEmpty()) {

            throw new IllegalArgumentException("Vui lòng nhập đầy đủ thông tin");
        }

        // check email / phone

        boolean isEmail = email.matches(email_regrex);
        boolean isPassword = password.matches(password_regrex);

        //check email
        if (!isEmail) {
            throw new IllegalArgumentException("Email không đúng định dạng");
        }

        // check password mạnh
        if (!isPassword) {
            throw new IllegalArgumentException("Mật khẩu phải ≥ 8 ký tự, gồm chữ, số và ký tự đặc biệt");
        }

        // check trùng email
        if (userDAO.findByEmail(email) != null) {
            throw new IllegalArgumentException("Tài khoản đã tồn tại");
        }
        Users user = new Users();
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        String hashPass = HashMD5.md5(password);
        user.setPassword_hash(hashPass);

        LocalDate birthDate = LocalDate.parse(birthday);
        user.setBirthday(birthDate);

        user.setUserRole("user");
        user.setActive(true);
        userDAO.insert(user);
        return true;
    }


    public void sendResetPasswordEmail(String email, String contextPath) {
        Users user = userDAO.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("Email không tồn tại");
        }
        String token = UUID.randomUUID().toString();
        LocalDateTime expired = LocalDateTime.now().plusMinutes(15);
        userDAO.saveResetToken(email, token, expired);
        String resetLink = contextPath + "/ResetPassword?token=" + token;
        EmailUtil.sendResetEmail(email, resetLink);
    }

    public Users findByResetToken(String token) {
        return userDAO.findByResetToken(token);
    }

    public List<Users> findAll() {
        return userDAO.findAll();
    }
    public void updateUser(int id, String fullName, String phone, boolean active) {
        userDAO.updateUser(id, fullName, phone, active);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public void createByAdmin(Users user) {
        // check email trùng
        if (userDAO.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email đã tồn tại");
        }
        userDAO.insertByAdmin(user);
    }


    public void resetPasswordByToken(String token, String newPassword) {
        // check token
        Users user = userDAO.findByResetToken(token);
        if (user == null) {
            throw new IllegalArgumentException("Token không hợp lệ hoặc đã hết hạn");
        }

        // check mật khẩu trống
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("Vui lòng nhập mật khẩu mới");
        }

        // check mật khẩu mạnh
        if (!newPassword.matches(password_regrex)) {
            throw new IllegalArgumentException(
                    "Mật khẩu phải ≥ 8 ký tự, gồm chữ, số và ký tự đặc biệt"
            );
        }

        // hash mật khẩu
        String hashedPassword = HashMD5.md5(newPassword);

        // cập nhật mật khẩu
        userDAO.updatePasswordByToken(token, hashedPassword);
        // xoá token sau khi dùng
        userDAO.clearResetToken(token);
    }



}
