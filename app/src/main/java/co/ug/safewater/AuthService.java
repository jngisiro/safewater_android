package co.ug.safewater;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("users/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("user/signup")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
}
