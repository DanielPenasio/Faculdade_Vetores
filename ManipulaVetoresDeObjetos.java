package vetoresdeobjetos;

import java.util.Scanner;
/*

Aluno: Daniel Penasio - 266674

 */
public class ManipulaVetoresDeObjetos {

    public static void main(String[] args) {

        // Criar vetor de Funcionários com capacidade de 80 itens.
        Funcionario[] funcionarios = new Funcionario[80];

        Scanner teclado = new Scanner(System.in);
        Scanner linha = new Scanner(System.in);

        // Declaração das suas variáveis e objetos
        int opcao;
        do {

            System.out.println(
                    "Menu:");

            System.out.println(
                    "1) Inserir um funcionário na próxima posição vazia;");
            System.out.println(
                    "2) Procurar um funcionário por matrícula;");
            System.out.println(
                    "3) Procurar um funcionário por nome;");
            System.out.println(
                    "4) Remover um funcionário por matrícula;");
            System.out.println(
                    "5) Alterar o salário de um funcionário por matrícula;");
            System.out.println(
                    "6) Mostrar todos os funcionários;");
            System.out.println(
                    "7) Encontrar o maior salário;");
            System.out.println(
                    "8) Finalizar o programa.");
            System.out.println(
                    "Digite o número da opção desejada:");

            // entrada (Scanner) para opções.
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do funcionário: ");
                    String nome = linha.next();
                    System.out.println("Digite a matrícula do funcionário: ");
                    int matricula = linha.nextInt();
                    System.out.println("Digite o salário do funcionário: ");
                    double salario = linha.nextDouble();
                    inserirFuncionario(funcionarios, nome, matricula, salario);
                    break;
// Inserir um funcionário na próxima posição vazia
                case 2:
                    System.out.println("Digite a matrícula:");
                    matricula = linha.nextInt();
                    System.out.println("Funcionario matrícula número " + matricula
                            + " :" + procurarMatricula(funcionarios, matricula));
                    break;
// Procurar um funcionário por matrícula
                case 3:
                    System.out.println("Digite o nome:");
                    nome = linha.next();
                    System.out.println("Matrícula de " + nome + " = "
                            + procurarNome(funcionarios, nome));
                    break;
// Procurar um funcionário por nome
                case 4:
                    System.out.println("Digite a matrícula:");
                    matricula = linha.nextInt();
                    removerFuncionario(funcionarios, matricula);
                    System.out.println("Funcionario matrícula número " + matricula
                            + " removido: ");
                    break;
// Remover um funcionário por matrícula
                case 5:
                    System.out.println("Digite a matrícula:");
                    matricula = linha.nextInt();
                    System.out.println("Digite o novo salário:");
                    double novoSalario = linha.nextDouble();
                    alterarSalario(funcionarios, matricula, novoSalario);
                    break;
// Alterar o salário de um funcionário por matrícula
                case 6:
                    mostrarVetor(funcionarios);
// Mostrar todos os funcionários
                    break;
                case 7:
                    System.out.println("Maior salário é: "
                            + EncontrarMaiorSalario(funcionarios));
                    break;
// Encontrar o maior salário
                case 8:
                    System.out.println("Fim do Programa");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
            System.out.println();

        }//Fim do 'do'
        while (opcao != 8); // while do 'do'.
        
        teclado.close();
        linha.close();
    } // fim do main

    /* método para pegar quantidade de elementos do vetor, útil para laços for.
    OBS: Poderia ser utlizado o foreach, porém como o vetor não é populado por
    completo, e é um vetor de objetos, as posições não populadas ficam 'null', 
    o que é um problema em determinados métodos. O recurso a evitar isso com o 
    foreach seria uma checagem para não pegar valores 'null'.
     */
    public static int size(Funcionario[] vetFuncionario) {
        // variável para contagem de elementos não null
        int cont = 0;
        while (cont < vetFuncionario.length && vetFuncionario[cont] != null) {
            cont++;
        }
        /*retorna um int que é a quantidade de elementos não null, e com isso
        o índice do próximo elemento a ser preenchido.
        */
        return cont;
    }
    
    /*
    Método para inserir um objeto Funcionário, checando se há espaço no 
    vetor(Array).
    */
    public static boolean inserirFuncionario(Funcionario[] vetFuncionario,
            String nome, int matr, double salario) {
        //Checagem se há espaço no array, utilizando o método size.
        if (size(vetFuncionario) < vetFuncionario.length) {
            // criar novo Funcionário na posição indicada pelo size.
            vetFuncionario[size(vetFuncionario)]
                    = new Funcionario(nome, matr, salario);
            return true;
        } else {
            return false;
        }
    }

    // Método para mostrar todos os objetos do vetor
    public static void mostrarVetor(Funcionario[] vetFuncionario) {
        for (int i = 0; i < size(vetFuncionario); i++) {
            // Printa o Funcionário utilizando o toString sobrescrito.
            System.out.println(vetFuncionario[i]);
        }
    }
    
    //Método para procurar um Funcionário pela matrícula
    public static Funcionario procurarMatricula(Funcionario[] vetFuncionario,
            int matr) {
        // Percorre o array pegando um funcionário em cada volta
        for (int i = 0; i < size(vetFuncionario); i++) {
            // checa se a matrícula do Funcionário da vez é a mesma passada 
            // no argumento
            if (vetFuncionario[i].getMatricula() == matr) {
                // retorna o Funcionário.
                return vetFuncionario[i];
            }
        }
        return null;
    }
    
    //Método para buscar Funcionário pelo nome.
    public static int procurarNome(Funcionario[] vetFuncionario, String nome) {
        // Percorre o array pegando um funcionário em cada volta
        for (int i = 0; i < size(vetFuncionario); i++) {
            // checa se o nome do Funcionário da vez é o mesmo passado
            // no argumento
            if (vetFuncionario[i].getNome().equals(nome)) {
                // retorna a matrícula do Funcionário
                return vetFuncionario[i].getMatricula();
            }
        }
        return -1;
    }

    // Retorna o índíce do objeto no array pela matrícula
    public static int indicePorMatricula(Funcionario[] vetFuncionario, int matr) {
        // variável de controle para pegar o índice
        int indice = 0;
        // Percorre o array até o último elemento não null
        for (int i = 0; i < size(vetFuncionario); i++) {
            // checa se a matrícula do funcionario é a mesma passada no argumento
            if (vetFuncionario[i].getMatricula() == matr) {
                // devolve o índice
                return indice;
            }
            // se não, incrementa a variável de controle
            indice++;
        }
        return -1;
    }

    // Método para remover o funcionário através da matrícula
    public static Funcionario removerFuncionario(Funcionario[] vetFuncionario,
            int matr) {
        // Pega o funcionário da matrícula passada pelo argumento, utilizando
        // o método procurarMatricula, que retorna um objeto.
        Funcionario func = procurarMatricula(vetFuncionario, matr);
        //checa se o Funcionário existe
        if (func != null) {
            // utiliza o métoo inicePorMatricula para pegar o índice do 
            // Funcionário no array
            int posi = indicePorMatricula(vetFuncionario, matr);
            // Percorre o array começando do índice até o último não null
            for (int i = posi; i < size(vetFuncionario) - 1; i++) {
                // desloca os objetos da direita para a esquerda no array, 
                // eliminando o objeto.
                vetFuncionario[i] = vetFuncionario[i + 1];
            }
            // Seta como null a úlmia posição que estava preenchida
            vetFuncionario[size(vetFuncionario) - 1] = null;
            // retorna o fucionário removido
            return func;
        }
        return null;
    }

    // Altera o salário do funcioário
    public static boolean alterarSalario(Funcionario[] vetFuncionario,
            int matr, double novoSal) {
        // Pega o funcionário da matrícula passada pelo argumento, utilizando
        // o método procurarMatricula, que retorna um objeto.
        Funcionario func = procurarMatricula(vetFuncionario, matr);
        //checa se o Funcionário existe
        if (func != null) {
            // seta o novo salário, passado pelo argumento
            func.setSalario(novoSal);
            return true;
        }
        return false;
    }

    // Método para encontrar o maior salário do array
    public static double EncontrarMaiorSalario(Funcionario[] vetFuncionario) {
        // seta como maior salário o do primeiro objeto do array (posição 0).
        double maiorSalario = vetFuncionario[0].getSalario();
        // percorre o array, da posição 1 até o último não null.
        for (int i = 1; i < size(vetFuncionario); i++) {
            // checa se o salário da vez é maior que o maior salário setado.
            if (vetFuncionario[i].getSalario() > maiorSalario) {
                // seta o maior salário como o atual
                maiorSalario = vetFuncionario[i].getSalario();
            }
            // retorna o maior salário
            return maiorSalario;
        }
        return -1;
    }

}