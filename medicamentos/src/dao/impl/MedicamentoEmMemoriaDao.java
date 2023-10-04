package dao.impl;

import dao.IDao;
import model.Medicamento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentoEmMemoriaDao implements IDao<Medicamento> {
    private static final Logger log = Logger.getLogger(MedicamentoEmMemoriaDao.class);
    private final Map<Integer, Medicamento> medicamentosEmMemoria = new HashMap<>();

    @Override
    public Medicamento buscarPorId(Integer id) {
        log.info("[em_memoria]: buscando medicamento por id: " + id);
        return medicamentosEmMemoria.get(id);
    }

    @Override
    public Medicamento criar(Medicamento entidade) {
        log.info("[em_memoria]: criando medicamento: " + entidade);
        medicamentosEmMemoria.put(entidade.getId(), entidade);
        return entidade;
    }

    @Override
    public void exclui(Integer id) {
        log.info("[em_memoria]: excluindo medicamento por id: " + id);
        medicamentosEmMemoria.remove(id);
    }

    @Override
    public List<Medicamento> buscarTodos() {
        log.info("[em_memoria]: buscando todos os medicamento!");
        return medicamentosEmMemoria.values().stream().toList();
    }
}
