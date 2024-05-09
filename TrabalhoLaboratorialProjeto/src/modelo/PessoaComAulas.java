package modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioDeAulas{
    private GestorDeAulas gestorDeAulas;

    public PessoaComAulas(String nome, long numero) {
        super(nome, numero);
        gestorDeAulas = new GestorDeAulas(this);
    }

    public LinkedList<Aula> getAulas() {
        return gestorDeAulas.getAulas();
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        return gestorDeAulas.getAulas(horario);
    }

    public void preencherSumario(Aula aula) {
        if (aula == null || !gestorDeAulas.getAulas().contains(aula)) {
            return;
        }
        escreverSumario(aula);
    }

    protected abstract void escreverSumario(Aula aula);

    public void adicionar(Aula aula)
    {
        gestorDeAulas.adicionar(aula);
    }

    public void remover(Aula aula)
    {
        gestorDeAulas.remover(aula);
    }


}
