package com.example.AirportApp.Services;

//import com.example.AirportApp.Dao.AppUserDao;
//import com.example.AirportApp.Dao.RegistrationDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

//@Service
//public class AppUserService implements UserDetailsService {
////    private final AppUserDao appUserDao;
//    private final RegistrationDao registrationDao;
//
//    @Autowired
//    public AppUserService(RegistrationDao registrationDao) {
//        this.registrationDao = registrationDao;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        return registrationDao.selectAppUserBynName(userName).orElseThrow(()->new UsernameNotFoundException(String.format("Username %s not found", userName)));
//    }
//}
