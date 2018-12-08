package com.example.ads.pesoideal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected RadioButton opHomem;
    protected RadioButton opMulher;
    protected EditText qntAltura;
    protected Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opHomem = (RadioButton) findViewById(R.id.opHomem);
        opMulher = (RadioButton) findViewById(R.id.opMulher);
        btnOk = (Button) findViewById(R.id.btnOk);
        qntAltura = (EditText) findViewById(R.id.qntAltura);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float f;
                int k;
                if (opHomem.isChecked()) {
                    k = 4;
                    try {
                        f = Float.parseFloat(qntAltura.getText().toString());
                        f = calcularPesoIdeal(k,f);
                        Toast.makeText(getBaseContext(), "Peso ideal = " + Float.toString(f),
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Homem, mas sua altura é inválida, tente novamente!",
                                Toast.LENGTH_LONG).show();
                    }
                } else if (opMulher.isChecked()) {
                    k = 2;
                    try {
                        f = Float.parseFloat(qntAltura.getText().toString());
                        f = calcularPesoIdeal(k,f);
                        Toast.makeText(getBaseContext(), "Peso ideal = " + Float.toString(f),
                                Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Mulher, mas sua altura é inválida, tente novamente!",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getBaseContext(), "Nenhum valor selecionado, tente novamente!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    public float calcularPesoIdeal(int k, float altura) {
        float resultado = altura - 100;
        resultado = ((altura - 150) / k) - resultado;
        return resultado;
    }
}
