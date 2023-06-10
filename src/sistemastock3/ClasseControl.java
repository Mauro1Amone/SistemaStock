package sistemastock3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClasseControl {

    //Declaração de uma Lista 
    private List<Produto> produtos;

    public ClasseControl() {
        //Inicialização de um arraylist
        produtos = new ArrayList<>();
    }

    //Metódo para registar um produto
    public void registarProduto(String nome, double preco, int quantidade) {
        //verifica se tudo vem da forma correcta
        try {
            Produto produto = new Produto(nome, preco, quantidade);
            produtos.add(produto);
            System.out.println("Produto registrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao registrar o produto: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao registrar o produto.");
        }
    }

    //Metódo para Editar um produto
    public void editarProduto(int numeroProduto, String nome, double preco, int quantidade) {
        //verifica se o numero do produto e menor que zero e se o numero do produto e maior que a lista
        if (numeroProduto < 0 || numeroProduto >= produtos.size()) {
            System.out.println("Número de produto invalido!");
            return;
        }

        //Recebe os novos valores
        Produto produto = produtos.get(numeroProduto);
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        System.out.println("Produto editado com sucesso!");
    }

    //Metódo para Remover um produto
    public void removerProduto(int numeroProduto) {
        if (numeroProduto < 0 || numeroProduto >= produtos.size()) {
            System.out.println("Número de produto invalido!");
            return;
        }

        Produto produto = produtos.get(numeroProduto);
        produtos.remove(produto);
        System.out.println("Produto removido com sucesso!");
    }

    //Metódo para Mostrar todos os produtos 
    public void MostrarStock() {
        System.out.println("Stock Actual:");
        //Loop para imprimir os produtos
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println("Produto n:" + i );
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("------------------------");
        }
    }

    //Metódo para Registar uma venda     
    public void registarVenda(int numeroProduto, int quantidadeVendida) {
        if (numeroProduto < 0 || numeroProduto >= produtos.size()) {
            System.out.println("Número de produto inválido!!");
            return;
        }

        Produto produto = produtos.get(numeroProduto);
        int quantidadeActual = produto.getQuantidade();

        //Verifica se a quantidade actual e menor que quantidade que se quer vender
        if (quantidadeActual < quantidadeVendida) {
            System.out.println("Stock insuficiente!");
            return;
        }

        //recebe a nova quantidade 
        produto.setQuantidade(quantidadeActual - quantidadeVendida);
        System.out.println("Venda registada com sucesso!");
    }

    public static void main(String[] args) {

        //Parte onde será inicializado o programa.
        exibirMenu();//metódo que exibe o menu do programa
    }

    //Metódo para exibir o as opções do menu
    public static void exibirMenu() {

        //Essa variavel define se queremos continuar a execução do programa   
        boolean executando = true;
        ClasseControl ClasseControl = new ClasseControl();
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
                        ClasseControl.registarProduto(nome, preco, quantidade);
                        break;
                    }
                    case 2: {

                        ClasseControl.MostrarStock();//Este metodo vai exibir todos os produtos
                        System.out.print("Digite o número do produto para editar: ");
                        int numeroProduto = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite o novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Digite o novo preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());
                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = Integer.parseInt(scanner.nextLine());
                        //Vai passar por parametros os novos valores para o metodo editarProduto
                        ClasseControl.editarProduto(numeroProduto, novoNome, preco, novaQuantidade);
                        break;
                    }
                    case 3: {
                        //Meodo para remover um produto
                        ClasseControl.MostrarStock();
                        System.out.print("Digite o número do produto para remover: ");
                        int numeroProduto = Integer.parseInt(scanner.nextLine());
                        ClasseControl.removerProduto(numeroProduto);
                        break;
                    }
                    case 4:
                        ClasseControl.MostrarStock();//exibe os produtos
                        break;
                    case 5: {
                        ClasseControl.MostrarStock();//Exibe todos os produtos
                        System.out.print("Digite o número do produto: ");
                        int numeroProduto = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite a quantidade a vender: ");
                        int quantidadeVenda = Integer.parseInt(scanner.nextLine());
                        ClasseControl.registarVenda(numeroProduto, quantidadeVenda);
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
}
