package dei.p2.trabalholaboratorialandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import dei.p2.trabalholaboratorialandroid.databinding.ActivityAdicionarAlunoBinding;
import dei.p2.trabalholaboratorialandroid.modelo.*;


public class AdicionarAlunoActivity extends AppCompatActivity {
    private static final String INDICE_AULA = "INDICE_AULA";
    private ActivityAdicionarAlunoBinding binding;
    private Aula aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdicionarAlunoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        int indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);
        aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);
    }

    public static Intent createIntent(Context context, int indiceAula) {
        return new Intent(context, AdicionarAlunoActivity.class).putExtra(INDICE_AULA, indiceAula);
    }

    public void onAdicionarClick(View view) {
        EditText editTextNome = binding.editTextNome;
        EditText editTextNumero = binding.editTextNumero;
        String nome = editTextNome.getText().toString().trim();
        String numeroString = editTextNumero.getText().toString().trim();
        boolean haErros = false;
        if (nome.isEmpty()) {
            editTextNome.setError(getString(R.string.txtErroNomeInvalido));
            haErros = true;
        }
        if (numeroString.isEmpty()) {
            editTextNumero.setError(getString(R.string.txtErroNumeroInvalido));
            haErros = true;
        }
        if (haErros) {
            return;
        }
        long numero = Long.parseLong(numeroString);
        Aluno aluno = new Aluno(nome, numero);
        aluno.adicionar(aula);
        setResult(RESULT_OK);
        finish();
    }
}