public class Email {
    private String destino;
    private String origem;
    private String assunto;

    public Email(String destino, String origem, String assunto) {
        this.destino = destino;
        this.origem = origem;
        this.assunto = assunto;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
