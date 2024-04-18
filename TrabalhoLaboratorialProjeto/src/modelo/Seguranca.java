package modelo;

import java.util.LinkedList;

public class Seguranca extends Pessoa{
    private GabineteSeguranca gabinete;
    private LinkedList<Horario> horariosAtendimento;

    public Seguranca(String nome, long numero, GabineteSeguranca gabineteSeguranca) {
        super(nome, numero);
        this.gabinete = gabinete;
        this.horariosAtendimento = new LinkedList<>();
    }

    public void setProfessor(GabineteSeguranca gabinete) {
        if (gabinete == null || this.gabinete == gabinete) {
            return;
        }
        if (this.gabinete != null) {
            gabinete.remover(this);
        }
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void desassociarProfessor() {
        if (gabinete == null) {
            return;
        }
        GabineteSeguranca gabineteADesassociar = gabinete;
        this.gabinete = null;
        gabineteADesassociar.remover(this);

    }

    public void abrirGabinete() {
        if (gabinete == null || gabinete.isPorta()) {
            return;
        }
        gabinete.abrir();

    }

    public void fecharGabinete() {
        if (!gabinete.isPorta()) {
            return;
        }
        gabinete.fechar();
    }

    public void abrir(Sala sala) {
        if (sala.isPorta() || sala == null) {
            return;
        }
        sala.abrir();
    }

    public void fechar(Sala sala) {
        if (!sala.isPorta()) {
            return;
        }
        sala.fechar();
    }


    public GabineteSeguranca getGabinete() {
        return gabinete;
    }

    public LinkedList<Horario> getHorarioAtendimento() {
        return new LinkedList<>(horariosAtendimento);
    }

    public void adicionar(Horario horarioAtendimento) {
        if (horarioAtendimento == null || horariosAtendimento.contains(horarioAtendimento)) {
            return;
        }
        horariosAtendimento.add(horarioAtendimento);
    }

    public void remover(Horario horarioAtendimento) {
        if (horarioAtendimento == null || !horariosAtendimento.contains(horarioAtendimento)) {
            return;
        }
        horariosAtendimento.remove(horarioAtendimento);
    }

    public void setGabinete(GabineteSeguranca gabinete) {
        if (gabinete == null || this.gabinete==gabinete) {
            return;
        }
        if (this.gabinete != null) {
            gabinete.remover(this);
        }
        this.gabinete = gabinete;
        gabinete.adicionar(this);
    }

    public void desassociarGabinete()
    {
        if (gabinete==null)
        {
            return;
        }
        GabineteSeguranca gabineteADesassociar = gabinete;
        this.gabinete=null;
        gabineteADesassociar.remover(this);

    }

    public void abrir(GabineteProfessor gabinete) {
        if (gabinete.isPorta() || gabinete == null) {
            return;
        }
        gabinete.abrir();
    }

    public void fechar(GabineteProfessor gabinete) {
        if (!gabinete.isPorta()) {
            return;
        }
        gabinete.fechar();
    }

    public void abrir(GabineteSeguranca gabinete) {
        if (gabinete.isPorta() || gabinete == null) {
            return;
        }
        gabinete.abrir();
    }

    public void fechar(GabineteSeguranca gabinete) {
        if (!gabinete.isPorta()) {
            return;
        }
        gabinete.fechar();
    }
}
