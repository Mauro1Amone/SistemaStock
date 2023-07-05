package sistemastock3;

//Classe Produto 

import java.util.ArrayList;
import java.util.List;

class Produto {


    //Variaveis ou atributos da classe produto
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Getters e setters para nome, preco e quantidade
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
       private List<Produto> produtos;

       
    public Produto() {
        //Inicialização de um arraylist
        produtos = new ArrayList<>();
    }
    
    
 
    //Metódo para Editar um registrar   
 public  void registarProduto(String nome, double preco, int quantidade) {
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
   public  void editarProduto(int numeroProduto, String nome, double preco, int quantidade) {
        //verifica se o numero do produto e menor que zero e se o numero do produto e maior que a lista
        if (numeroProduto < 0 || numeroProduto >= produtos.size()) {
            System.out.println("Número de produto invalido!");
            return;
        }
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

 
 
 
}
