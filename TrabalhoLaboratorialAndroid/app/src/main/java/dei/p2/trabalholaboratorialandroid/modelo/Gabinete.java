package dei.p2.trabalholaboratorialandroid.modelo;

import java.util.LinkedList;

public class Gabinete<TFuncionario extends Funcionario> extends Divisao {
    protected LinkedList<TFuncionario> funcionarios;

    public Gabinete(String nome, boolean porta) {
        super(nome, porta);
        funcionarios = new LinkedList<>();
    }

    public LinkedList<TFuncionario> getFuncionarios() {
        return new LinkedList<>(funcionarios);
    }

    public void adicionar(TFuncionario funcionario) {
        if (funcionario == null || funcionarios.contains(funcionario)) {
            return;
        }
        funcionarios.add(funcionario);
        funcionario.setGabinete(this);
    }

    public void remover(Funcionario funcionario) {
        if (funcionario == null || funcionarios.contains(funcionario)) {
            return;
        }
        funcionarios.remove(funcionario);
        funcionario.desassociarGabinete();
    }


}
