package modelo;

public class Aluno extends PessoaComAulas {

    public Aluno(String nome, long numero) {
        super(nome, numero);
    }

    protected void associar(Aula aula) {
        aula.adicionar(this);
    }

    protected void desassociar(Aula aula) {
        aula.remover(this);
    }

    @Override
    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(getNome());
    }

}
