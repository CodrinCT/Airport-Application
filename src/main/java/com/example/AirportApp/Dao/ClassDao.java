package com.example.AirportApp.Dao;

import com.example.AirportApp.Models.ClassModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClassDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private ClassModel getPlaneClass(ResultSet resultSet, int rowNum) throws SQLException {
        ClassModel classModel = new ClassModel();
        classModel.setClassTicketPrice(resultSet.getString("price"));
        classModel.setClassName(resultSet.getString("name"));
        return classModel;
    }

    public List<ClassModel> getPlaneClassAndPrice(){
        return jdbcTemplate.query("SELECT * FROM class",this::getPlaneClass);
    }

    public ClassModel getPlaneClassAndPriceById(int flightId){
        return jdbcTemplate.queryForObject("SELECT * FROM class WHERE class_id = ?", this::getPlaneClass, flightId);
    }

    private String getPrice(ResultSet resultSet, int rowNum) throws SQLException {
        ClassModel classModel = new ClassModel();
         classModel.setClassTicketPrice(resultSet.getString("price"));
        return classModel.getClassTicketPrice();
    }
    public String getPriceByName(String className) {
        return jdbcTemplate.queryForObject("SELECT price FROM class WHERE name = ?",this::getPrice,className);
    }
    public String getPriceById(int id){
        return jdbcTemplate.queryForObject("SELECT price WHERE class_id = ?",this::getPrice,id);
    }

}
