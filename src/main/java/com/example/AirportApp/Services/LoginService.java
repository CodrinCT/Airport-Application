package com.example.AirportApp.Services;

import com.example.AirportApp.Dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class  LoginService {

    @Autowired
    LoginDao loginDao;

    public List<String> getEmailWithPassword(@RequestParam String password) throws EmptyResultDataAccessException{
       return loginDao.getEmailByPassword(password);
    }

    public String getEmailWithName(@RequestParam String nameSearch) throws EmptyResultDataAccessException {
        return loginDao.getEmailByName(nameSearch);
    }

    public Boolean isAdmin(String userEmail){
        if (loginDao.getRole(userEmail).equals("ADMIN")){
            return true;
        }else {
            return false;
        }
    }

}
