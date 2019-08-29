package com.cedisropa.pruebaarquitecturabrandon2.utils;

import android.content.res.Resources;

import com.cedisropa.pruebaarquitecturabrandon2.R;

public class ResourceProvider {
    public Resources resources;
    public String pruebasNumSurtidor;

    public ResourceProvider(Resources resources) {
        this.resources = resources;
        this.pruebasNumSurtidor = resources.getString(R.string.pruebas_num_surtido);
    }

}
