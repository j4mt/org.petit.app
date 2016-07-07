package petit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by j4mt on 14/06/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private Long id;

    private String username;

    private String password;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//
//
//    @Override
//    public String toString() {
//
//        return String.format("Person{username='%s', password='%s'}", username, password);
//    }
}
