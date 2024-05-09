package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa implements Funcionario<GabineteSeguranca> {
    private GabineteSeguranca gabinete;
    private GestorFuncionario gestorFuncionario;

    public Seguranca(String nome, long numero, GabineteSeguranca gabineteSeguranca) {
        super(nome, numero);
        this.gabinete = gabinete;
        gestorFuncionario = new GestorFuncionario();
    }

    @Override
    public void abrirGabinete() {
        if (gabinete == null || gabinete.isPorta()) {
            return;
        }
        gabinete.abrir();

    }

    @Override
    public void fecharGabinete() {
        if (!gabinete.isPorta()) {
            return;
        }
        gabinete.fechar();
    }


    public void abrir(Divisao divisao) {
        if (divisao.isPorta() || divisao == null) {
            return;
        }
        divisao.abrir();
    }


    public void fechar(Divisao divisao) {
        if (!divisao.isPorta()) {
            return;
        }
        divisao.fechar();
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    @Override
    public LinkedList<Horario> getHorarioAtendimento() {
        return gestorFuncionario.getHorarioAtendimento();
    }

    @Override
    public void adicionar(Horario horarioAtendimento) {
        gestorFuncionario.adicionar(horarioAtendimento);
    }

    @Override
    public void remover(Horario horarioAtendimento) {
        gestorFuncionario.remover(horarioAtendimento);
    }

    public void setGabinete(GabineteSeguranca gabinete) {
        if (gabinete == null || this.gabinete == gabinete) {
            return;
        }
        if (this.gabinete != null) {
            gabinete.remover(this);
        }
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void desassociarGabinete() {
        if (gabinete == null) {
            return;
        }
        GabineteSeguranca gabineteADesassociar = gabinete;
        this.gabinete = null;
        gabineteADesassociar.remover(this);

    }
}