package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.dao.UserDAO;
import vn.edu.nlu.fit.model.Users;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    private static final String email_regrex =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"; //nhập đúng định dajg email

    private static final String phone_regrex =
            "^(0|\\+84)(3|5|7|8|9)[0-9]{8}$";//nhập đúng định dạng phone vn

    private static final String password_regrex =
            "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$"; //có chử cái, số, kí tự đặc biệt, từ 8 kí tự trở lên

    public Users login(String username, String password) {
        Users user = userDAO.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


    public boolean register(String name, String username,
                            String password, String birthday) {

        // check trống
        if (name == null || username == null || password == null || birthday == null ||
                name.isEmpty() || username.isEmpty() || password.isEmpty() || birthday.isEmpty()) {
            throw new IllegalArgumentException("Vui lòng nhập đầy đủ thông tin");
        }

        // check email / phone format
        boolean isEmail = username.matches(email_regrex);
        boolean isPhone = username.matches(phone_regrex);
        boolean isPassword = password.matches(password_regrex);

        if (!isEmail && !isPhone) {
            throw new IllegalArgumentException(
                    "Email hoặc số điện thoại không đúng định dạng");
        }
        // check password mạnh
        if (!isPassword) {
            throw new IllegalArgumentException(
                    "Mật khẩu phải ≥ 8 ký tự, gồm chữ, số và ký tự đặc biệt");
        }

        // check trùng
        if (userDAO.findByUsername(username) != null) {
            throw new IllegalArgumentException("Tài khoản đã tồn tại");
        }

        Users user = new Users();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password); // hash sau
        user.setBirthday(birthday);
        user.setRole("user");

        userDAO.insert(user);
        return true;
    }

}
