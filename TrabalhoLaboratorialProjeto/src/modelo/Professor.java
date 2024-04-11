package modelo;

import java.util.LinkedList;

public class Professor extends Pessoa{

    private LinkedList<Aula> aulas;
    private GabineteProfessor gabineteProfessor;
    private Horario horarioAtendimento;

    public Professor(String nome, long numero) {
        super(nome, numero);
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(getNome());
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    protected void associar(Aula aula) {
        aula.setProfessor(this);
    }

    protected void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    public void abrirGabinete() {
    }

    public void fecharGabinete() {
    }

    public GabineteProfessor getGabinete() {
        return gabineteProfessor;
    }
}
