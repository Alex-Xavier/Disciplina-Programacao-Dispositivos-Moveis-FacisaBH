package calculadoradeidade.app.alex.alexxavier;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class MainActivity extends AppCompatActivity {

    private Button btnAperte;
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAperte = (Button) findViewById(R.id.button);
        edtText = (EditText) findViewById(R.id.editText);

        btnAperte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = edtText.getText().toString();
                texto = recebeIdade(texto);
                Toast.makeText(getApplicationContext(),
                        texto, Toast.LENGTH_LONG).show();
            }
        });

    }

    public String recebeIdade(String idade) {
        if(isNumeric(idade)) {
            int i;
            try {
                i = Integer.parseInt(idade);
            } catch (Exception e) {
                return "Tente novamente outra idade!";
            }
            if (i <= 1) {
                return "Recém nascido!";
            } else if (i > 1 && i <= 3) {
                return "Bebe!";
            } else if (i > 3 && i <= 12) {
                return "Criança!";
            } else if (i >= 13 && i < 18) {
                return "Adolescente!";
            } else if (i >= 18 && i < 60) {
                return "Adulto!";
            } else {
                return "Idoso!";
            }
        } else {
            return "Idade inválida!";
        }
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}