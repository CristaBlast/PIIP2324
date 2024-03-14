package modelo;

import java.util.LinkedList;

public class Aula {
    private String nome;
    private long numero;
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;

    public Aula(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        sumario=new StringBuilder();
        this.professor=null;
        alunos = new LinkedList<>();
    }

    public Aula(String nome, long numero, Professor professor, LinkedList<Aluno> aluno) {
        this(nome, numero);
        this.professor = professor;
        this.alunos = new LinkedList<>();
    }

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public String getSumario() {
        return sumario.toString();
    }

    public LinkedList<Aluno> getAlunos() {
        return alunos;
    }

    public void setProfessor(Professor professor)
    {
        if (professor == null || this.professor==professor) {
            return;
        }
        if (this.professor!=null) {
            professor.remover(this);
        }
        this.professor=professor;
        professor.adicionar(this);
    }

    public void desassociarProfessor()
    {
        if (professor==null)
        {
            return;
        }
        Professor professorADesassociar = professor;
        this.professor=null;
        professorADesassociar.remover(this);

    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void adicionar(Aluno aluno)
    {
        if (aluno==null || alunos.contains(aluno)) {
            return;
        }
        alunos.add(aluno);
        aluno.adicionar(this);
    }

    public void remover(Aluno aluno)
    {
        if (aluno == null || !alunos.contains(aluno)) {
            return;
        }
        alunos.remove(aluno);
        aluno.remover(this);
    }

    public void adicionarLinhaSumario(String linha)
    {
        sumario.append(linha).append('\n');
    }


}
