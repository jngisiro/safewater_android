package co.ug.safewater;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    public static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://waf-app.herokuapp.com/api/v1/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static AuthService getService(){
        AuthService authService = getRetrofit().create(AuthService.class);
        return authService;
    }

    public static ProductService getProductService(){
        ProductService productService = getRetrofit().create(ProductService.class);
        return productService;
    }

    public static OrderService getOrderService(){
        OrderService orderService = getRetrofit().create(OrderService.class);
        return orderService;
    }
}
