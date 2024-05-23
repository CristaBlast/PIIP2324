package dei.p2.trabalholaboratorialandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import dei.p2.trabalholaboratorialandroid.databinding.ActivityDetalhesAulaBinding;
import dei.p2.trabalholaboratorialandroid.modelo.*;

public class DetalhesAulaActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADICIONAR_ALUNO = 0;
    public static final String INDICE_AULA = "INDICE_AULA";
    private ActivityDetalhesAulaBinding binding;
    private int indiceAula;
    private Aula aula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalhesAulaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);
        aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);
        binding.textViewNome.setText(aula.getNome());
        binding.textViewNumero.setText(String.valueOf(aula.getNumero()));
        binding.textViewHorario.setText(aula.getHorario().toString());
        binding.textViewSala.setText(aula.getSala().getNome());
        binding.textViewProfessor.setText(aula.getProfessor().getNome());
        atualizarListaAlunos();
    }

    private void atualizarListaAlunos() {
        binding.listViewAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aula.getAlunos()));
    }

    public static Intent createIntent(Context context, int indiceAula) { /* Intent intent = new Intent(context, DetalhesAulaActivity.class); intent.putExtra("INDICE_AULA", indiceAula); return intent; */
        return new Intent(context, DetalhesAulaActivity.class).putExtra(INDICE_AULA, indiceAula);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhes_aula, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemAdicionarAluno) {
            onItemAdicionarSelected();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onItemAdicionarSelected() {
        //Toast.makeText(this, "Aqui deveria adicionar aluno", Toast.LENGTH_SHORT).show();
        startActivityForResult(AdicionarAlunoActivity.createIntent(this, indiceAula), REQUEST_CODE_ADICIONAR_ALUNO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_ADICIONAR_ALUNO) {
                atualizarListaAlunos();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}