package uniso.br.employeeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    public void irSegundaTela(View view){


        EditText et = findViewById(R.id.IdBuscar);
        String numero = et.getText().toString();
        final TextView tv = findViewById(R.id.tvResposta);
        RetrofitConfig rc = new RetrofitConfig();
        Call<Funcionario> funcionarios = rc.getUserService().buscarFuncionarioPorId(numero);
        funcionarios.enqueue(new Callback<Funcionario>() {
            @Override
            public void onResponse(Call<Funcionario> call, Response<Funcionario> response) {
                Funcionario funcionario = response.body();
                tv.setText(funcionario.getId() + "\n"
                        + "Nome: "+funcionario.getNome() + "\n"
                        + "CPF: "+funcionario.getCpf() + "\n"
                        + "RG: "+funcionario.getRg() + "\n"
                        + "Função: "+funcionario.getFuncao() + "\n");
            }

            @Override
            public void onFailure(Call<Funcionario> call, Throwable t) {

            }
        });

    }


    public void TelaInserir(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);

    }
}