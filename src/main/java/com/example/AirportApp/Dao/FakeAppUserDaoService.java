package com.example.AirportApp.Dao;

//import com.example.AirportApp.Models.AppUser;
//import com.google.common.collect.Lists;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.example.AirportApp.Security.ApplicationUserRole.ADMIN;
//import static com.example.AirportApp.Security.ApplicationUserRole.LOGGEDUSER;
//
//@Repository("fake")
//public class FakeAppUserDaoService implements AppUserDao{
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public FakeAppUserDaoService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Optional<AppUser> selectAppUserBynName(String userName) {
//        return getAppUsers()
//                .stream()
//                .filter(appUser -> userName.equals(appUser.getUsername()))
//                .findFirst();
//    }
//
//    private List<AppUser> getAppUsers(){
//        List<AppUser> appUsers = Lists.newArrayList(
//                new AppUser(
//                        "Ana Smith",
//                        passwordEncoder.encode("password"),
//                        LOGGEDUSER.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new AppUser(
//                        "Linda",
//                        passwordEncoder.encode("password"),
//                        ADMIN.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new AppUser(
//                        "Tom",
//                        passwordEncoder.encode("password"),
//                        LOGGEDUSER.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                )
//        );
//
//        return appUsers;
//    }
//}
