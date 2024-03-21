package modelo;

public enum DiaSemana {
    DOMINGO("Domingo"),
    SEGUNDA_FEIRA("2º feira"),
    TERCA_FEIRA("3º feira"),
    QUARTA_FEIRA("4º feira"),
    QUINTA_FEIRA("5º feira"),
    SEXTA_FEIRA("6º feira"),
    SABADO("Sábado");


    private final String dia;

    DiaSemana(String dia)
    {
        this.dia=dia;
    }

    public String getDia()
    {
        return dia;
    }

    @Override
    public String toString() {
        return super.toString()+"->"+dia;
    }
}
