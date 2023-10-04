import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void dadoUmEmailDeGerencia_quandoChamamosProcessar_entaoEnviarAoGestor() {
        String origem = "email@colmeia.com";
        String destino = "tecnologia@colmeia.com";
        String assunto = "Gerencia";

        CheckMail processador = new CheckMail();

        Email email = new Email(destino, origem, assunto);

        processador.verificar(email);

    }

    @Test
    public void dadoUmEmailDeComercial_quandoChamamosProcessar_entaoEnviarAoComercial() {
        String origem = "email@colmeia.com";
        String destino = "comercial@colmeia.com";
        String assunto = "COMERCIAL - UM TITULO QUALQUER";

        CheckMail processador = new CheckMail();

        Email email = new Email(destino, origem, assunto);

        processador.verificar(email);

    }

    @Test
    public void dadoUmEmailDeTecnico_quandoChamamosProcessar_entaoEnviarAoTecnico() {
        String origem = "email@colmeia.com";
        String destino = "tecnico@colmeia.com";
        String assunto = "Tecnico";

        CheckMail processador = new CheckMail();

        Email email = new Email(destino, origem, assunto);

        processador.verificar(email);

    }

    @Test
    public void dadoUmEmailIncorreto_quandoChamamosProcessar_entaoEnviarAoSpam() {
        String origem = "email@colmeia.com";
        String destino = "t3cn1co@colm3i4.com";
        String assunto = "Fique rico ou morra tentando! Ganhe 1000 reais por dia.";

        CheckMail processador = new CheckMail();

        Email email = new Email(destino, origem, assunto);

        processador.verificar(email);

    }

}