package exercicio_funcionario;
import java.util.Scanner;
import exercicio_funcionario.fachada.FachadaFuncionario;

public final class Menu {

    private static Scanner scanner = null;

    public static void exibirOpcoes() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("1 - Mostrar Funcionários | 2 - Cadastrar Funcionário | 3 Editar Funcionário | 4 - Excluir Funcionário | 5 - Sair");
        System.out.println("----------------------------------------------------------------------------------------------------------------"); 
    }

    public static void capturarOpcaoUsuario() {
        scanner = new Scanner(System.in);
        int opcao = 0;
        try {
            opcao = Integer.parseInt(scanner.nextLine());
            Menu.chamarOpcao(opcao);
            scanner.close();
        } catch (Exception e) {
            scanner.close();
            Menu.limparTela();
            System.out.println(e.getMessage());
            Menu.exibirOpcoes();
            Menu.capturarOpcaoUsuario();
        }
    }

    private static void chamarOpcao(int option) {
        FachadaFuncionario fachadaFuncionario = FachadaFuncionario.obterInstancia();
        switch (option) {
            case 1:
                Menu.limparTela();
                Menu.exibirOpcoes();
                fachadaFuncionario.mostrarFuncionarios();
                Menu.capturarOpcaoUsuario();
                break;
            case 2:
                Menu.limparTela();
                Menu.exibirOpcoes();
                fachadaFuncionario.cadastrarFuncionario();
                Menu.capturarOpcaoUsuario();
                break;
            case 3:
                Menu.limparTela();
                Menu.exibirOpcoes();
                fachadaFuncionario.editarFuncionario();
                Menu.capturarOpcaoUsuario();
                break;
            case 4:
                Menu.limparTela();
                fachadaFuncionario.excluirFuncionario();
                Menu.capturarOpcaoUsuario();
                break;
            case 5:
                Menu.limparTela();
                System.out.println("Obrigado por utilizar o sistema! Até mais! :)");
                break;
            default:
                Menu.limparTela();
                Menu.exibirOpcoes();
                System.out.println("Opção inválida!");
                Menu.capturarOpcaoUsuario();
                break;
        }
    } 

    private static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
