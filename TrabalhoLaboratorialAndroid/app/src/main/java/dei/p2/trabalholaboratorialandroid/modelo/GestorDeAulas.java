package dei.p2.trabalholaboratorialandroid.modelo;

import java.util.LinkedList;

public class GestorDeAulas{
    private LinkedList<Aula>aulas;
    private RepositorioDeAulas repositorioDeAulas;

    public GestorDeAulas(RepositorioDeAulas repositorioDeAulas) {
        this.repositorioDeAulas=repositorioDeAulas;
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
        repositorioDeAulas.associar(aula);
    }

    public void remover(Aula aula)
    {
        if (aula==null || aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        repositorioDeAulas.desassociar(aula);
    }
}
