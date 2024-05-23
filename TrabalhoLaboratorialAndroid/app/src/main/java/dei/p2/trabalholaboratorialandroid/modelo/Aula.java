package dei.p2.trabalholaboratorialandroid.modelo;

import java.util.LinkedList;

public class Aula  extends Identificador{

    @Override public String toString() { return "\n" + super.toString() + "\n" + sala + "\n"; }
    private StringBuilder sumario;
    private Professor professor;
    private LinkedList<Aluno> alunos;

    private Sala sala;

    private Horario horario;

    public Aula(String nome, long numero,Horario horario,Sala sala) {
        this(nome, numero,horario,sala,null,new LinkedList<>());
    }


    public Aula(String nome, long numero, Horario horario , Sala sala,Professor professor, LinkedList<Aluno> alunos) {
        super(nome, numero);
        this.setProfessor(professor);
        sumario=new StringBuilder();
        this.alunos = new LinkedList<>();
        this.horario = horario;
        for (Aluno aluno : alunos) {
            adicionar(aluno);
        }
        this.sala=sala;
    }

    public Sala getSala() {
        return sala;
    }

    public void Associar(Sala sala) {
        this.sala = sala;
    }

    public void Desassociar (Sala sala) {
        this.sala = sala;
    }

    public String getSumario() {
        return sumario.toString();
    }

    public LinkedList<Aluno> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return professor;
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

    public Horario getHorario() {
        return horario;
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


    public void setSala(Sala sala) {
        if (sala == null || this.sala==sala) {
            return;
        }
        if (this.sala!=null) {
            sala.remover(this);
        }
        this.sala=sala;
        sala.adicionar(this);
    }

    public void desassociarSala(Sala sala) {
        if (sala==null)
        {
            return;
        }
        this.sala = sala;
        sala=null;
    }
}
