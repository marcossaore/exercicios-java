import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        int contador = 0;
        //enquanto condição: faça
        while (contador <= 10) {
            System.out.println("O contador é " + contador);  
            contador = contador + 1;
        }

        Scanner scanner = new Scanner(System.in);

        Boolean usuarioFinalizou = false;

        while (usuarioFinalizou == false) {
            System.out.println("Deseja encerrar o sistema?"); 
            System.out.println("[0]Não [1]Sim"); 
            int resposta = scanner.nextInt();
            if (resposta != 0 && resposta != 1) {
                System.out.println("Digite uma resposta válida!"); 
            }else {
                if (resposta == 0) {
                    usuarioFinalizou = false;
                }else {
                    usuarioFinalizou = true;
                    System.out.println("Sistema finalizado!"); 
                }
            }
        }

        for (int inc = 0; inc < 10; inc++) {
            System.out.println("O contador é " + inc);  
        }
    }
}
