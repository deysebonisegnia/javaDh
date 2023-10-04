package dao.impl;

import dao.IDao;
import model.Cosmetico;

import java.util.List;

public class CosmeticoEmMemoriaDao implements IDao<Cosmetico> {
    @Override
    public Cosmetico buscarPorId(Integer id) {
        return null;
    }

    @Override
    public Cosmetico criar(Cosmetico entidade) {
        return null;
    }

    @Override
    public void exclui(Integer id) {

    }

    @Override
    public List<Cosmetico> buscarTodos() {
        return null;
    }
}
