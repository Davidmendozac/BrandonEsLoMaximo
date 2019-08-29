package com.cedisropa.pruebaarquitecturabrandon2.Pruebas;

import android.util.Log;

import com.cedisropa.pruebaarquitecturabrandon2.api.APIPruebas;
import com.cedisropa.pruebaarquitecturabrandon2.entities.Data;
import com.cedisropa.pruebaarquitecturabrandon2.entities.StructureResponse;
import com.cedisropa.pruebaarquitecturabrandon2.services.RetrofitClient;
import com.cedisropa.pruebaarquitecturabrandon2.utils.ResourceProvider;
import com.cedisropa.sdk.WebServices;
import com.cedisropa.sdk.WebserviceNotFoundException;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PruebasInteractor implements PruebasProvider {
    private static final String LOG_TAG = PruebasInteractor.class.getSimpleName();
    private ResourceProvider resourceProvider;
    private APIPruebas pruebasService;
    private PruebasObtainer pruebasObtainer;

    public PruebasInteractor(PruebasObtainer pruebasObtainer, ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
        this.pruebasObtainer = pruebasObtainer;

        try {
            pruebasService = RetrofitClient.getService(APIPruebas.class, WebServices.getService(9).getUrl().toString());
        }
        catch (WebserviceNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void obtenerNombreSurtidor(String ip, int numArea, int numTerminal, int numSurtidor) {
        Call<StructureResponse<JsonObject>> call =
                pruebasService.obtenerNombreSurtidor(ip, numTerminal, numArea, numSurtidor);

        call.enqueue(new Callback<StructureResponse<JsonObject>>() {
            @Override
            public void onResponse(Call<StructureResponse<JsonObject>> call, Response<StructureResponse<JsonObject>> response) {
                Data<JsonObject> data = response.body().getData();

                if (data.getStatus() == 1) {
                    String nomSurtidor = data.getData().get("nomSurtidor").getAsString();
                    pruebasObtainer.responseObtenerNombreSurtidor(nomSurtidor);

                } else {
                    //TODO: Avisar a usuario
                }
            }

            @Override
            public void onFailure(Call<StructureResponse<JsonObject>> call, Throwable t) {
                Log.e(LOG_TAG, "Error al validar surtidor", t);
            }
        });
    }
}
