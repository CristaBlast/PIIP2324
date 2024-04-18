package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas {

    private LinkedList<Aula> aulas;
    private GabineteProfessor gabinete;
    private LinkedList<Horario> horariosAtendimento;

    public Professor(String nome, long numero, GabineteProfessor gabinete) {
        super(nome, numero);
        this.gabinete = gabinete;
        this.horariosAtendimento = new LinkedList<>();
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(getNome());
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    protected void associar(Aula aula) {
        aula.setProfessor(this);
    }

    protected void desassociar(Aula aula) {
        aula.desassociarProfessor();
    }

    public void setProfessor(GabineteProfessor gabinete) {
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
        GabineteProfessor gabineteADesassociar = gabinete;
        this.gabinete = null;
        gabineteADesassociar.remover(this);

    }

    public void abrirGabinete() {
        if (gabinete.isPorta()) {
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


    public GabineteProfessor getGabinete() {
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

    public void setGabinete(GabineteProfessor gabinete) {
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
        GabineteProfessor gabineteADesassociar = gabinete;
        this.gabinete=null;
        gabineteADesassociar.remover(this);

    }
}
