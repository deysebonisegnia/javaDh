package test;

import dao.IDao;
import dao.impl.MedicamentoEmMemoriaDao;
import dao.impl.MedicamentoH2Dao;
import model.Medicamento;
import model.TipoLaboratorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.MedicamentoService;

import java.util.List;

public class MedicamentoServiceTest {

    private MedicamentoService medicamentoService;

    @BeforeEach
    void setup() {
        IDao<Medicamento> medicamentoDao = new MedicamentoEmMemoriaDao();

        Medicamento medicamento = new Medicamento(1, "Cinegripe", TipoLaboratorio.CIMED, 10, 19.9f);
        medicamentoDao.criar(medicamento);
        Medicamento medicamento1 = new Medicamento(2, "Dipirona", TipoLaboratorio.EMS, 12, 129.9f);
        medicamentoDao.criar(medicamento1);
        Medicamento medicamento2 = new Medicamento(3, "Aspirina", TipoLaboratorio.INSTITUTO_BRASILEIRO, 0, 11.9f);
        medicamentoDao.criar(medicamento2);
        Medicamento medicamento3 = new Medicamento(4, "Claridrim", TipoLaboratorio.CIMED, 30, 10.9f);
        medicamentoDao.criar(medicamento3);

        medicamentoService = new MedicamentoService(medicamentoDao);
    }

    @Test
    void dadoUmaConsultaEmMemoria_quandoChamamosBuscarTodos_entaoRetornarTodosOsMedicamentos(){
        List<Medicamento> medicamentosEncontrados = medicamentoService.buscarTodos();
        Assertions.assertEquals(4, medicamentosEncontrados.size());
    }

    @Test
    void dadoQuatroRegistrosEmMemoria_quandoChamamosAdicionamosUmaRegistro_entaoRetornarCincoRegistros(){
        Medicamento medicamento = new Medicamento(5, "finasterida",
                TipoLaboratorio.INSTITUTO_BRASILEIRO, 2, 190.4f);

        medicamentoService.criarMedicamento(medicamento);

        List<Medicamento> medicamentosEncontrados = medicamentoService.buscarTodos();
        Assertions.assertEquals(5, medicamentosEncontrados.size());
    }

    @Test
    void dadoBancoDeDadosH2_quandoChamamosAdicionamosUmaRegistro_entaoRetornarRegistroCriado(){
        Medicamento medicamento = new Medicamento(5, "finasterida", TipoLaboratorio.INSTITUTO_BRASILEIRO, 2, 190.4f);

        IDao<Medicamento> daoMedicamento = new MedicamentoH2Dao();
        MedicamentoService h2Service = new MedicamentoService(daoMedicamento);
        h2Service.criarMedicamento(medicamento);

        Medicamento medicamentoEncontrado = h2Service.buscarPorId(medicamento.getId());
        Assertions.assertNotNull(medicamentoEncontrado);
    }
}
