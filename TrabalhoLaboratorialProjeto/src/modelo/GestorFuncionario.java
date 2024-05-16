package modelo;

import java.util.LinkedList;

public class GestorFuncionario<TGabinete extends Gabinete,TDivisao extends Divisao>{
    private LinkedList<Horario> horariosAtendimento;
    private TGabinete gabinete;
    private Funcionario<TGabinete,TDivisao> funcionario;


    public GestorFuncionario(Funcionario<TGabinete,TDivisao> funcionario) {
        this.horariosAtendimento = new LinkedList<>();
        this.funcionario = funcionario;
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

    public TGabinete getGabinete() {
        return gabinete;
    }

    public void setGabinete(TGabinete gabinete) {
        if (gabinete == null || this.gabinete==gabinete) {
            return;
        }
        if (this.gabinete != null) {
            gabinete.remover(funcionario);
        }
        this.gabinete = gabinete;
        gabinete.adicionar(funcionario);
    }

    public void desassociarGabinete()
    {
        if (gabinete==null)
        {
            return;
        }
        TGabinete gabineteADesassociar = gabinete;
        this.gabinete=null;
        gabineteADesassociar.remover(funcionario);
    }

    public void abrir(TDivisao divisao) {
        if (divisao.isPorta() || divisao == null) {
            return;
        }
        divisao.abrir();
    }


    public void fechar(TDivisao divisao) {
        if (!divisao.isPorta()) {
            return;
        }
        divisao.fechar();
    }
}