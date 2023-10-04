public class GerenciadorGerencia extends Gerenciador {


    @Override
    public void verificar(Email email) {
        boolean eGerencia = "Gerencia".equals(email.getAssunto()) ;
        boolean emailDestinoEGerencia = "gerencia@colmeia.com".equals(email.getDestino());

        if (eGerencia || emailDestinoEGerencia) {
            System.out.println("Olá, estou enviando esse email para gerencia");
        } else {
            this.gerenciadorSeguinte.verificar(email);
        }
    }

}
