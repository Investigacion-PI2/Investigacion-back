package co.edu.icesi.researchgroupmanagement.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.edu.icesi.researchgroupmanagement.model.Users;
import co.edu.icesi.researchgroupmanagement.repository.UserTypeRepository;


public class CustomUserDetails implements UserDetails {

    private Users user;
    private UserTypeRepository userTypeRepository;

    public CustomUserDetails(Users user, UserTypeRepository userTypeRepository) {
        this.user = user;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        //roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("TYPE_" + role.getName())));
        authorities.add(new SimpleGrantedAuthority("TYPE_" + userTypeRepository.findById(user.getUserTypes().getId())));
        return authorities;
    }

    @Override
    public String getPassword() {
        return new BCryptPasswordEncoder(6).encode(user.getPassword());
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
