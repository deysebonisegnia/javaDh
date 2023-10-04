package servico;

import dao.IDao;
import mode.Hotel;

import java.util.List;

public class HotelServico {
    private final IDao<Hotel> daoHotel;

    public HotelServico(IDao<Hotel> daoHotel) {
        this.daoHotel = daoHotel;
    }

    public Hotel buscarPorId(Integer id) {
        return daoHotel.buscarPorId(id);
    }

    public Hotel adicionar(Hotel entidade) {
        return daoHotel.adicionar(entidade);
    }

    public void excluir(Integer id) {
        daoHotel.excluir(id);
    }

    public List<Hotel> buscarTipos() {
        return daoHotel.buscarTipos();
    }
}






