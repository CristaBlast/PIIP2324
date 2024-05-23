package dei.p2.trabalholaboratorialandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.LinkedList;

import dei.p2.trabalholaboratorialandroid.databinding.ActivityMainBinding;
import dei.p2.trabalholaboratorialandroid.modelo.*;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LinkedList<Aula> aulas = GestorSemanaAulas.INSTANCIA.getAulas();
        binding.listViewAulas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aulas));
        binding.listViewAulas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(DetalhesAulaActivity.createIntent(MainActivity.this, position));
            }
        });
    }
}