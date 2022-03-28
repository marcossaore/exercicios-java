import java.io.IOException;
import org.biblioteca.buscacep.BuscaCep;

public class RunCep {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cep = "11111111";
        BuscaCep buscaCep = new BuscaCep();
        String resultado = buscaCep.obter(cep);
        System.out.println(resultado);
    }
}
