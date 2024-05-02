package modelo;

import java.util.LinkedList;

public interface Funcionario{
    void abrirGabinete();

    void fecharGabinete();

    LinkedList<Horario> getHorarioAtendimento();

    void adicionar(Horario horarioAtendimento);

    void remover(Horario horarioAtendimento);

    public void desassociarGabinete();
}
