package dei.p2.trabalholaboratorialandroid.modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor,Sala>{

    private GestorFuncionario<GabineteProfessor,Sala> gestorFuncionario ;

    public Professor(String nome, long numero, GabineteProfessor gabinete) {
        super(nome, numero);
        gestorFuncionario = new GestorFuncionario<>(this);
        setGabinete(gabinete);
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

    public void abrirGabinete() {
        gestorFuncionario.abrirGabinete();
    }

    public void fecharGabinete() {
        gestorFuncionario.fecharGabinete();
    }

    public Gabinete getGabinete() {
        return gestorFuncionario.getGabinete();
    }

    public void abrir(Sala sala) {
        gestorFuncionario.abrir(sala);
    }


    public void fechar(Sala sala) {
        gestorFuncionario.fechar(sala);
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
        gestorFuncionario.setGabinete(gabinete);
    }

    public void desassociarGabinete()
    {
        gestorFuncionario.desassociarGabinete();
    }


}
