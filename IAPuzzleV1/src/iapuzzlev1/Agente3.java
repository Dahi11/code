/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iapuzzlev1;

import jade.core.Agent;

/**
 *
 * @author Dahianna
 */
public class Agente3 extends Agent{
    String [][] tablero;
    public Agente3(String[][] T){
        tablero = T;
    }
    public void Construir_ruta_optima(){
        A_Estrella solucionador = new A_Estrella(tablero);
        
        
        //A_Estrella.Definir_cant_movimientos(A_Estrella.Posicion_blanca(matriz_juego), matriz_juego);
        solucionador.Definir_cant_movimientos(solucionador.Posicion_blanca()); 
    }
}
