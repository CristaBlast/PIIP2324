import java.util.LinkedList;

public class Aula {
    private String nome;
    private long numero;
    private String sumario;
    private Professor professor;
    private LinkedList<Aluno> aluno;

    public Aula(String nome, long numero) {
        this.nome = nome;
        this.numero = numero;
        sumario="";
        professor=null;
        aluno = new LinkedList<>();
    }

    public void atribuir(Professor professor)
    {

    }

    public void adicionar(Aluno aluno)
    {

    }

    public void adicionarLinhaSumario(String linha)
    {

    }
}
