package br.edu.ifpr.stiehl.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtValor;
    private EditText txtGorjeta;
    private EditText txtPessoas;
    private TextView lGorjeta;
    private TextView lTotal;
    private TextView lDivisao;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValor = findViewById(R.id.txtValor);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtPessoas = findViewById(R.id.txtPessoas);
        lGorjeta = findViewById(R.id.lGorjeta);
        lTotal = findViewById(R.id.lTotal);
        lDivisao = findViewById(R.id.lDivisao);
        btCalcular = findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float valor = Float.parseFloat(txtValor.getText().toString());
        float percentualGorjeta = Float.parseFloat(txtGorjeta.getText().toString());
        int pessoas = Integer.parseInt(txtPessoas.getText().toString());

        float gorjeta = valor * (percentualGorjeta / 100);
        float conta = valor + gorjeta;
        float divisao = conta / pessoas;

        lGorjeta.setText("Gorjeta (R$): " + gorjeta);
        lTotal.setText("Total da Conta: R$ " + conta);
        lDivisao.setText("Total de R$ " + divisao + " por pessoa");
    }
}
