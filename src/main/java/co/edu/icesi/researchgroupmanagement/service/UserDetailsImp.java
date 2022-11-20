package co.edu.icesi.researchgroupmanagement.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.edu.icesi.researchgroupmanagement.model.User;
import co.edu.icesi.researchgroupmanagement.repository.UserTypeRepository;


public class UserDetailsImp implements UserDetails {

    private User user;

    @Autowired
    UserTypeRepository userTypeRepository;

    public UserDetailsImp(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("TYPE_" + role.getName())));
        authorities.add(new SimpleGrantedAuthority("TYPE_DEV"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return new BCryptPasswordEncoder().encode(user.getPassword());
    }
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
