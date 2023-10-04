package dao;

import java.util.List;

public interface IDao<E>  {
    E buscarPorId(Integer id);

    E adicionar(E entidade);

    void excluir(Integer id);

    List<E> buscarTipos();


}
