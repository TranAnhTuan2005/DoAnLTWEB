package vn.edu.nlu.fit.dao;

import org.jdbi.v3.core.Jdbi;
import vn.edu.nlu.fit.model.PaymentMethods;
import java.util.List;
public class PaymentMethodDao {

    public List<PaymentMethods> getAllPaymentMethods() {
        String host = DBProperties.getDbHost();
        String port = DBProperties.getDbPort();
        String dbName = DBProperties.getDbName();
        String username = DBProperties.getUsername();
        String password = DBProperties.getPassword();

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName +
                "?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true";

        //Phải nạp driver thủ công do ko xài basedao
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Chưa nạp driver", e);
        }

        Jdbi jdbi = Jdbi.create(url, username, password);
    String sql = "SELECT id, method_name as methodName, is_actived as isActived, iconURL as iconUrl FROM paymentmethods WHERE is_actived = 1";

        return jdbi.withHandle(handle ->
                handle.createQuery(sql).mapToBean(PaymentMethods.class).list());
    }
}