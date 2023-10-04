public class GerenciadorTecnico extends Gerenciador {
    @Override
    public void verificar(Email email) {
        boolean eTecnico = "Tecnico".equals(email.getAssunto());
        boolean emailDestinoETecnico = "tecnico@colmeia.com".equals(email.getDestino());

        if (eTecnico || emailDestinoETecnico) {
            System.out.println("Olá, estou enviando esse email para o time de TI (Tecnico)");
        } else {
            this.gerenciadorSeguinte.verificar(email);
        }
    }
}

