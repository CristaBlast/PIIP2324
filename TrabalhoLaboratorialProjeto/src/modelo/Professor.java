package modelo;

import java.util.LinkedList;

public class Professor {

    private String nome;
    private long numero;
    private LinkedList<Aula> aulas;

    public Professor(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        aulas = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public LinkedList<Aula> getAulas() {
        return new LinkedList<>(aulas);
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void preencherSumario(Aula aula)
    {
        if (aula == null || !getAulas().contains(aula)) {
            return;
        }
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(nome);
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
        for (Aula aula : aulas) {
            if (aula.isSobre(horario))

        }
        return null;
    }
}
