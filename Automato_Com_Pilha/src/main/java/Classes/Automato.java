/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author felipe
 */
public class Automato {
    private List<Estado> listEstados;
    private int indiceEstadoAtual;
    private String caminhoArquivo;
    private List<String> pilha;
    
    public Automato(){
        this.listEstados = new ArrayList<>();
        this.indiceEstadoAtual = -1;
        this.caminhoArquivo = "C:\\Users\\felipe\\Documents\\NetBeansProjects\\Automato_Com_Pilha\\src\\main\\java\\CSV\\transicoes.csv";
        this.pilha = new ArrayList<>();
    }
    
    
    public void loadTransicoes() throws FileNotFoundException, IOException{
        FileReader f = new FileReader(this.caminhoArquivo);
        Scanner arquivoLido = new Scanner(f);
        arquivoLido.useDelimiter("\n");
        
        String linhaLida =arquivoLido.nextLine();//pulando o cabeçalho
        
        while (arquivoLido.hasNext()) {
            Estado e = new Estado();
            e.preencher(arquivoLido.nextLine());
            this.listEstados.add(e);
        }
        f.close();
    }
    
    
    public void run(){
        System.out.println("Informe a palavra a ser consumida");
        Scanner Scanner = new Scanner(System.in);
        String palavra = Scanner.nextLine();
        this.indiceEstadoAtual = 0;
        char[] palavraAux = palavra.toCharArray();
        
        Estado estadoAux = new Estado();
        int j = 0;//contador da letra da palavra
        String destino = "-";
        
        //consumindo a palavra e avançando para os estados
        for(int i=0;i<palavra.length();i++){
            estadoAux = listEstados.get(indiceEstadoAtual);
           
            if(palavraAux[j] == 'a'){
                System.out.println("Leu a letra 'a' ");
                destino = estadoAux.getDestinoEntrada1();
                System.out.println("Foi para "+destino);
            }else if(palavraAux[j] == 'b'){
                System.out.println("Leu a letra 'b' ");
                destino = estadoAux.getDestinoEntrada2();
                System.out.println("Foi para "+destino);
            }
            
            //MODIFICANDO A PILHA
            if(estadoAux.isEmpilha()){
                this.pilha.add("X");//adiciona a pilha
                System.out.println("Empilhou X");
            }
            if(this.pilha.size()>0){
                if(estadoAux.isDesempilha()){
                    this.pilha.remove(this.pilha.size()-1);//remove o ultimo da pilha
                    System.out.println("Desempilhou X");
                }
            }
            
            
            
            //percorrendo a lista de estados atras do destino
            for(int k=0;k<this.listEstados.size();k++){
                if(this.listEstados.get(k).getNome().equals(destino)){
                    this.indiceEstadoAtual = k;
                    
                }
            }
           
            //j é o contador do indice da palavra, ex: 'aabbab'
            if(j<palavraAux.length){
                j++;// significa que a letra foi lida, avançando para a proxima
                
            }
            
            
           
        }
        
        estadoAux = this.listEstados.get(indiceEstadoAtual);
        
        if(estadoAux.isIsFinal() == true){
            if(this.pilha.size() == 0){
                System.out.println("A palavra foi aceita");
            }else{
                System.out.println("Parou em um estado final mas a pilha ainda tem "+this.pilha.size()+" itens");
            }
            
        }else{
            System.out.println("A palavra foi regeitada");
        }
        
        estadoAux.imprimirEstado();
    }

    /**
     * @return the pilha
     */
    public List<String> getPilha() {
        return pilha;
    }

    /**
     * @param pilha the pilha to set
     */
    public void setPilha(List<String> pilha) {
        this.pilha = pilha;
    }
}
