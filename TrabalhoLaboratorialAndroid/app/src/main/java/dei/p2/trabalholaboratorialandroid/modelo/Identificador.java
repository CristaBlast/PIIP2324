package dei.p2.trabalholaboratorialandroid.modelo;

public abstract class Identificador extends Descritor {
    private long numero;

    public Identificador(String nome, long numero) {
        super(nome);
        this.numero = numero;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
}
