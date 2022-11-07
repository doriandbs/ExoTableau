import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Exception;
import java.util.regex.*;

import static java.lang.System.in;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        //Initialisation données
        Integer[] tableau = {5, 11, 10, 5, 64, 9, 1, 0, 2, 3};
        Integer[] tableau2 = {1, 56, 51, 80, 95};
        Integer[] tableauConca;
        int min;
        int max;
        //Informations des tableaux
        infostab(tableau);
        infostab(tableau2);
        //triage
        trier(tableau);
        trier(tableau2);
        List<Integer> Tab = Arrays.asList(tableau); //Convertis le tableau en liste
        min = Collections.min(Tab);//Collections.min et .max permettent de récupérer ces valeurs dans une liste
        max = Collections.max(Tab);
        MinMax(tableau, min, max); //Affichage du min et max avec leurs indices
        tableauConca = TabConca(tableau, tableau2); //concatenation
        int saisie=0;
        demandervaleur(saisie, tableauConca);
}
//METHODE DEMANDERVALEUR
    public static void demandervaleur(int saisie, Integer[]tab) throws NumberFormatException,IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("MERCI DE RENTRER UNE VALEUR: ");
        try {
            saisie = Integer.parseInt(br.readLine());
            existe(tab, saisie);
        }catch(Exception e){
            System.out.println("Veuillez rentrer un chiffre !");
            demandervaleur(saisie, tab);
        }
    }
//METHODE CONCATENATION
    public static <Integer> Integer[] TabConca(Integer[] premierTab, Integer[] sndTab) {
        Integer[] tableauConca = Arrays.copyOf(premierTab, premierTab.length + sndTab.length);
        System.arraycopy(sndTab, 0, tableauConca, premierTab.length, sndTab.length);
        System.out.println("\nNouveau tableau concaténé : " + Arrays.toString(tableauConca) + " | taille : " + tableauConca.length);
        Arrays.sort(tableauConca);
        System.out.println("\nTableau concaténé trié : " + Arrays.toString(tableauConca));
        return tableauConca;
    }
//METHODE VERIFICATION SI VALEUR EXISTE DANS LE TABLEAU
    public static void existe(Integer[] tab, int saisie) throws IOException {
        int result = 0;
        System.out.println("\nSi votre saisie est dans le tableau, nous allons multiplier par 5 chaques valeurs correspondantes à votre saisie");
        for (int i = 0; i < tab.length; i++) {
            if (saisie == tab[i]) {
                tab[i] = saisie * 5;
                result = 1;
                System.out.println("Valeur trouvée");
            }

        }
        if (result == 0) {
            System.out.println("Malheureusement, votre valeur n'est pas dans le tableau");

        } else {
            System.out.println("\nVotre nouveau tableau : " + Arrays.toString(tab));
        }
        demandervaleur(saisie,tab);
    }
//METHODE AFFICHE MIN MAX
    public static void MinMax(Integer[] tableau, int min, int max) {
        System.out.println("\nElement maximum : " + max + " | Indice : " + Arrays.binarySearch(tableau, max));
        System.out.print("\nElement minimum : " + min + " |Indice : " + Arrays.binarySearch(tableau, min));
    }
//METHODE TRIAGE
    public static void trier(Integer[] tableau) {
        Arrays.sort(tableau);
        System.out.print("\nTableau trié :" + Arrays.toString(tableau));

    }
//METHODE AFFICHAGE INFORMATIONS
    public static void infostab(Integer[] tableau) {
        System.out.print("\nTableau " + Arrays.toString(tableau) + " | taille : " + tableau.length);
    }
//METHODE VERIFICATION SAISIE SI CHIFFRES
   /* public static boolean verifsaisie(int saisie) throws IOException {
        String regex = "[0-9]";
        boolean bool = false;
        if (Pattern.matches(regex, "saisie")) {
            System.out.println("Pas au bon format");
            bool = false;
        } else {
            System.out.println("Bon format");

            bool = true;
        }
        return bool;
    }*/
}