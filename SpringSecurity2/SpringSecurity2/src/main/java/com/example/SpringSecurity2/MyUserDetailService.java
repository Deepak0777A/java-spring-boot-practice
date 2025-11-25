package com.example.SpringSecurity2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private MyUserRepo userrepo;

    @Autowired
    public MyUserDetailService(MyUserRepo userrepo){
        this.userrepo=userrepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MYUser> user = userrepo.findByUsername(username);
        if(user.isPresent()){
            var UserObj = user.get();
            return User.builder()
                    .username(UserObj.getUsername())
                    .password(UserObj.getPassword())
                    .roles(UserObj.getRole())
                    .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }
}
