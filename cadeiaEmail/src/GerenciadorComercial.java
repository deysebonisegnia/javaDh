public class GerenciadorComercial extends Gerenciador {

    @Override
    public void verificar(Email email) {
        boolean eComercial = "Comercial".equals(email.getAssunto());
        boolean emailDestinoEComercial = "comercial@colmeia.com".equals(email.getDestino());

        if (eComercial || emailDestinoEComercial) {
            System.out.println("Olá, estou enviando esse email para comercial");
        } else {
            this.gerenciadorSeguinte.verificar(email);
        }
    }
}
