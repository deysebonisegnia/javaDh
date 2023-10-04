package service;

import dao.IDao;
import model.Medicamento;

import java.util.List;

public class MedicamentoService {
    private final IDao<Medicamento> daoMedicamento;

    public MedicamentoService(IDao<Medicamento> daoMedicamento) {
        this.daoMedicamento = daoMedicamento;
    }

    public Medicamento criarMedicamento(Medicamento medicamento) {
        //todo: validações que checam até se o medicamento é comercializado no brasil, anvisa
        return daoMedicamento.criar(medicamento);
    }

    public void excluirMedicamento(Integer id) {
        daoMedicamento.exclui(id);
    }

    public List<Medicamento> buscarTodos() {
        return daoMedicamento.buscarTodos();
    }

    public Medicamento buscarPorId(Integer id) {
        return daoMedicamento.buscarPorId(id);
    }
}
