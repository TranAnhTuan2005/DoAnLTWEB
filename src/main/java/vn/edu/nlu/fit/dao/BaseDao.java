package vn.edu.nlu.fit.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;

public abstract class BaseDao {


    private Jdbi jdbi;

    protected Jdbi getJdbi(){
        if(jdbi==null){
            makeConnect();
        }
        return jdbi;
    }

    private void makeConnect() {

        String url= "jdbc:mysql://"+DBProperties.host()+":"+DBProperties.port()+"/"+DBProperties.dbname()+"?"+DBProperties.option();

        MysqlDataSource src= new MysqlDataSource();
        src.setURL(url);
        src.setUser(DBProperties.username());
        src.setPassword(DBProperties.password());
        try{
            src.setUseCompression(true);//nen du lieu tu mysql gui len
            src.setAutoReconnect(true);//tu dong ket noi lai khi bi ngat ket noi voi mySQL

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        jdbi=Jdbi.create(src);
    }



}
