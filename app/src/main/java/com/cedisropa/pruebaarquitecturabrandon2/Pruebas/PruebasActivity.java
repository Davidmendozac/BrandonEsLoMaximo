package com.cedisropa.pruebaarquitecturabrandon2.Pruebas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cedisropa.pruebaarquitecturabrandon2.R;
import com.cedisropa.pruebaarquitecturabrandon2.utils.ResourceProvider;
import com.cedisropa.sdk.DatosGenerales;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PruebasActivity extends AppCompatActivity implements PruebasView{
    @BindView(R.id.txt_num_surtidor)
    EditText txtNumSurtidor;
    @BindView(R.id.lbl_nom_surtidor)
    TextView lblNomSurtidor;

    private PruebasViewPresenter pruebasViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);
        ButterKnife.bind(this);

        pruebasViewPresenter = new PruebasPresenter(this, new ResourceProvider(this.getResources()));

        DatosGenerales datosGenerales = new DatosGenerales();
        datosGenerales.setIpBodega("10.28.114.110");
        datosGenerales.setNumTerminal(1286);
        datosGenerales.setNumArea(1);
        pruebasViewPresenter.recibirDatosGenerales(datosGenerales);

        txtNumSurtidor.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && txtNumSurtidor.length() > 0) {
                    int numSurtidor = Integer.valueOf(txtNumSurtidor.getText().toString());
                    pruebasViewPresenter.obtenerNombreSurtidor(numSurtidor);
                }
                return false;
            }
        });
    }


    @Override
    public void mostrarNombreSurtidor(String nomSurtidor) {
        lblNomSurtidor.setText(nomSurtidor);
    }
}
