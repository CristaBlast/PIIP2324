package modelo;

import java.util.LinkedList;

public class Professor extends Identificador{

    private LinkedList<Aula> aulas;

    public Professor(String nome, long numero) {
        super(nome, numero);
        aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public void preencherSumario(Aula aula)
    {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(getNome());
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    public void adicionar(Aula aula)
    {
        if (aula==null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        aula.setProfessor(this);
    }

    public void remover(Aula aula)
    {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        aula.desassociarProfessor();
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasADevolver = new LinkedList<>(); //sublist
        for (Aula aula : aulas) {
                if (aula.getHorario().isSobre(horario))
                {
                    aulasADevolver.add(aula);
                }
            }
        return aulasADevolver;
    }
}
