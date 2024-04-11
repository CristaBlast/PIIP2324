package modelo;

public class Seguranca extends Identificador{
    private GabineteSeguranca gabineteSeguranca;
    private Horario horarioAtendimento;

    public Seguranca(String nome, long numero, GabineteSeguranca gabineteSeguranca) {
        super(nome, numero);
        this.gabineteSeguranca = gabineteSeguranca;
    }

    public GabineteSeguranca getGabineteSeguranca() {
        return gabineteSeguranca;
    }

    public Horario getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void abrir(Sala sala)
    {

    }

    public void fechar(Sala sala)
    {

    }

    public void abrir(GabineteSeguranca gabineteSeguranca)
    {

    }

    public void fechar(GabineteSeguranca gabineteSeguranca)
    {

    }

    public void abrir(GabineteProfessor gabineteProfessor)
    {

    }

    public void fechar(GabineteProfessor gabineteProfessor)
    {

    }

    public void associar(GabineteSeguranca gabineteSeguranca)
    {

    }

    public void desassociar(GabineteSeguranca gabineteSeguranca)
    {

    }

    public void atribuir(Horario horarioAtendimento)
    {

    }

    public void remover(Horario horarioAtendimento)
    {

    }

    public void adicionar(Horario horarioAtendimento) {
    }

    public void remover(Horario horarioAtendimento) {
    }

    public void abrirGabinete() {
    }
    public void fecharGabinete() {
    }
}
