/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author felipe
 */
public class Estado {



    private String nome;
    private String destinoEntrada1;
    private String destinoEntrada2;
    private boolean isFinal;
    private boolean empilha;
    private boolean desempilha;
  
    
    public Estado(){
        this.nome = "-";
        this.destinoEntrada1 = "a";
        this.destinoEntrada2 = "b";
        this.isFinal = false;
        this.empilha = false;
        this.desempilha = false;
    }
    
    public void preencher(String dadosCSV){
        
        String[] vet = dadosCSV.split(";");
        this.nome = vet[0];
        this.destinoEntrada1 = vet[1];
        this.destinoEntrada2 = vet[2];
        
        if(vet[3].equals("s")){
            this.setIsFinal(true);
        }else{
            this.setIsFinal(false);
        }
        
        if(vet[4].equals("X")){
            this.desempilha = true;
        }
        
        if(vet[5].equals("X")){
            this.empilha = true;
        }
        
    }
    
    public void imprimirEstado(){
        System.out.println("--------ESTADO ONDE PAROU-----------------");
        System.out.println(this.nome);
        System.out.println(this.destinoEntrada1);
        System.out.println(this.destinoEntrada2);
        System.out.println("É final? "+this.isIsFinal());
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the entrada1
     */
    public String getDestinoEntrada1() {
        return destinoEntrada1;
    }

    /**
     * @param entrada1 the entrada1 to set
     */
    public void setDestinoEntrada1(String entrada1) {
        this.destinoEntrada1 = entrada1;
    }

    /**
     * @return the entrada2
     */
    public String getDestinoEntrada2() {
        return destinoEntrada2;
    }

    /**
     * @param entrada2 the entrada2 to set
     */
    public void setDestinoEntrada2(String entrada2) {
        this.destinoEntrada2 = entrada2;
    }

    /**
     * @return the isFinal
     */
    public boolean isIsFinal() {
        return isFinal;
    }

    /**
     * @param isFinal the isFinal to set
     */
    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

        /**
     * @return the empilha
     */
    public boolean isEmpilha() {
        return empilha;
    }

    /**
     * @param empilha the empilha to set
     */
    public void setEmpilha(boolean empilha) {
        this.empilha = empilha;
    }

    /**
     * @return the desempilha
     */
    public boolean isDesempilha() {
        return desempilha;
    }

    /**
     * @param desempilha the desempilha to set
     */
    public void setDesempilha(boolean desempilha) {
        this.desempilha = desempilha;
    }
}
