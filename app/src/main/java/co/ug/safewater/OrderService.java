package co.ug.safewater;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OrderService {
    @GET("/orders")
    Call<List<OrderResponse>> getOrders();

    @GET("/orders/:id")
    Call<OrderResponse> getOrder();

    @POST("/orders")
    Call<OrderResponse> createOrder();
}
