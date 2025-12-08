package vn.edu.nlu.fit.dao;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.PreparedBatch;
import vn.edu.nlu.fit.model.products;

import java.util.*;

public class ProductDAO extends BaseDao {

    static Map<Integer, products> data=new HashMap<>();
    static {
        data.put(1,new products(1,"Ngũ cốc trẻ em","https://product.hstatic.net/200000759239/product/ngu-coc-tre-nho_320dab6096c64f23bae168a127a4588b_large.png",239000));
        data.put(2,new products(2,"Trà thảo mộc","https://product.hstatic.net/200000759239/product/tra-thao-moc-giam-can_603294f3e23f4f9696f08cf7c6cda41e_large.png",159000));
        data.put(3,new products(3,"Ngũ cốc dinh dưỡng 15 gói","https://product.hstatic.net/200000759239/product/ngu-coc-dinh-duong_bfa275ed0cbb4b1caeec09efe2fcb2a7_large.jpg",159000));
        data.put(4,new products(4,"Ngũ cốc dinh dưỡng 10 gói","https://product.hstatic.net/200000759239/product/z5831341333981_f8449aeba6b160b8202e9c547900041d_af7a08271afe4f808599e50b9bcba681_large.jpg",119000));
        data.put(5,new products(5,"Bánh hạt dinh dưỡng 30 x 15g","https://product.hstatic.net/200000759239/product/z5733205375570_382dce53f12e857ba679d359031a8b2b_208a756b7cfd427fbf1e37439de6fb6f_large.jpg",219000));
        data.put(6,new products(6,"Combo set hạt nấu sữa 14 gói 100g","https://product.hstatic.net/200000759239/product/z5610770742745_fb96c0a1c46a38938e1a29ba3d9a7751_5b490c57eac848b7a27f1b2234a306b6_large.jpg",329000));
        data.put(7,new products(7,"Combo set hạt nấu sữa 14 gói 50g","https://product.hstatic.net/200000759239/product/z5610770742745_fb96c0a1c46a38938e1a29ba3d9a7751_76223b654e50455fa4a355efee865cba_large.jpg",189000));
        data.put(8,new products(8,"Hạt điều sấy  tự nhiên","https://product.hstatic.net/200000759239/product/z5024920861043_c6ec814deef7972b83a7e0c4b6617aab_a3a880ba7a854598bd266738f7110e44_large.jpg",195000));
        data.put(9,new products(9,"Bánh hạt dinh dưỡng 20 x 15g","https://product.hstatic.net/200000759239/product/z5733208118868_400f3de27c0a3a471b310c41c9c695b4_1b906bffe8d848228ab5709187e4dad9_large.jpg",159000));
        data.put(10,new products(10,"Hạt bí xanh","https://product.hstatic.net/200000759239/product/z5024920830134_500542a7ef7c6fec7bcada66a70df292_d2bd9d0ae3564b3db91b693a54342b8e_large.jpg",135000));
        data.put(11,new products(11,"Hạnh nhân tách vỏ","https://product.hstatic.net/200000759239/product/z5024920824262_db75f0f942ce7eb569f9e2b0474ea945_a3d5c64cf7054f2588ffe223279d13e9_large.jpg",195000));
        data.put(12,new products(12,"Mix trái cây","https://product.hstatic.net/200000759239/product/z5024920866513_fc749972b1b4d68ac76bb637e5ba3b43_c56bf7e521c54dcb99ec927234a48310_large.jpg",179000));
        data.put(13,new products(13,"Granola","https://product.hstatic.net/200000759239/product/z5024920817208_1b15f6204d73dc6827df97a62a1ce296_e12b86fa56074791ba6ad69238d63df4_large.jpg",179000));

    }




    //lay du lieu ra
    public List<products> getListProduct() {
        return new ArrayList<>(data.values());
    }
    public products getProduct(int id) {
        return data.get(id);
    }

    public void insertProduct(List<products> products) {
        Jdbi jdbi= getJdbi();
       // jdbi.useHandle() -> không trả về kết quả -> dùng khi câu sql insert, update, delete
       // jdbi.withHandle() -> dùng khi câu sql là select

        //viết theo lamda function
        jdbi.useHandle(handle -> {
            //dùng hàm prepareBatch() khi muốn insert nhiều dòng
            //dùng hàm createUpdate() khi muốn insert một dòng
            PreparedBatch preparedBatch = handle.prepareBatch("insert into products values(:id,:name,:img,:price)");

            products.forEach(product -> {
                preparedBatch.bindBean(product).add();
            });
            preparedBatch.execute();
        });
    }

    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        List<products> products = productDAO.getListProduct();
        productDAO.insertProduct(products);
    }
}
