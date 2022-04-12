package exercicio_funcionario.banco_de_dados;

import java.util.List;

public class BancoDeDados implements Repositorio {

    private Arquivo arquivo = null;

    public BancoDeDados(String arquivo) {
        this.arquivo = new Arquivo(arquivo);
    }

    public List<String> ler() {
        return this.arquivo.ler();
    }

    public List<String> ler(String termo) {
        return this.arquivo.ler(termo);
    }

    public boolean escrever(String dados) {
        return this.arquivo.escrever(dados);
    }

    public boolean editar(String codigo, String novosDados) {
        return this.arquivo.editar(codigo, novosDados);
    }

    public boolean excluir(String codigo) {
        return this.arquivo.excluir(codigo);
    }
}
