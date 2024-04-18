package modelo;

import java.util.LinkedList;

public class GabineteSeguranca extends Divisao{
    private LinkedList<Seguranca> segurancas;

    public GabineteSeguranca(String nome, boolean porta) {
        super(nome,porta);
        this.segurancas = new LinkedList<>();
    }

    public LinkedList<Seguranca> getSegurancas() {
        return new LinkedList<>(segurancas);
    }


    public void adicionar(Seguranca seguranca) {
        if (seguranca == null || segurancas.contains(seguranca)) {
            return;
        }
        segurancas.add(seguranca);
        seguranca.setGabinete(this);
    }

    public void remover(Seguranca seguranca) {
        if (seguranca == null || segurancas.contains(seguranca)) {
            return;
        }
        segurancas.remove(seguranca);
        seguranca.desassociarGabinete();
    }
}
