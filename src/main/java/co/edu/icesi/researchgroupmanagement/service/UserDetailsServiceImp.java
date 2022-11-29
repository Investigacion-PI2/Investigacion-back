package co.edu.icesi.researchgroupmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.icesi.researchgroupmanagement.model.User;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService  {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new UserDetailsImp(user);
    }
    
}
