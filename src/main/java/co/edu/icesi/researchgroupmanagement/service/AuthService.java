package co.edu.icesi.researchgroupmanagement.service;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class AuthService {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient();

    public String authenticate(String username, String password) throws IOException{
        String json = "{\n    \"username\":\"marcovasquez\",\n    \"password\":\"Marco12345\"\n}";
        Request request = new Request.Builder()
            .url("https://pi2sis.icesi.edu.co/saamfiapi/public/institutions/1/systems/4/users/login")
            .method("POST", RequestBody.create(json, JSON))
            .build();
        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new BadCredentialsException("");
            return response.body().string();
        }
    }

    public String validate(String username, String password, String authorization) throws IOException{
        String json = "{\n    \"username\":\"marcovasquez\",\n    \"password\":\"Marco12345\"\n}";
        Request request = new Request.Builder()
            .url("https://pi2sis.icesi.edu.co/saamfiapi/public/institutions/1/systems/4/users/validate-token")
            .header("Authorization", authorization)
            .method("POST", RequestBody.create(json, JSON))
            .build();
        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new BadCredentialsException("");
            return response.body().string();
        }
    }

    public String getRoles(String authorization) throws IOException {
        Request request = new Request.Builder()
            .url("https://pi2sis.icesi.edu.co/saamfiapi/internal/institutions/1/systems/4/users/41/roles/")
            .header("Authorization", authorization)
            .method("GET", RequestBody.create("", JSON))
            .build();
        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new BadCredentialsException("");
            return response.body().string();
        }
    }

}
