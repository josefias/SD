/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp07;

import java.util.ArrayList;

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
    public ArrayList<Produto> genListaProd(){
        ArrayList<Produto> ret = new ArrayList<Produto>();
        Produto p = new Produto();
        int flag = 1;
        while(true){
            System.out.print("===Produtos===\n"
                             + "Nome :");
            p.setNome(ler.umaString());
            System.out.print("Preço :");
            p.setPreco(ler.umDouble());
            System.out.print("stock :");
            p.setStock(ler.umInt());
            
            ret.add(p);
            System.out.println("adicionar mais produtos?\n(1-sim | 0-nao)");
            flag = ler.umInt();
            if(flag == 0)
                return ret;
        }
    }
    @Override
    public String toString() {
        return "nome=" + nome + "| preco=" + preco + "| stock=" + stock + '|';
    }
    
    
    
}
