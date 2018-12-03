package com.oazofeifa.tcudrake.SpringConfig.Security;

import com.oazofeifa.tcudrake.Persistence.Entities.User;
import com.oazofeifa.tcudrake.Services.RolesService;
import com.oazofeifa.tcudrake.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findById(s);
        GrantedAuthority authority = new SimpleGrantedAuthority(rolesService.findById(user.getRoleFk()).getRole());
        return (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail() +"," + user.getName() + " " + user.getLastname(),user.getPassword(), Arrays.asList(authority));
    }
}
