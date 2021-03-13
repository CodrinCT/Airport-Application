package com.example.AirportApp.Dao;

import com.example.AirportApp.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LoginDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getEmail(ResultSet resultSet, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        String email;
        userModel.setEmail(resultSet.getString("email"));
        email = userModel.getEmail();
        return email;
    }

    public String getUserRole(ResultSet resultSet, int rowNum) throws SQLException {
        UserModel user = new UserModel();
        user.setRole(resultSet.getString("role"));
        return user.getRole();

    }

    public long getId(ResultSet resultSet, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        long id;
        userModel.setId(resultSet.getInt("id"));
        id = userModel.getId();
        return id;
    }

    public List<String> getEmailByPassword(String password)throws EmptyResultDataAccessException{
        return jdbcTemplate.query("SELECT email FROM users WHERE password = ?", this::getEmail,password);
    }


    public String getEmailByName(String nameSearch) throws EmptyResultDataAccessException {
        return jdbcTemplate.queryForObject("SELECT email FROM users WHERE name = ?",this::getEmail,nameSearch);
    }

    public String getRole(String userEmail){
        return jdbcTemplate.queryForObject("SELECT role from users where email=?",this::getUserRole, userEmail);
    }

}
