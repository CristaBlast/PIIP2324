package modelo;

import java.util.LinkedList;

public class GestorFuncionario {
    private LinkedList<Horario> horariosAtendimento;

    public GestorFuncionario() {
        this.horariosAtendimento = new LinkedList<>();
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
}