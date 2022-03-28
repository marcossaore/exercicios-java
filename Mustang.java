public class Mustang {

    /*
    public, private e protected são modificadores de acesso.
    https://medium.com/trainingcenter/modificadores-de-acesso-3f87133611c8#:~:text=Modificadores%20de%20acesso%20s%C3%A3o%20palavras,aos%20atributos%2C%20m%C3%A9todos%20e%20classes.&text=%C3%89%20o%20modificador%20de%20acesso,pela%20classe%20que%20os%20declara.
    */
    public int velocidade = 0;

    public void acelerar() {
        this.velocidade = this.velocidade + 50;
        System.out.printf("Acelerando a %d km/h...\n", this.velocidade);
    }

    /**
     * void: não possui retorno.
     */
    public void frear() {
        this.velocidade = this.velocidade - 50;
        System.out.printf("Acelerando a %d km/h...\n", this.velocidade);
    }
}