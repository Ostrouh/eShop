package org.ostroukh.model.service.impl;

import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User userDetails = null;

        User user = userService.getUserByLogin(login);

        if (user != null){
            Set<GrantedAuthority> roles = new HashSet<>();
            roles.add(new SimpleGrantedAuthority(user.getCredential().getRole().name()));

            userDetails = new org.springframework.security.core.userdetails
                    .User(  user.getCredential().getLogin(),
                            user.getCredential().getPassword(),
                            roles);
        }
        return userDetails;
    }
}
