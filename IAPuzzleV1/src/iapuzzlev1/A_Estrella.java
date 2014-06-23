/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iapuzzlev1;


public class A_Estrella {
    public static String[][] matriz_final = {{"*","A","B"},
                                             {"C","D","E"},
                                             {"F","G","H"}};
    
    public String[][] tablero;
public A_Estrella(String[][] T){
    tablero = T; 
    
}
    /*
    Esta funcion recibe como parametro la matriz del juego
    y verifica si se esta en el estado optimo
    retorna true si se esta en optimo
    false en caso contrario
*/
public static boolean Optimo(String[][] matriz_juego){
    int i, j;
    
    boolean bandera = true;
    i=0;
    j=0;
    while(i<3){
        while(j<3){
            if(matriz_juego[i][j].compareTo(matriz_final[i][j]) !=0){
                   bandera = false;
                   break;
            }
            else{
                j++;
            }
        }
        if (!bandera){
            break;
        }
        else{
            i++;
            j=0;
        }
    }
    if(bandera){
        System.out.println("optimo!!!!!!!!");
        return true;
    }
    else{
       System.out.println("no se esta en optimo!!!!!!!!"); 
       return false;
    }
}

/* 
    Esta funcion recibe como parametro la matriz del juego
    y calcula la posicion i,j del cuadro blanco
    retorna un vector de dos espacios de la forma [x,y]
    donde x es el numero de fila y y es el numero de columna
*/
public int[] Posicion_blanca(){
    int [] respuesta = new int[2];
    int i,j;
    boolean bandera = true;
    i =0;
    j=0;
    
    while(i<3){
        while(j<3){
            if(tablero[i][j].compareTo("*")==0){
                bandera=false;
                break;
            }
            j++;
        }
        if (!bandera){
            break;
        }
        else{
            i++;
            j=0;
        }    
    }
    System.out.println("\n El cuadro vacio esta:");
    System.out.println("X = " + i);
    System.out.println("Y = " + j);
    respuesta[0]= i;
    respuesta[1]=j;
    return respuesta;
}

/*
    Esta funcion recibe como parametros la posicion x,y del cuadro
    blanco y define la cantidad de movimientos por hacer.
    se tienen los siguientes casos:
    Lados
    Izquierdo, derecho, superior e inferior 3 posibles movimientos
    
    Esquinas
    Superior izq y der e inferior izq y der 2 posibles movimientos

    Centro 4 Posibles movimientos
*/
//TODO funcion sin terminar
public void Definir_cant_movimientos(int[] posicion_blanca ){
    double[][] lista_costos;
    int fila,columna;
    switch(posicion_blanca[0]){
        case 0:
            switch(posicion_blanca[1]){
                case 0:// Esquina superior izquierda
                    lista_costos = new double[2][2];
                    fila = 0;
                    columna =0;
                    Mover_Abajo(posicion_blanca);
                    lista_costos[0][0]=2;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Arriba(Posicion_blanca());
                    Mover_Der(Posicion_blanca());
                    lista_costos[0][1]=4;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Izq(Posicion_blanca());
                    Hacer_movimiento(lista_costos,3);
                    
                    ;break;
                case 1:// Centro lado superior
                    lista_costos = new double[2][3];
                    fila = 0;
                    columna =0;
                    Mover_Izq(posicion_blanca);
                    lista_costos[0][0]=3;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Der(Posicion_blanca());
                    Mover_Der(Posicion_blanca());
                    lista_costos[0][1]=4;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Izq(Posicion_blanca());
                    //Posicion_blanca();
                    Mover_Abajo(Posicion_blanca());
                    lista_costos[0][2]=2;
                    lista_costos[1][2]=Costo_Movimiento(tablero); 
                    // Costo_Movimiento(tablero);
                    Mover_Arriba(Posicion_blanca());
                    System.out.println("<<<<<<<Va todo bien>>>>>>>");
                    Hacer_movimiento(lista_costos,2);
                    ;break;
                case 2:// Equina superior derecha
                    lista_costos = new double[2][2];
                    fila = 0;
                    columna =0;
                    Mover_Abajo(posicion_blanca);
                    lista_costos[0][0]=2;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Arriba(Posicion_blanca());
                    Mover_Izq(Posicion_blanca());
                    lista_costos[0][1]=3;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Der(Posicion_blanca());
                    Hacer_movimiento(lista_costos,3);
                    
                    
                    ;break;
                default:break;
            }
            ;break;
        case 1:
            switch(posicion_blanca[1]){
                case 0:// Centro lado izquierdo
                    lista_costos = new double[2][3];
                    fila = 0;
                    columna =0;
                    Mover_Arriba(posicion_blanca);
                    lista_costos[0][0]=1;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Abajo(Posicion_blanca());
                    Mover_Abajo(Posicion_blanca());
                    lista_costos[0][1]=2;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Arriba(Posicion_blanca());
                    //Posicion_blanca();
                    Mover_Der(Posicion_blanca());
                    lista_costos[0][2]=4;
                    lista_costos[1][2]=Costo_Movimiento(tablero); 
                    // Costo_Movimiento(tablero);
                    Mover_Izq(Posicion_blanca());
                    Hacer_movimiento(lista_costos,2);
                    
                    ;break;
                case 1:// Centro
                    lista_costos = new double[2][4];
                    fila = 0;
                    columna =0;
                    
                    Mover_Arriba(posicion_blanca);
                    lista_costos[0][0]=1;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Abajo(Posicion_blanca());
                    Mover_Abajo(Posicion_blanca());
                    lista_costos[0][1]=2;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                   // Costo_Movimiento(tablero);
                    Mover_Arriba(Posicion_blanca());
                    //Posicion_blanca();
                    Mover_Izq(Posicion_blanca());
                    lista_costos[0][2]=3;
                    lista_costos[1][2]=Costo_Movimiento(tablero); 
                    // Costo_Movimiento(tablero);
                    System.out.println("Error");
                    Mover_Der(Posicion_blanca());
                    //Posicion_blanca();
                    Mover_Der(Posicion_blanca());
                    lista_costos[0][3]=4;
                    lista_costos[1][3]=Costo_Movimiento(tablero); 
                   // Costo_Movimiento(tablero);
                    Mover_Izq(Posicion_blanca());
                    //Posicion_blanca();
                    Hacer_movimiento(lista_costos,1);
                    ;break; 
                case 2:// Centro lado derecho
                    lista_costos = new double[2][3];
                    fila = 0;
                    columna =0;
                    Mover_Arriba(posicion_blanca);
                    lista_costos[0][0]=1;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Abajo(Posicion_blanca());
                    Mover_Abajo(Posicion_blanca());
                    lista_costos[0][1]=2;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Arriba(Posicion_blanca());
                    //Posicion_blanca();
                    Mover_Izq(Posicion_blanca());
                    lista_costos[0][2]=3;
                    lista_costos[1][2]=Costo_Movimiento(tablero); 
                    // Costo_Movimiento(tablero);
                    Mover_Der(Posicion_blanca());
                    Hacer_movimiento(lista_costos,2);
                    ;break;
                default:break;
            }
            ;break;
        case 2:
            switch(posicion_blanca[1]){
                case 0:// Esquina inferior izquierda
                    lista_costos = new double[2][2];
                    fila = 0;
                    columna =0;
                    Mover_Arriba(posicion_blanca);
                    lista_costos[0][0]=1;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Abajo(Posicion_blanca());
                    Mover_Der(Posicion_blanca());
                    lista_costos[0][1]=4;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Izq(Posicion_blanca());
                    Hacer_movimiento(lista_costos,3);
                    ;break;
                case 1:// Centro lado inferior
                    lista_costos = new double[2][3];
                    fila = 0;
                    columna =0;
                    Mover_Izq(posicion_blanca);
                    lista_costos[0][0]=3;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Der(Posicion_blanca());
                    Mover_Der(Posicion_blanca());
                    lista_costos[0][1]=4;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Izq(Posicion_blanca());
                    //Posicion_blanca();
                    Mover_Arriba(Posicion_blanca());
                    lista_costos[0][2]=1;
                    lista_costos[1][2]=Costo_Movimiento(tablero); 
                    // Costo_Movimiento(tablero);
                    Mover_Abajo(Posicion_blanca());
                    Hacer_movimiento(lista_costos,2);
                    ;break;
                case 2:// Esquina inferior derecha
                    lista_costos = new double[2][2];
                    fila = 0;
                    columna =0;
                    Mover_Arriba(posicion_blanca);
                    lista_costos[0][0]=1;
                    lista_costos[1][0]=Costo_Movimiento(tablero);
                    Mover_Abajo(Posicion_blanca());
                    Mover_Izq(Posicion_blanca());
                    lista_costos[0][1]=3;
                    lista_costos[1][1]=Costo_Movimiento(tablero); 
                    Mover_Der(Posicion_blanca());
                    Hacer_movimiento(lista_costos,3);
                    ;break;
                default:break;
            }
            ; break;
        default:;break;
    }
}


public void Mover_Arriba(int[] par_ordenado){
    String [][] M1= tablero;
    String temporal = M1[par_ordenado[0]][par_ordenado[1]];
    System.out.println("\n arriba \n");
    M1[par_ordenado[0]][par_ordenado[1]] = M1[par_ordenado[0]-1][par_ordenado[1]];
    M1[par_ordenado[0]-1][par_ordenado[1]]= temporal;
    imprimir(M1);   
    System.out.println("\n ************** \n");
    
    
} 

public void Mover_Abajo(int[] par_ordenado){
    String [][] M1= tablero;
     System.out.println("\n abajo \n");
    String temporal = M1[par_ordenado[0]][par_ordenado[1]];
    M1[par_ordenado[0]][par_ordenado[1]] =M1[par_ordenado[0]+1][par_ordenado[1]];
    M1[par_ordenado[0]+1][par_ordenado[1]]= temporal;
    imprimir(M1);
    System.out.println("\n ************** \n");
} 

public void Mover_Izq(int[] par_ordenado){
    String [][] M1= tablero;
   System.out.println("\n Izquierda \n");
    String temporal = M1[par_ordenado[0]][par_ordenado[1]];
    M1[par_ordenado[0]][par_ordenado[1]] =M1[par_ordenado[0]][par_ordenado[1]-1];
    M1[par_ordenado[0]][par_ordenado[1]-1]= temporal;
    imprimir(M1);
    System.out.println("\n ************** \n");
    
    
} 

public void Mover_Der(int[] par_ordenado ){
    String [][] M1= tablero;
    System.out.println("\n derecha \n");
    String temporal = M1[par_ordenado[0]][par_ordenado[1]];
    M1[par_ordenado[0]][par_ordenado[1]] =M1[par_ordenado[0]][par_ordenado[1]+1];
    M1[par_ordenado[0]][par_ordenado[1]+1]= temporal;
     imprimir(M1);
     System.out.println("\n ************** \n");
} 

public void imprimir(String[][] MJ){
System.out.println("************");
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            System.out.print(MJ[i][j]);
        }
        System.out.print("\n");
    }
}

/*
    Esra funcion recibe por parametro el tablero de juego
    calcula el valor de hacer un movimiento
*/
public double Costo_Movimiento(String[][] MT){
    int w = 0;
    double q;
    for(int i =0;i<3;i++){
        for(int j =0;j<3;j++){
            w += Movimientos_optimo(i,j,MT[i][j]);
        }
    }
    q= w/8.0;
    System.out.println(q + " costo del movimiento\n ");
    return q;
}
    
    /*
    Esta funcion recibe por parametros la posicion x, y
    de una ficha en el tablero y el valor de la misma,
    calcula el numero de movimientos nesesarios para
    que la pieza este en optimo.
*/
public int Movimientos_optimo(int x, int y, String valor){
    int x2,y2,z;
    z=0;
    for (int i =0; i<3; i++){
        
        for(int j =0;j<3;j++){
            if(valor.compareTo(matriz_final[i][j])==0){
                x2=x-i;
                y2=y-j;
                if(x2<0){
                    x2 = x2*-1;
                }
                if(y2<0){
                    y2 = y2*-1;
                }
                z=x2+y2;
            }
        }
    }
    
    return z;
}

public void Hacer_movimiento(double[][] lista_movimientos, int indice){
    int columnas, movimiento;
    int temporal=0;//Esta variable es temporal 
    columnas =0;
    double menor;
    switch(indice){
        case 1:// 4 movimientos
            columnas= 4;
            break;
        case 2:// 3 movimientos
            columnas= 3;
            break;
        case 3:// 2 movimientos
            columnas = 2;
            break;
        default:break;
    }
    menor = lista_movimientos[1][0];
    movimiento = (int)lista_movimientos[0][0];   
    for(int j=1;j<columnas;j++){
        if (menor>lista_movimientos[1][j]){
            menor = lista_movimientos[1][j];
            movimiento= (int)lista_movimientos[0][j];    
        }
        else {
            if (menor==lista_movimientos[1][j]){
                if(opuesto(movimiento)){
                    menor = lista_movimientos[1][j];
            movimiento= (int)lista_movimientos[0][j]; 
            }
            temporal++;
            }
        }
       // System.out.println(">>>>>>El movimiento es"+ movimiento);
      }
    if(temporal!=0){  
        ambiente.movimiento_anterior=movimiento;
           Hacer_jugada(movimiento);
    }
    else{
        ambiente.movimiento_anterior=movimiento;
        Hacer_jugada(movimiento);
      
    }
   // System.out.println("El movimiento es"+ movimiento);
    
}
public boolean opuesto(int move){
    
    switch(move){
        case 1:
            if(ambiente.movimiento_anterior==2){
               return true;
            }
            else{
               return false;
            }
        case 2:
            if(ambiente.movimiento_anterior==1){
               return true;
            }
            else{
               return false;
            }
        case 3:
            if(ambiente.movimiento_anterior==4){
               return true;
            }
            else{
               return false;
            }
        case 4: 
            if(ambiente.movimiento_anterior==3){
               return true;
            }
            else{
               return false;
            }
        default:
    }
    return false;
}
public void Hacer_jugada(int move){
    switch(move){
        case 1:
            Mover_Arriba(Posicion_blanca());
            ;break;
        case 2:
            Mover_Abajo(Posicion_blanca());
            ;break;
        case 3:
            Mover_Izq(Posicion_blanca());
            ;break;
        case 4:
            Mover_Der(Posicion_blanca());
            ;break;
        default:;break;    
    }
    ambiente.Estado_Actual = tablero;
}
}

