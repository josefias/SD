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
public class AtributosCliente {
        String Name;
        ArrayList<Produto> Lista;
        Cliente dados;
        int tele;

    public AtributosCliente() {
        Name = "";
        Lista = new ArrayList<Produto>();
        dados = new Cliente();
        tele = 0;
    }

    public AtributosCliente(String Name, ArrayList<Produto> Lista, Cliente dados, int tele) {
        this.Name = Name;
        this.Lista = Lista;
        this.dados = dados;
        this.tele = tele;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Produto> getLista() {
        return Lista;
    }

    public void setLista(ArrayList<Produto> Lista) {
        this.Lista = Lista;
    }

    public Cliente getDados() {
        return dados;
    }

    public void setDados(Cliente dados) {
        this.dados = dados;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "AtributosCliente{" + "Name=" + Name + ", tele=" + tele +  "\n dados=" + dados + ", Lista=" + Lista +'}';
    }
public void genClient(){
      Cliente x = new Cliente(); int n;
      Produto p = new Produto();
      System.out.println("===Gerar conta vendedor===");
      System.out.print("Nome :");
      this.setName(ler.umaString());
      System.out.print("Contacto :");
      this.setTele(ler.umInt());
      //dados
      System.out.print("categoria de produtos :");
      x.setCat(ler.umaString());
      System.out.print("IP para futura conection :");
      x.setIp(ler.umaString());
      System.out.print("Port Disponivel :");
      x.setPort(ler.umInt());
      this.setDados(x);
      System.out.println("dejeja inserir os produtos disponiveies na loja\n"
                       + "(1-sim | 0-nao)");
      n = ler.umInt();
      if(n == 1)
          this.setLista(p.genListaProd());
    }
    public void genClient(String nome,String cat,String ip,String fruta,int tele,int port ,int preco,int stock){
      Cliente x = new Cliente(); int n;
      Produto p = new Produto();
      System.out.println("===Gerar conta vendedor===");
      System.out.print("Nome :");
      this.setName(nome);
      System.out.print("Contacto :");
      this.setTele(tele);
      //dados
      System.out.print("categoria de produtos :");
      x.setCat(cat);
      System.out.print("IP para futura conection :");
      x.setIp(ip);
      System.out.print("Port Disponivel :");
      x.setPort(port);
      this.setDados(x);
      System.out.println("dejeja inserir os produtos disponiveies na loja\n"
                       + "(1-sim | 0-nao)");
      n = ler.umInt();
      if(n == 1)
          this.setLista(p.genListaProd());
    }      
}
