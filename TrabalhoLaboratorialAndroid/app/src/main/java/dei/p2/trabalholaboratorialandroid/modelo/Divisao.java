package dei.p2.trabalholaboratorialandroid.modelo;
public class Divisao extends Descritor {
    protected boolean porta;

    public Divisao(String nome, boolean porta) {
        super(nome);
        this.porta = porta;
    }

    public boolean isPorta() {
        return porta;
    }

    public boolean abrir() {
        return porta = true;
    }

    public boolean fechar() {
        return porta = false;
    }
}
