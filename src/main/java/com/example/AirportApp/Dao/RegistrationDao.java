package com.example.AirportApp.Dao;

import com.example.AirportApp.Models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
@Repository
public class RegistrationDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void enable(String verificationCode) {
        jdbcTemplate.update("UPDATE users SET enabled = 1 WHERE verification_code = ?", verificationCode);
    }

    public UserModel getUserByRegistrationCode(String verificationCode){
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE verification_code = ?",this::getUser, verificationCode);
    }

//    public String isEnabled(String verificationCode){
//        return jdbcTemplate.queryForObject("SELECT enabled FROM users WHERE verification_code = ?", this::getEnabled, verificationCode);
//    }

    public Boolean checkIsEnabledByName(String name){
        return jdbcTemplate.queryForObject("SELECT enabled FROM users WHERE name = ?", this::getEnabled, name);
    }
    public void registerUser(UserModel userModel) {
        String name = userModel.getUserName();
        String email = userModel.getEmail();
        String password = userModel.getPassword();
        String verificationCode = userModel.getVerificationCode();
        jdbcTemplate.update("INSERT INTO users(name, email, password, verification_code) VALUES (?,?,?,?)", name, email, password, verificationCode);
    }
    public boolean getEnabled(ResultSet resultSet, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setConfirmed(resultSet.getBoolean("enabled"));
        boolean enabled = userModel.getConfirmed();
        return enabled;
    }
    public UserModel getUser(ResultSet resultSet, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        userModel.setId(resultSet.getInt("id"));
        userModel.setUserName(resultSet.getString("name"));
        userModel.setEmail(resultSet.getString("email"));
        userModel.setPassword(resultSet.getString("password"));
        userModel.setVerificationCode(resultSet.getString("verification_code"));
        userModel.setVerificationCode(resultSet.getString("enabled"));
        return userModel;

    }
    public String getEmail(ResultSet resultSet, int rowNum) throws SQLException {
        UserModel userModel = new UserModel();
        String email;
        userModel.setEmail(resultSet.getString("email"));
        email = userModel.getEmail();
        return email;
    }
    public String getName( ResultSet resultSet, int rowNum)throws SQLException {
            UserModel userModel = new UserModel();
            String name;
            userModel.setUserName(resultSet.getString("name"));
            name = userModel.getUserName();
            return name;
    }
    public List<String> getUserEmail() {
            return jdbcTemplate.query("select email from users", this::getEmail);
    }
    public List<String> getUserName(){
        return jdbcTemplate.query("SELECT name from users", this::getName);
    }
}
