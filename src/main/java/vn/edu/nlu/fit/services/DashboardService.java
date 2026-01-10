package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.controller.admin.ChartData;
import vn.edu.nlu.fit.dao.DashboardDAO;

import java.util.List;

public class DashboardService {
    DashboardDAO dao = new DashboardDAO();

    public int getCount(String tableName) {
        return dao.getCount(tableName);
    }

    public List<ChartData> getRevenueList() {
        return dao.getRevenueLast7Days();
    }

    // Hàm tạo chuỗi ngày tháng từ database
    public String getLabels(List<ChartData> list) {
        String result = "[";

        for (int i = 0; i < list.size(); i++) {
            result += "'" + list.get(i).date + "'";
            if (i < list.size() - 1) {
                result += ",";
            }
        }

        result += "]";
        return result;
    }

    // Hàm tạo chuỗi tiền
    public String getData(List<ChartData> list) {
        String result = "[";

        for (int i = 0; i < list.size(); i++) {
            result += list.get(i).revenue;
            if (i < list.size() - 1) {
                result += ",";
            }
        }

        result += "]";
        return result;
    }
}
