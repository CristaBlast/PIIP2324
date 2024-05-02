package modelo;

import java.util.LinkedList;

public interface RepositorioDeAulas {
    LinkedList<Aula> getAulas();
    LinkedList<Aula> getAulas(Horario horario);
    void adicionar(Aula aula);
    void remover(Aula aula);
    void associar(Aula aula);
    void desassociar(Aula aula);
}
