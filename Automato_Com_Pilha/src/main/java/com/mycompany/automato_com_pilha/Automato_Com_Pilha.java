/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.automato_com_pilha;

import Classes.Automato;
import java.io.IOException;

/**
 *
 * @author felipe
 */
public class Automato_Com_Pilha {

    public static void main(String[] args) throws IOException {
        
        Automato automato = new Automato();
        automato.loadTransicoes();
        automato.run();
    }
}
