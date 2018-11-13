package com.joseluis0218.laboratoriocalificado_api_rest.services;

import com.joseluis0218.laboratoriocalificado_api_rest.models.Solicitud;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String API_BASE_URL = "http://laboratoriocalificado-android-joseluiscristobalerquinio.c9users.io";

    @GET("/api/solicitudes/")
    Call<List<Solicitud>> getSolicitudes();

    @FormUrlEncoded
    @POST("/api/solicitudes/")
    Call<Solicitud> createSolicitud(@Field("correo") String correo,
                                          @Field("tipo") String tipo,
                                          @Field("motivo") String motivo);
    @Multipart
    @POST("/api/solicitudes/")
    Call<Solicitud> createSolicitudWithImage(
            @Part("correo") RequestBody correo,
            @Part("tipo") RequestBody tipo,
            @Part("motivo") RequestBody motivo,
            @Part MultipartBody.Part voucher
    );

}