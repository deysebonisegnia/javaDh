package dao;

import java.util.List;

public interface IDao<E> {

    E buscarPorId(Integer id);

    E criar(E entidade);

    void exclui(Integer id);

    List<E> buscarTodos();

}
