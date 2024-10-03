/*
 *@author:<Leudvan Guedes>
 */

package br.edu.fateczl.areaTrapezio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etBaseMaior;
    private EditText etBaseMenor;
    private EditText etAltura;
    private TextView tvResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etBaseMaior = findViewById(R.id.etBaseMaior);
        etBaseMenor = findViewById(R.id.etBaseMenor);
        etAltura = findViewById(R.id.etAltura);
        tvResposta = findViewById(R.id.tvResposta);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calcular());
    }

    private void calcular() {
        int baseMaior = Integer.parseInt(etBaseMaior.getText().toString());
        int baseMenor = Integer.parseInt(etBaseMenor.getText().toString());
        int altura = Integer.parseInt(etAltura.getText().toString());
        limparEditTexts(etBaseMaior,etBaseMenor,etAltura);

        int areaTrapezio = ((baseMaior+baseMenor)*altura)/2;
        String res = getString(R.string.resposta) + " " + areaTrapezio + "m";

        tvResposta.setText(res);
    }

    private void limparEditTexts(EditText... et) {
        for (EditText editText: et) {
            editText.setText("");
        }
    }

}