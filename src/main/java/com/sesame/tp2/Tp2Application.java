package com.sesame.tp2;

import com.sesame.tp2.metier.Compte;
import com.sesame.tp2.metier.ImetierBanque;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Tp2Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext appCtx =
                new AnnotationConfigApplicationContext(Tp2Application.class);


        System.out.println("Démarrage de l'application");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner le code du compte");
        long code = scanner.nextLong();

        System.out.println("Donner le solde initial du compte");
        double solde = scanner.nextDouble();


        ImetierBanque metierBanque = appCtx.getBean(ImetierBanque.class);
        metierBanque.addCompte(new Compte(code, solde));

        while (true) {
            try {
                System.out.println("Type Opération");
                String type = scanner.next();
                if (type.equals("quitter")) break;
                System.out.println("Montant :");
                double montant = scanner.nextDouble();
                if (type.equals("v")) {
                    metierBanque.verser(code, montant);
                } else if (type.equals("r")) {
                    metierBanque.retirer(code, montant);
                }
                Compte c = metierBanque.consulter(code);
                System.out.println("Etat du compte :  " + c);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

}
