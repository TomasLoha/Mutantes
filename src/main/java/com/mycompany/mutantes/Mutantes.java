/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mutantes;

import java.util.Scanner;

/**
 *
 * @author oscarloha
 */
public class Mutantes {
//comprobado es mutante ejemplo String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
    public static boolean isMutant(String[] dna) {
        int filas = dna.length;
        int columnas = dna[0].length();
        int cont = 0;

        for (String row : dna) {
            if (!row.matches("[ATCG]+")) {
                
                System.out.println("algunos de los genes enviados no coinciden con ninguno conocido");
                return false; 
            }
        }


        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (dna[i].charAt(j) == dna[i].charAt(j + 1)
                        && dna[i].charAt(j) == dna[i].charAt(j + 2)
                        && dna[i].charAt(j) == dna[i].charAt(j + 3)) {
                    cont++;
                }
                if (cont >= 2) {
                    return true;  
                }
            }
        }


        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas - 3; j++) {
                if (dna[j].charAt(i) == dna[j + 1].charAt(i)
                        && dna[j].charAt(i) == dna[j + 2].charAt(i)
                        && dna[j].charAt(i) == dna[j + 3].charAt(i)) {
                    cont++;
                }
                if (cont >= 2) {
                    return true; 
                }
            }
        }

   
        for (int i = 0; i < filas - 3; i++) {
            for (int j = 0; j < columnas - 3; j++) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j + 1)
                        && dna[i].charAt(j) == dna[i + 2].charAt(j + 2)
                        && dna[i].charAt(j) == dna[i + 3].charAt(j + 3)) {
                    cont++;
                }
                if (cont >= 2) {
                    return true;  // Es mutante
                }
            }
        }

       
        for (int i = 0; i < filas - 3; i++) {
            for (int j = columnas - 1; j >= 3; j--) {
                if (dna[i].charAt(j) == dna[i + 1].charAt(j - 1)
                        && dna[i].charAt(j) == dna[i + 2].charAt(j - 2)
                        && dna[i].charAt(j) == dna[i + 3].charAt(j - 3)) {
                    cont++;
                }
                if (cont >= 2) {
                    return true;  
                }
            }
        }

        System.out.println("No se ha podido comprobar genes mutantes");
        System.out.println("");
        return false;  

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dna = new String[6];

        System.out.println("Ingrese las filas de la matriz de ADN (6 filas):");
        for (int i = 0; i < 6; i++) {
            dna[i] = scanner.nextLine();
        }

        boolean esMutante = isMutant(dna);

        if (esMutante) {
            System.out.println("Es mutante.");
        } else {
            System.out.println("No es mutante.");
        }
    }
}
