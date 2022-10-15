package co.edu.icesi.researchgroupmanagement.config.util;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws BadCredentialsException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        try {
            login();
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } catch (IOException | BadCredentialsException e) {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public String login() throws IOException, BadCredentialsException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/json");
        String json = "{\n    \"username\":\"11001100\",\n    \"password\":\"15394725772654685941\"\n}";
        Request request = new Request.Builder()
            .url("https://pi2sis.icesi.edu.co/saamfiapi/public/institutions/1/systems/4/users/login")
            .method("POST", RequestBody.create(json, mediaType))
            .build();
        Response response = client.newCall(request).execute();
        
        if(response.code() != 200) throw new BadCredentialsException("");

        String body = response.body().string();

        response.close();

        return body;
    }

    public String authorities() {
        return null;
    }

}
