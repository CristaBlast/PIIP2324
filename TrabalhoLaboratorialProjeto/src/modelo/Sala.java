package modelo;

import java.util.LinkedList;

public class Sala extends Divisao {
    private LinkedList<Aula>aulas;


    public Sala(String nome, boolean porta) {
        super(nome, porta);
        aulas=new LinkedList<>();
    }

    public LinkedList<Aula> getAulas() {
        return aulas;
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

    public void adicionar(Aula aula)
    {
        if (aula==null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        aula.associarAula(this);
    }

    public void remover(Aula aula)
    {
        if (aula==null || aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        aula.desassociarSala(this);
    }
}
