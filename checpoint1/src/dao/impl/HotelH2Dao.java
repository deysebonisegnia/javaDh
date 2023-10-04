package dao.impl;

import dao.ConfiguracaoJdbc;
import dao.IDao;
import mode.Endereco;
import mode.Hotel;
import mode.TipoHotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class HotelH2Dao implements IDao<Hotel> {
    private static final Logger log = Logger.getLogger(HotelH2Dao.class);
    private static final String SQL_BUSCA_POR_ID = "SELECT * FROM Hotel where id = ?";
    private static final String SQL_CRIACAO = "INSERT INTO Hotel VALUES(?, ?, ?, ?, ?)";
    private ConfiguracaoJdbc configuracaoJdbc = new ConfiguracaoJdbc();

    @Override
    public Hotel buscarPorId(Integer id) {
        log.info("[h2]: buscando por id: " + id);
        Connection connection = configuracaoJdbc.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(SQL_BUSCA_POR_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Hotel hotel = null;
            while (resultSet.next()) {
                Integer hotelId = resultSet.getInt(1);
                String hotelNome = resultSet.getString(2);
                tipoHotel = TipoHotel.valueOf(resultSet.getString(3));
                Endereco endereco = resultSet.get(4);

                hotel = new Hotel(hotelId, hotelNome, tipoHotel, endereco);
            }
            log.info("[h2]: registro encontrado: " + hotel);
            return hotel;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }