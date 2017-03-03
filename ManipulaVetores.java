package vetores;

import java.util.Scanner;
/*

Aluno: Daniel Penasio - 266674

 */
public class ManipulaVetores {

    public static void main(String[] args) {

        //Crie um vetor de reais com capacidade para armazenar 50 valores;
        double[] vetorDeReais = new double[50];
        //Crie uma variável (int) para controlar a quantidade de itens 
        //do vetor e a inicialize com zero;
        int quant = 0;
        //Crie uma variável (double) para receber um item;
        double recebeItem;

        /*
        Insira oito itens no vetor usando o método inserirItem
        (não se esqueça de atualizar a variável com a quantidade 
        de itens a cada número inserido);
         */
        System.out.println("========================================");
        System.out.println("Acrescentar 8 itens: ");
        inserirItem(vetorDeReais, 10, quant);
        quant++;
        inserirItem(vetorDeReais, 20, quant);
        quant++;
        inserirItem(vetorDeReais, 30, quant);
        quant++;
        inserirItem(vetorDeReais, 40, quant);
        quant++;
        inserirItem(vetorDeReais, 50, quant);
        quant++;
        inserirItem(vetorDeReais, 60, quant);
        quant++;
        inserirItem(vetorDeReais, 70, quant);
        quant++;
        inserirItem(vetorDeReais, 80, quant);
        quant++;

        //Mostre todos os itens do vetor usando o método mostrarVetor;
        System.out.println("Mostrando valores após inserir 8 itens.");
        mostrar(vetorDeReais, quant);

        /*Leia um número digitado no teclado (use a classe Scanner) e insira 
        no vetor usando o método inserirItem (não esqueça de somar um à 
        variável quantidade se o método inserirItem retornar true);
         */
        System.out.println("========================================");
        System.out.println("Digite um número a ser inserido...");
        Scanner entrada = new Scanner(System.in);
        recebeItem = entrada.nextDouble();
        inserirItem(vetorDeReais, recebeItem, quant);
        quant++;

        /*
        Mostre todos os itens do vetor usando o método mostrarVetor;
         */
        System.out.println("========================================");
        System.out.println("Mostrando valores após inserir item pelo Scanner.");
        mostrar(vetorDeReais, quant);

        /*
        Leia um número digitado no teclado e procure esse número no vetor 
        usando o método procurarItem. Se o número for encontrado mostre a 
        sua posição e se não for encontrado mostre uma mensagem informando.
         */
        System.out.println("========================================");
        System.out.println("Digite um valor a ser procurado.");
        Scanner procurar = new Scanner(System.in);
        double itemProcurado = procurar.nextDouble();
        int posicao = procuraItem(vetorDeReais, itemProcurado, quant);
        if (posicao != -1) {
            System.out.println("Item " + itemProcurado + " está na posição " + posicao);
        } else {
            System.out.println("Item " + itemProcurado + " não está na lista");
        }

        /*
        Leia um número digitado no teclado e remova esse item usando 
        o método removerItem (não se esqueça de diminuir um da variável 
        quantidade se o item for removido);
         */
        System.out.println("========================================");
        System.out.println("Digite um valor a ser removido.");
        Scanner deletar = new Scanner(System.in);
        double itemDeletado = procurar.nextDouble();
        boolean removido = removerItem(vetorDeReais, itemDeletado, quant);
        if (removido) {
            quant--;
            System.out.println("Removido com sucsso");
        } else {
            System.out.println("Item não encontrado");
        }

        /*
        Mostre todos os itens do vetor usando o método mostrarVetor
         */
        System.out.println("========================================");
        System.out.println("Lista após remoção do item");
        mostrar(vetorDeReais, quant);
    }

    /*
    1. Crie o método inserirItem que recebe como parâmetro o vetor, 
    o número real a ser inserido e a quantidade de itens do vetor. 
    O método deve inserir esse número real na posição seguinte ao 
    último item e retornar true. Caso não seja possível inserir 
    porque o vetor está cheio, deve retornar false.
     */
    public static boolean inserirItem(double[] vetor, double valor, int qtdArmazenados) {
        if (qtdArmazenados < vetor.length) {
            vetor[qtdArmazenados] = valor;
            qtdArmazenados++;
            return true;
        }
        return false;
    }

    /*
    2. Crie o método mostrarVetor que recebe como parâmetro o vetor e a quantidade
    de itens. O método deve mostrar os itens do vetor separados por um espaço.
     */
    public static void mostrar(double[] vetor, int qtdArmazenados) {
        for (int i = 0; i < qtdArmazenados; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    /*
    3. Crie o método procurarItem que recebe como parâmetro o vetor, o número
    real a ser procurado e a quantidade de itens do vetor. O método deve 
    percorrer o vetor procurando o número e retornar seu índice quando 
    encontrá-lo. Caso o número não seja encontrado, deve retornar -1.
     */
    public static int procuraItem(double[] vetor, double procurado, int qtdArmazenados) {
        for (int i = 0; i < qtdArmazenados; i++) {
            if (vetor[i] == procurado) {
                return i;
            }
        }
        return -1;
    }

    /*
    4.Crie o método removerItem que recebe como parâmetro o vetor, um número 
    real a ser removido e a quantidade de itens do vetor. O método deve 
    procurar o item usando o método procurarItem e, se encontrado, deve ser 
    removido e todos os itens das posições seguintes devem ser movidos para 
    que a posição do item removido não fique vazia. Caso o item seja removido 
    retornar true, caso não seja encontrado retornar false.
     */
    public static boolean removerItem(double[] vetor, double valor, int qtdArmazenados) {
        int posicao = procuraItem(vetor, valor, qtdArmazenados);
        if (posicao != -1) {
            for (int i = posicao; i < qtdArmazenados - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            qtdArmazenados--;
            return true;
        }
        return false;
    }

}
