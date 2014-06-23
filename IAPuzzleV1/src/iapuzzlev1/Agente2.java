/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iapuzzlev1;

import jade.core.Agent;

/*
Este agente verifica si las fichas en el tablero 
estan en la posicion correcta

*/
public class Agente2 extends Agent{
    String [][] tablero;
    public Agente2(String[][] T){
        tablero = T;
    }
    public boolean Verificar_Optimo(){
        
        return A_Estrella.Optimo(tablero);
    }
}
