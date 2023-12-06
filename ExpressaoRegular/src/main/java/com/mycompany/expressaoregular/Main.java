/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.expressaoregular;

import Classes.Expressao_Regular;
import java.util.Scanner;

/**
 *
 * @author felipe
 */
public class Main {

    public static void main(String[] args) {
        Expressao_Regular Exp_Reg = new Expressao_Regular();
        Scanner lerOpcao = new Scanner(System.in);
        int op=0;

        do{
            System.out.println("-----------------------Menu------------------------");

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Verificar assinatura");
            System.out.println("2 - Verificar parâmetros");
            System.out.println("3 - Verificar condição");
            System.out.println("4 - Verificar expressão matemática");
            System.out.println("5 - Verificar número binário impar positivo");
            System.out.println("6 - Verificar número binário par negativo");
            System.out.println("7 - Verificar data");
            System.out.println("8 - Sair");
            
            System.out.println("---------------------------------------------------");
            
            op = lerOpcao.nextInt();
            switch (op) {
                case 1 -> Exp_Reg.preencher("Assinatura");
                case 2 -> Exp_Reg.preencher("Parametro");
                case 3 -> Exp_Reg.preencher("Condicao");
                case 4 -> Exp_Reg.preencher("Operacao");
                case 5 -> Exp_Reg.preencher("BinarioPositivo");
                case 6 -> Exp_Reg.preencher("BinarioNegativo");
                case 7 -> Exp_Reg.preencher("Data");
                case 8 -> System.out.println("Fim do programa");
                default -> System.err.println("Opção inválida");
            }
        }while(op!=8);
    }
}
