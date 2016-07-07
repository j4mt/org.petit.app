package petit.controller;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import petit.model.Person;

import java.nio.charset.Charset;

@Controller
public class PersonController{

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @RequestMapping("/login")
    public String login() {
        //Basic dXNlcm5hbWU6cGFzc3dvcmQ=
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = createHeaders("user","password");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity <Person> person = restTemplate.exchange("http://localhost:8080/persons/1", HttpMethod.GET, entity, Person.class);

        //Person person = restTemplate.getForObject("http://localhost:8080/persons/1", Person.class);

        log.info(person.toString());
        return person.toString();
    }

    HttpHeaders createHeaders( String username, String password ){
        return new HttpHeaders(){
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("US-ASCII")) );
                String authHeader = "Basic " + new String( encodedAuth );
                set( "Authorization", authHeader );
            }
        };
    }
}
