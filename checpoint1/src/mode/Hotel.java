package mode;

public class Hotel {
    private Integer id;
    private String nome;
    TipoHotel tipoHotel;
    Endereco endereco;


    public Hotel(Integer id, String nome, TipoHotel tipoHotel, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.tipoHotel = tipoHotel;
        this.endereco = endereco;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoHotel getTipoHotel() {
        return tipoHotel;
    }

    public void setTipoHotel(TipoHotel tipoHotel) {
        this.tipoHotel = tipoHotel;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoHotel=" + tipoHotel +
                '}';
    }
}
