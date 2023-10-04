package model;

public class Medicamento {
    private Integer id;
    private String nome;
    private TipoLaboratorio laboratorio;
    private Integer quantidade;
    private Float preco;

    public Medicamento(Integer id,
                       String nome,
                       TipoLaboratorio laboratorio,
                       Integer quantidade,
                       Float preco) {
        this.id = id;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Medicamento() {
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

    public TipoLaboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(TipoLaboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", laboratorio=" + laboratorio +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
