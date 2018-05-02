/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp07;

/**
 *
 * @author Utilizador
 */
public class Produto {
    public static int id = 0;
    public String nome;
    public double preco;
    public int stock;

    public Produto() {
        id++;
        nome = "";
        preco = 0.0;
        stock = 0;
    }

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public static int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", preco=" + preco + ", stock=" + stock + '}';
    }
    
    
    
}
