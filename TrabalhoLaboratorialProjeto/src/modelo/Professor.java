package modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor>{

    private GabineteProfessor gabinete;
    private GestorFuncionario gestorFuncionario;

    public Professor(String nome, long numero, GabineteProfessor gabinete) {
        super(nome, numero);
        this.gabinete = gabinete;
        gestorFuncionario = new GestorFuncionario();
    }

    protected void escreverSumario(Aula aula) {
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(getNome());
        for (Aluno aluno : aula.getAlunos()) {
            aluno.preencherSumario(aula);
        }
    }

    public void associar(Aula aula) {
        aula.setProfessor(this);
    }

    public void desassociar(Aula aula) {
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
