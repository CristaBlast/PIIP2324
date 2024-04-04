package modelo;

import java.util.LinkedList;

public class Aluno extends Identificador{
    private LinkedList<Aula> aulas;

    public Aluno(String nome, long numero) {
        super(nome, numero);
        aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }


    public void adicionar(Aula aula)
    {
        if (aula==null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        aula.adicionar(this);
    }

    public void remover(Aula aula)
    {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        aula.remover(this);
    }

    public void preencherSumario(Aula aula)
    {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aula.adicionarLinhaSumario(getNome());//TODO
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
