package dei.p2.trabalholaboratorialandroid.modelo;

import java.util.LinkedList;

public class Sala extends Divisao implements  RepositorioDeAulas{
    private GestorDeAulas gestorDeAulas;

    public Sala(String nome, boolean porta) {
        super(nome, porta);
        gestorDeAulas = new GestorDeAulas(this);
    }

    public LinkedList<Aula> getAulas() {
        return gestorDeAulas.getAulas();
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorDeAulas.getAulas(horario);
    }

    public void adicionar(Aula aula)
    {
        gestorDeAulas.adicionar(aula);
    }

    public void remover(Aula aula)
    {
        gestorDeAulas.remover(aula);
    }

    public void associar(Aula aula) {
        aula.setSala(this);
    }

    public void desassociar(Aula aula) {
        aula.desassociarSala(this);
    }
}
