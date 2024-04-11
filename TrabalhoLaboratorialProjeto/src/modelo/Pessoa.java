package modelo;

import java.util.LinkedList;

public abstract class Pessoa extends Identificador {
    protected LinkedList<Aula> aulas;

    public Pessoa(String nome, long numero) {
        super(nome, numero);
        aulas = new LinkedList<>();
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public void preencherSumario(Aula aula) {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    public void remover(Aula aula)
    {
        if (aula == null || !aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        desassociar(aula);
    }

    protected abstract void desassociar(Aula aula);

    public void adicionar(Aula aula)
    {
        if (aula==null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    protected abstract void associar(Aula aula);

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
