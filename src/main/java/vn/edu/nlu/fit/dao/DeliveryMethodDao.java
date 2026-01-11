package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.DeliveryMethods;

import java.util.List;

public class DeliveryMethodDao extends BaseDao{
    String sql = "SELECT id, method_name as methodName, is_actived as isActived, price " +
            "FROM deliverymethods WHERE is_actived = 1";

    public List<DeliveryMethods> getAllDeliveryMethods(){
        return getJdbi().withHandle(handle ->
                handle.createQuery(sql).mapToBean(DeliveryMethods.class).list());
    }
}
