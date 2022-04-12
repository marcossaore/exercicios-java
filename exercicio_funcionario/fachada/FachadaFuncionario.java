package exercicio_funcionario.fachada;
import java.util.List;
import java.util.Scanner;
import exercicio_funcionario.servicos.FabricaFuncionario;

public class FachadaFuncionario {

    private static FachadaFuncionario instancia = null;

    public static FachadaFuncionario obterInstancia() {
        if (instancia == null) {
            instancia = new FachadaFuncionario();
        }
        return instancia;
    }

    public void mostrarFuncionarios () {
        List<String> funcionarios = FabricaFuncionario.obterTodos();
        if (funcionarios == null) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Funcionários:");
            for (String funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        }
    }

    public void cadastrarFuncionario () {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário:");
        String nome = entrada.nextLine();
        Character turno = validarTurno(entrada);
        Character cargo = validarCargo(entrada);
        Boolean foiCadastrado = FabricaFuncionario.cadastrar(nome + "," + turno + "," + cargo);
        System.out.println(foiCadastrado ? "Funcionário cadastrado com sucesso." : "Erro ao cadastrar funcionário.");
    }

    public void editarFuncionario () {
        Scanner entrada = new Scanner(System.in);
        String codigo = validarCodigo(entrada);

        try {
            List<String> funcionarioEncontrado = FabricaFuncionario.obterPorCodigo(String.valueOf(codigo));
            if (funcionarioEncontrado == null) {
                throw new Exception("Funcionário não encontrado.");
            }
            System.out.println("Digite o nome do funcionário:");
            String nome = entrada.nextLine();
            Character turno = validarTurno(entrada);
            Character cargo = validarCargo(entrada);
            Boolean foiEditado = FabricaFuncionario.editar(codigo,nome + "," + turno + "," + cargo);
            System.out.println(foiEditado ? "Funcionário editado com sucesso." : "Erro ao editar funcionário.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluirFuncionario() {
        Scanner entrada = new Scanner(System.in);
        String codigo = validarCodigo(entrada);
        Boolean foiExcluido = FabricaFuncionario.excluir(codigo);
        System.out.println(foiExcluido ? "Funcionário excluído com sucesso." : "Funcionário não encontrado.");
    }

    private String validarCodigo (Scanner entrada) {
        System.out.println("Digite o código do funcionário (Apenas números)");
        String codigo = null;
        try {
            codigo = entrada.nextLine();
            while (Integer.parseInt(codigo) <= 0) {
                limparTela();
                System.out.println("Digite o código do funcionário corretamente! (Ex:. 1)");
                codigo = entrada.nextLine();
            }
        } catch (Exception exception) {
            validarCodigo(entrada);
        }
        return codigo;
    }

    private Character validarTurno (Scanner entrada) {
        System.out.println("Digite o turno do funcionário (M - matutino, V - vespertino, N - noturno)");
        Character turno = null;
        try {
            turno = entrada.nextLine().toUpperCase().charAt(0);
            turno = Character.toUpperCase(turno);
            while (turno != 'M' && turno != 'V' && turno != 'N') {
                limparTela();
                System.out.println("Digite o turno do funcionário corretamente! (M - matutino, V - vespertino, N - noturno)");
                turno = Character.toUpperCase(entrada.nextLine().charAt(0));
            }
        } catch (Exception exception) {
            validarTurno(entrada);
        }
        return turno;
    }

    private Character validarCargo (Scanner entrada) {
        System.out.println("Digite o cargo do funcionário (G - Gerente, O - Operador, A - Auxiliar)");
        Character cargo = null;
        try {
            cargo = entrada.nextLine().toUpperCase().charAt(0);
            cargo = Character.toUpperCase(cargo);
            while (cargo != 'G' && cargo != 'O' && cargo != 'A') {
                limparTela();
                System.out.println("Digite o cargo do funcionário corretamente! (G - Gerente, O - Operador, A - Auxiliar)");
                cargo = Character.toUpperCase(entrada.nextLine().charAt(0));
            }
        } catch (Exception exception) {
            validarTurno(entrada);
        }
        return cargo;
    }

    private void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
