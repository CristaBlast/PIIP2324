package dei.p2.trabalholaboratorialandroid.modelo;

public class Aluno extends PessoaComAulas {

    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    public void associar(Aula aula) {
        aula.adicionar(this);
    }

    public void desassociar(Aula aula) {
        aula.remover(this);
    }

    @Override
    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(getNome());
    }

}
