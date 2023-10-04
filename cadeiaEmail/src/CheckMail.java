public class CheckMail {


        Gerenciador gerenciador;

        public CheckMail() {
            gerenciador = new GerenciadorGerencia();
            Gerenciador comercial = new GerenciadorComercial();
            Gerenciador tecnico = new GerenciadorTecnico();
            Gerenciador spam = new GerenciadorSpam();

            gerenciador.setGerenciadorSeguinte(comercial);
            comercial.setGerenciadorSeguinte(tecnico);
            tecnico.setGerenciadorSeguinte(spam);

        }

        public void verificar(Email mail) {
            gerenciador.verificar(mail);
        }
    }


