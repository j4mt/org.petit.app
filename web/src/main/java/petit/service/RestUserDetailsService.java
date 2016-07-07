package petit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import petit.model.Person;

import java.util.Collections;

/**
 * Created by Jerry.
 */

@Service
public class RestUserDetailsService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person =
                restTemplate.getForObject(
                        "http://localhost:8081/persons/search/findByUsername?username={username}",
                        Person.class,
                        username
                );

        if (person == null)
            throw new UsernameNotFoundException(username);

        return new User(
                person.getUsername(),
                person.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
