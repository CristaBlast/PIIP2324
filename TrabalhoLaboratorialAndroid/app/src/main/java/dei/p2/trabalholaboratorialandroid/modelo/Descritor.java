package dei.p2.trabalholaboratorialandroid.modelo;

public class Descritor {

    @Override public String toString() { return nome; }
    protected String nome;

    public Descritor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
