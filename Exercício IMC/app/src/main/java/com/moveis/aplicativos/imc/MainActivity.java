package com.moveis.aplicativos.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnOk;
    private EditText lblPeso;
    private EditText lblAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnOk = (Button) findViewById(R.id.btnOk);
        lblPeso = (EditText) findViewById(R.id.editText1);
        lblAltura = (EditText) findViewById(R.id.editText2);
        
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float p, a;
                String resposta;
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);

                try {

                    p = Float.parseFloat(lblPeso.getText().toString());
                    a = Float.parseFloat(lblAltura.getText().toString());

                    resposta = calcularImc(p,a);

                    Toast.makeText(getApplicationContext(), resposta, Toast.LENGTH_LONG).show();

                    dialogo.setMessage(resposta);
                    dialogo.setNeutralButton("OK",null);
                    dialogo.show();

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), getString(R.string.msgErro), Toast.LENGTH_LONG).show();

                    dialogo.setMessage(getString(R.string.msgErro));
                    dialogo.setNeutralButton("OK",null);
                    dialogo.show();

                }

            }
        });

    }
    
    protected String calcularImc(float peso, float altura) {

        if (altura == 0) {
            return getString(R.string.msgErro);
        }

        float resposta;

        try {

            resposta = peso / (altura * altura);

        } catch (Exception e) {

            return getString(R.string.msgErro);

        }

        if (resposta < 17) {

            return "IMC = " + String.format("%.2f", resposta) + " " + getString(R.string.msgImcMuitoAbaixoPeso);

        } else if (resposta >= 17 && resposta < 18.5) {

            return "IMC = " + String.format("%.2f", resposta) + " " + getString(R.string.msgImcAbaixoPeso);

        } else if (resposta >= 18.5 && resposta < 25) {

            return "IMC = " + String.format("%.2f", resposta) + " " + getString(R.string.msgImcPesoNormal);

        } else if (resposta >= 25 && resposta < 30) {

            return "IMC = " + String.format("%.2f", resposta) + " " + getString(R.string.msgImcAcimaPeso);

        } else if (resposta >= 30 && resposta < 35) {

            return "IMC = " + String.format("%.2f", resposta) + " " + getString(R.string.msgImcObesidade1);

        } else if (resposta >= 35 && resposta < 40) {

            return "IMC = " + String.format("%.2f", resposta) + " " + getString(R.string.msgImcObesidade2);

        } else {

            return "IMC = " + String.format("%.2f", resposta) + " " + getString(R.string.msgImcObesidade3);

        }

    }
}
