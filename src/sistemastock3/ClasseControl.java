 package sistemastock3;


import java.util.Scanner;

public class ClasseControl {

    //Metódo para exibir o as opções do menu
    public static void exibirMenu() {
        
            Produto produto = new Produto();


        //Essa variavel define se queremos continuar a execução do programa   
        boolean executando = true;
       
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================================================================================");
        System.out.println("========================================== Sistema de Gestão de Stock ===========================================");

        while (executando) {
            System.out.println("=================================================================================================================");
            System.out.println("Menu:");
            System.out.println("1. Registar novo produto");
            System.out.println("2. Editar um produto existente");
            System.out.println("3. Remover Produto Existente");
            System.out.println("4. Consultar Stock");
            System.out.println("5. Registar nova venda");
            System.out.println("6. Sair");
            System.out.println("====================================================================================================");
            System.out.print("Digite a sua opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                // usei um switch para poder escolher uma opcao
                switch (opcao) {
                    case 1: {
                        System.out.print("Digite o nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());
                        System.out.print("Digite a quantidade: ");
                        int quantidade = Integer.parseInt(scanner.nextLine());
                        //esse metodo vai receber por parametros o nome,preco e a quantidade. 
                        produto.registarProduto(nome, preco, quantidade);
                        break;
                    }
                    case 2: {

                        produto.MostrarStock();//Este metodo vai exibir todos os produtos
                        System.out.print("Digite o número do produto para editar: ");
                        int numeroProduto = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Digite o novo preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());
                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = Integer.parseInt(scanner.nextLine());
                        //Vai passar por parametros os novos valores para o metodo editarProduto
                        produto.editarProduto(numeroProduto, novoNome, preco, novaQuantidade);
                        break;
                    }
                    case 3: {
                        //Meodo para remover um produto
                        produto.MostrarStock();
                        System.out.print("Digite o número do produto para remover: ");
                        int numeroProduto = Integer.parseInt(scanner.nextLine());
                        produto.removerProduto(numeroProduto);
                        break;
                    }
                    case 4:
                        produto.MostrarStock();//exibe os produtos
                        break;
                    case 5: {
                        produto.MostrarStock();//Exibe todos os produtos
                        System.out.print("Digite o número do produto: ");
                        int numeroProduto = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite a quantidade a vender: ");
                        int quantidadeVenda = Integer.parseInt(scanner.nextLine());
                        produto.registarVenda(numeroProduto, quantidadeVenda);
                        break;
                    }
                    case 6:
                        System.out.println("Fechando o programa...");
                        executando = false;
                        break;
                    default:
                        System.out.println("Escolha Inválida!");
                        break;
                }
                System.out.println("-----------------------------------------------------------------------------");

            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }

        }

        scanner.close();
    }
    
    
    public static void main(String[] args) {

        //Parte onde será inicializado o programa.
        exibirMenu();//metódo que exibe o menu do programa
    }

}
