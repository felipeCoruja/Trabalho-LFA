/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author felipe
 */
public class Expressao_Regular {
    private String LETRA ="([A-Za-z])";
    private String LETRAS ="(" + LETRA + "*)";
    //-------------------------------------------------------------------------------------
    private String BRANCO ="\\s";
    private String BRANCOS = BRANCO+"*";
    //------------------------------------------------------------------------------------- 
    private String CONDICIONAL = "[<>]?=|\\!=|\\&&|\\||";
    private String OPERADORES =  "[\\+|\\-|\\/|\\*|\\%]";
    private String CARACTERES_ESPECIAIS = "\\(|\\)|\\.|\\[|\\]|\\_";
    //-------------------------------------------------------------------------------------
    private String DIGITO ="([0-9])";
    private String DIGITOS = "("+DIGITO +"*)";
    private String INTEIRO="((-?|\\+?)" + DIGITOS + ")";        
    private String FRACAO = "(" + DIGITOS + "/" + DIGITOS + ")";
    private String DECIMAL = "(\\.|\\," + DIGITOS + ")";
    private String EXPONENCIAL = "(E\\^" + INTEIRO + ")";
    private String RAIZ = "(" + DIGITOS + "\\^" + FRACAO + ")";
    private String RAIZQ = "(√" + DIGITOS + ")";
    private String POTENCIA = "(" + DIGITOS + "\\^" + DIGITOS + ")";
    private String REAL = "(" + DIGITOS + "|" + INTEIRO + "|" + FRACAO + "|" + DECIMAL + "|" + RAIZ + "|" + RAIZQ + ")";
    //-------------------------------------------------------------------------------------
    private String TIPO = "(int|float|char|void|double|bolean|String)";
    private String ESTRUTURA = "(if|else|else if|elseif|for|while|do)*";
    
    private String VARIAVEL = "(((" + LETRAS + DIGITOS + ")*)|(" + LETRAS + CARACTERES_ESPECIAIS + LETRAS + ")|(" + CARACTERES_ESPECIAIS + LETRAS + ")|(" + LETRAS + ")|(" + "(" + CARACTERES_ESPECIAIS + "("+ LETRAS + DIGITOS + ")*)))";
   //------------------------------------------------------------------------------------- 
    private String VETOR = "(" + VARIAVEL + "\\[" + VARIAVEL + "\\]" + ")";
    private String VETORCOMP = "(" + VETOR + "((" + "\\." + VARIAVEL + "|" + VETOR + ")*))";
    private String PARAMETRO ="("+TIPO+BRANCOS+VARIAVEL+")";
    //-------------------------------------------------------------------------------------
    private String DIA = "((0*[1-9])" + "|([1|2](" + DIGITO + "))" + "|(30|31))"; 
    private String MES = "(0*[1-9]|10|11|12)";
    private String ANO = "(" + DIGITO + DIGITO + DIGITO + DIGITO + ")";
    private String VIRGULA=",";
    //-------------------------------------------------------------------------------------
    private String EXPRESSAO_BINARIO_POSITIVO = "(1)?(0*)(1)+";
    private String EXPRESSAO_BINARIO_NEGATIVO ="(-1)?(0*)1*(0)+";
    private String EXPRESSAO_PARAMETROS = PARAMETRO+VIRGULA+PARAMETRO;        
    private String EXPRESSAO_ASSINATURA = TIPO+ BRANCOS + VARIAVEL + BRANCOS +"\\("+((PARAMETRO)+(",*"+ PARAMETRO))+"\\)";
    private String EXPRESSAO_CONDICOES =ESTRUTURA + VARIAVEL + CONDICIONAL + VARIAVEL;
    private String EXPRESSAO_OPERACAO = VARIAVEL+ OPERADORES + VARIAVEL;
    private String EXPRESSAO_DATA = "(" + DIA + "/" + MES + "/" + ANO + ")";
      
    private Map<String, String> EXPRESSAO_REG = new HashMap<>();
    
    public Expressao_Regular() {
        EXPRESSAO_REG = new HashMap<>();
        EXPRESSAO_REG.put("Assinatura", EXPRESSAO_ASSINATURA);
        EXPRESSAO_REG.put("Parametro", EXPRESSAO_PARAMETROS);
        EXPRESSAO_REG.put("Condicao", EXPRESSAO_CONDICOES);
        EXPRESSAO_REG.put("Operacao", EXPRESSAO_OPERACAO);        
        EXPRESSAO_REG.put("BinarioPositivo", EXPRESSAO_BINARIO_POSITIVO);
        EXPRESSAO_REG.put("BinarioNegativo", EXPRESSAO_BINARIO_NEGATIVO);
        EXPRESSAO_REG.put("Data",  EXPRESSAO_DATA);
    }  
    
    private void confere(String expressao, String sentenca){
        if(sentenca.isEmpty()){
            System.err.println("Sentença está vazia.\n");
        }else if (sentenca.matches(expressao)){
            System.out.println("A palavra foi aceita!\n");
        }else{
            System.err.println("A palavra foi rejeitada!\n");
        }
    }  
    
     public void preencher(String tipo){
        System.out.println("\nDigite a setença: ");
        Scanner ler = new Scanner(System.in);
        String sentença = ler.nextLine();
        confere(EXPRESSAO_REG.get(tipo),sentença);
    }
    
     
}
