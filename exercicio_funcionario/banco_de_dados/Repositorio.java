package exercicio_funcionario.banco_de_dados;
import java.util.List;

public interface Repositorio {
    public List<String> ler();
    public List<String> ler(String termo);
    public boolean escrever(String dados);
    public boolean editar(String codigo, String novosDados);
    public boolean excluir(String codigo);
}
