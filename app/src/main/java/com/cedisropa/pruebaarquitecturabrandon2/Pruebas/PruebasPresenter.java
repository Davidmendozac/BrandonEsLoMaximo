package com.cedisropa.pruebaarquitecturabrandon2.Pruebas;

import android.view.View;

import com.cedisropa.pruebaarquitecturabrandon2.utils.ResourceProvider;
import com.cedisropa.sdk.DatosGenerales;

public class PruebasPresenter implements PruebasViewPresenter, PruebasObtainer{
    private DatosGenerales datosGenerales;
    private ResourceProvider resourceProvider;
    private PruebasProvider pruebasProvider;
    private PruebasView view;

    public PruebasPresenter(PruebasView view, ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
        this.view = view;
        pruebasProvider = new PruebasInteractor(this, resourceProvider);

    }

    @Override
    public void recibirDatosGenerales(DatosGenerales datosGenerales) {
        this.datosGenerales = datosGenerales;
    }

    @Override
    public void obtenerNombreSurtidor(int numSurtidor) {
        pruebasProvider.obtenerNombreSurtidor(datosGenerales.getIpBodega(), datosGenerales.getNumArea(),
                datosGenerales.getNumTerminal(), numSurtidor);
    }

    @Override
    public void responseObtenerNombreSurtidor(String nomSurtidor) {
        view.mostrarNombreSurtidor(nomSurtidor);
    }
}
