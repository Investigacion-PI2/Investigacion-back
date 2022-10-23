package co.edu.icesi.researchgroupmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import co.edu.icesi.researchgroupmanagement.model.Users;
import co.edu.icesi.researchgroupmanagement.repository.UserRepository;
import co.edu.icesi.researchgroupmanagement.repository.UserTypeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService  {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new CustomUserDetails(user, userTypeRepository);
    }
    
}
