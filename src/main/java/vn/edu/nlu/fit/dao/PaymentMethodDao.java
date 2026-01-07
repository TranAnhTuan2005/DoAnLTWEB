package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.PaymentMethods;
import java.util.List;
public class PaymentMethodDao extends BaseDao{
    String sql = "Select * From paymentmethods Where is_actived = 1";

    public List<PaymentMethods> getAllPaymentMethods(){
        return getJdbi().withHandle(handle ->
                handle.createQuery(sql)).mapToBean(PaymentMethods.class).list();
    }
}