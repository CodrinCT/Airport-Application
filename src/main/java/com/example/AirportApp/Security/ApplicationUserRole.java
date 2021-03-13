package com.example.AirportApp.Security;

//import com.google.common.collect.Sets;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

//import java.util.Set;
//import java.util.stream.Collectors;
//
//import static com.example.AirportApp.Security.ApplicationUserPermissions.*;
//
//public enum ApplicationUserRole {
////    STUDENT(Sets.newHashSet()),
//    LOGGEDUSER(Sets.newHashSet(LOGGEDUSER_PERMISSION)),
//    ADMIN(Sets.newHashSet(ADMIN_PERMISSION));
//
//    private final Set<ApplicationUserPermissions> permissions;
//
//
//    ApplicationUserRole(Set<ApplicationUserPermissions> permissions) {
//        this.permissions = permissions;
//    }
//
//    public Set<ApplicationUserPermissions> getPermissions() {
//        return permissions;
//    }

//    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
//        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
//                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//                .collect(Collectors.toSet());
//        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
//        return permissions;
//    }
//}
