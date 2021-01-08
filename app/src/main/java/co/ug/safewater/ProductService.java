package co.ug.safewater;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<List<ProductResponse>> getProducts();

    @GET("products/:id")
    Call<ProductResponse> getProduct();
}
