package dei.p2.trabalholaboratorialandroid.modelo;

public class Horario {
    private final DiaSemana diaSemana;
    private final int horaInicio;
    private final int duracao;

    public Horario(DiaSemana diaSemana, int horaInicio, int duracao) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public boolean isSobre(Horario horario) {
        //verificar a intersseçãpo de this com horario
        return !(diaSemana==horario.diaSemana||horaInicio+duracao<=horario.horaInicio || horaInicio>=horario.horaInicio+horario.duracao);

    }
    @Override public String toString() { return diaSemana + " " + horaInicio + "h - " + (horaInicio + duracao) + "h"; }
}
