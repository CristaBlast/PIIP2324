package dei.p2.trabalholaboratorialandroid.modelo;

import java.util.LinkedList;

public class FuncionarioSeguranca<TDivisao extends Divisao> extends Pessoa implements Funcionario<GabineteSeguranca, TDivisao> {
    protected GestorFuncionario<GabineteSeguranca, TDivisao> gestorFuncionario;

    public FuncionarioSeguranca(String nome, long numero, GabineteSeguranca gabinete) {
        super(nome, numero);
        gestorFuncionario = new GestorFuncionario<>(this);
        setGabinete(gabinete);
    }

    public void abrirGabinete() {
        gestorFuncionario.abrirGabinete();
    }

    public void fecharGabinete() {
        gestorFuncionario.fecharGabinete();
    }

    public void abrir(TDivisao divisao) {
        gestorFuncionario.abrir(divisao);
    }

    public void fechar(TDivisao divisao) {
        gestorFuncionario.fechar(divisao);
    }

    public Gabinete getGabinete() {
        return gestorFuncionario.getGabinete();
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
        gestorFuncionario.setGabinete(gabinete);
    }

    public void desassociarGabinete() {
        gestorFuncionario.desassociarGabinete();
    }
}
