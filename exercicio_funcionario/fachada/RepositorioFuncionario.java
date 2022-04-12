package exercicio_funcionario.fachada;
import java.util.List;
import exercicio_funcionario.banco_de_dados.BancoDeDados;

public class RepositorioFuncionario{

    private BancoDeDados bancoDeDados = null;

    public RepositorioFuncionario() {
        this.bancoDeDados = new BancoDeDados("funcionarios.csv");
    }

    public List<String> obterTodos() {
        List<String> dados = this.bancoDeDados.ler();
        return dados;
    }

    public List<String> obterPorCodigo(String termo) {
        return this.bancoDeDados.ler(termo);
    }

    public Boolean cadastrar(String dados) {
        return this.bancoDeDados.escrever(dados);
    }

    public Boolean editar(String codigo, String dados) {
        return this.bancoDeDados.editar(codigo, dados);
    }

    public Boolean excluir(String codigo) {
        return this.bancoDeDados.excluir(codigo);
    }
}
