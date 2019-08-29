package com.cedisropa.pruebaarquitecturabrandon2.api;

import com.cedisropa.pruebaarquitecturabrandon2.entities.StructureResponse;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIPruebas {
    @GET("validarSurtidor/{ipCedis}/{numTerminal}/{numArea}/{numSurtidor}")
    Call<StructureResponse<JsonObject>> obtenerNombreSurtidor (
            @Path("ipCedis") String ipCedis,
            @Path("numTerminal") int numTerminal,
            @Path("numArea")  int numArea,
            @Path("numSurtidor") int numSurtidor
    );
}
