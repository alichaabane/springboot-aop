package com.sesame.tp2.metier;

public interface ImetierBanque {
    public void addCompte(Compte cp);
    void verser(Long code, double montant);
    void retirer(Long code, double montant);
    Compte consulter(Long code);

}
