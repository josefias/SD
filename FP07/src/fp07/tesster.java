<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp07;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilizador
 */
public class tesster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int x=0; 
    String dat = ".dat", file ="";
     AtributosCliente cli = new AtributosCliente();
     String  nome = "jony", cat = "orticulas", ip = "127.0.0.5", fruta = "girimum"; 
     int tele = 1234, port = 2222 ,preco = 12, stock = 100;    
        
     String Path = "C:\\Users\\Utilizador\\Desktop\\tudo\\UBI\\poo\\FP07\\src\\fp07\\Cliente\\";
    
     
     System.out.println("Qual é o teu Nome?");
     file = ler.umaString();//nome
     String concat = file.concat(dat); //nome.dat
     String concat1 = Path.concat(concat); //C:\\Users\\Utilizador\\Desktop\\tudo\\UBI\\poo\\FP07\\src\\fp07\\nome.dat
     File fc = new File(concat1);
        try {
            fc.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(tesster.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(fc.length()!= 0){
                cli = cli.Ler_Fich(fc);
                System.out.println("o ficheiro tem dados");
            }    
            else{
                cli.genClient(nome, cat ,ip, fruta, tele, port, preco, stock);
                System.out.println("o ficheiro estava vazio");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(tesster.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    System.out.println("agora temos os dados do cliente\n"+cli);
    cli.Guardar_No_FicheiroCli(fc, cli);
}
