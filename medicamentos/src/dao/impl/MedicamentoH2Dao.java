package dao.impl;

import dao.ConfiguracaoJdbc;
import dao.IDao;
import model.Medicamento;
import model.TipoLaboratorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MedicamentoH2Dao implements IDao<Medicamento> {
    private static final Logger log = Logger.getLogger(MedicamentoH2Dao.class);
    private static final String SQL_BUSCA_POR_ID = "SELECT * FROM Medicamento where id = ?";
    private static final String SQL_CRIACAO = "INSERT INTO Medicamento VALUES(?, ?, ?, ?, ?)";
    private ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();


    @Override,    public Medicamento buscarPorId(Integer id) {
        log.info("[h2]: buscando por id: " + id);
        Connection connection = configuracaoJdbc.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(SQL_BUSCA_POR_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Medicamento medicamento = null;
            while (resultSet.next()) {
                Integer medicamentoId = resultSet.getInt(1);
                String medicamentoNome = resultSet.getString(2);
                TipoLaboratorio laboratorio = TipoLaboratorio.valueOf(resultSet.getString(3));
                Integer quantidade = resultSet.getInt(4);
                Float preco = resultSet.getFloat(5);
                medicamento = new Medicamento(medicamentoId, medicamentoNome, laboratorio, quantidade, preco);
            }
            log.info("[h2]: registro encontrado: " + medicamento);
            return medicamento;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Medicamento criar(Medicamento entidade) {
        log.info("[h2]: criando entidade: " + entidade);
        Connection connection = configuracaoJdbc.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(SQL_CRIACAO)) {
            statement.setInt(1, entidade.getId());
            statement.setString(2, entidade.getNome());
            statement.setString(3, entidade.getLaboratorio().name());
            statement.setInt(4, entidade.getQuantidade());
            statement.setFloat(5, entidade.getPreco());
            statement.execute();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return entidade;
    }

    @Override
    public void exclui(Integer id) {

    }

    @Override
    public List<Medicamento> buscarTodos() {
        return null;
    }
}
