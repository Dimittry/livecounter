package com.livecounter.security;

import com.livecounter.persistence.dao.UserRepo;
import com.livecounter.persistence.model.Privilege;
import com.livecounter.persistence.model.Role;
import com.livecounter.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")
@Transactional
public class CustomCounterUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword().toLowerCase(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(user.getRoles())
        );
    }
    public final Collection<? extends GrantedAuthority> getAuthorities(final Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<String> getPrivileges(final Collection<Role> roles) {
        final List<String> privileges = new ArrayList<>();
        final List<Privilege> collection = new ArrayList<>();

        for(Role role : roles) {
            collection.addAll(role.getPrivileges());
        }

        privileges.addAll(collection.stream().map(Privilege::getName).collect(Collectors.toList()));
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final List<String> privileges) {
        return privileges.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

}
