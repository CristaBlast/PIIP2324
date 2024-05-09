package modelo;

import java.util.LinkedList;

public interface Funcionario <TGabinete extends Gabinete<?>>{
    void abrirGabinete();

    void fecharGabinete();

    LinkedList<Horario> getHorarioAtendimento();

    void adicionar(Horario horarioAtendimento);

    void remover(Horario horarioAtendimento);

    void desassociarGabinete();

    void setGabinete(TGabinete gabinete);

    Gabinete getGabinete();

}
