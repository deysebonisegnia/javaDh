package test;

import dao.IDao;
import dao.impl.HotelEmMenoriaDao;
import mode.Endereco;
import mode.Hotel;
import mode.TipoHotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import servico.HotelServico;

public class HotelServicoTest {
    private HotelServicoTest;


    Endereco endereco1 = new Endereco(01,"benedito cavarlho",55,"Sao Paulo","sp");
    Endereco endereco2 = new Endereco(02,"Raimundo oliveira",375,"Sao Paulo","sp");
    Endereco endereco3 = new Endereco(03,"Sao francisco",200,"Rio de Janeiro","RJ");
    Endereco endereco4 = new Endereco(04,"Joaquim braga",9678,"Uberlandia","MG");
    Endereco endereco5 = new Endereco(05,"Americo ",213,"Rio de Janeiro","RJ");
    private HotelServico hotelServico;

    @BeforeEach
    void setup (){

        IDao<Hotel> hotelDao =new HotelEmMenoriaDao();
        Hotel hotel1 = new Hotel(1,"Transilvania", TipoHotel.cinco_ESTRELAS,endereco1);
        hotelDao.adicionar(hotel1);
        Hotel hotel2 = new Hotel(2,"Salone", TipoHotel.TRES_ESTRELAS,endereco2);
        hotelDao.adicionar(hotel2);
        Hotel hotel3 = new Hotel(3,"Palace", TipoHotel.QUATRO_ESTRELAS,endereco3);
        hotelDao.adicionar(hotel3);
        Hotel hotel4 = new Hotel(4,"Primavera", TipoHotel.UMA_ESTRELAS,endereco4);
        hotelDao.adicionar(hotel4);
        Hotel hotel5 = new Hotel(5,"Ilha do sol", TipoHotel.DUAS_ESTRELAS,endereco5);
        hotelDao.adicionar(hotel5);

        hotelServico = new HotelServico(hotelDao);

    }
    @Test
    void dadoBancoDeDadosH2_quandoChamamosAdicionamosUmaRegistro_entaoRetornarRegistroCriado(){
      Hotel hotel  = new Hotel(6, "fantasia", TipoHotel.cinco_ESTRELAS, endereco4);

        IDao<Hotel> daoHotel = new HotelEmMenoriaDao();
        HotelServico h2Servico = new HotelServico(daoHotel);
        h2Servico.adicionar(hotel);

       Hotel hotelEncontrado = h2Servico.buscarPorId(hotel.getId());
        Assertions.assertNotNull(hotelEncontrado);
    }

}
