package exercicio_funcionario.servicos;
import java.util.List;
import exercicio_funcionario.fachada.RepositorioFuncionario;

public class FabricaFuncionario {

    private static RepositorioFuncionario repositorioFuncionario = new RepositorioFuncionario();

    public static List<String> obterTodos() {
        return repositorioFuncionario.obterTodos();
    }

    public static List<String> obterPorCodigo(String codigo) {
        return repositorioFuncionario.obterPorCodigo(codigo);
    }

    public static Boolean cadastrar(String dados) {
        return repositorioFuncionario.cadastrar(dados);
    }

    public static Boolean editar(String codigo, String dados) {
        return repositorioFuncionario.editar(codigo, dados);
    }

    public static Boolean excluir(String codigo) {
        return repositorioFuncionario.excluir(codigo);
    }

}