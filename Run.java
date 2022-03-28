import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Mustang mustang = new Mustang();
        System.out.println(mustang.velocidade);
        mustang.acelerar();
        mustang.acelerar();
        mustang.acelerar();
        mustang.frear();
        mustang.frear();
        mustang.frear();
        mustang.frear();
    }
}