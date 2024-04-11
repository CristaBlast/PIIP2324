package modelo;

import java.util.LinkedList;

public class Sala {
    private String nome;
    private LinkedList<Aula>aulas;
    private boolean porta;


    public Sala(String nome, boolean porta) {
        this.nome = nome;
        this.porta = porta;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<Aula> getAulas() {
        return Aulas;
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        return Aulas;
    }

    public boolean abrir() {
        return porta = true;
    }

    public boolean fechar() {
        return porta;
    }

    public void adicionar(Aula aula)
    {
        if (aula==null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        aula.setAula(this);
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
