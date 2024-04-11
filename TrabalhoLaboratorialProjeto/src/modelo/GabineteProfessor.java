package modelo;

import java.util.LinkedList;

public class GabineteProfessor {
    private String nome;
    private LinkedList<Professor> professores;
    private boolean porta;

    public GabineteProfessor(String nome, boolean porta) {
        this.nome = nome;
        this.porta = porta;
    }

    public String getNome() {
        return nome;
    }

    public LinkedList<Professor> getProfessores() {
        return professores;
    }

    public boolean isPorta() {
        return porta;
    }

    public boolean abrir() {
        return porta=true;
    }

    public boolean fechar() {
        return porta=false;
    }

    public void adicionar(Professor professor)
    {

    }

    public void remover(Professor professor)
    {

    }
}
