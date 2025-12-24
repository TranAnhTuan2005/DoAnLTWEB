package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.dao.UserDAO;
import vn.edu.nlu.fit.model.Users;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public Users login(String username, String password) {
        Users user = userDAO.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
