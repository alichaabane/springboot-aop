package com.sesame.tp2.metier;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MetierBanqueImpl implements ImetierBanque {
    private final Map<Long,Compte> compteMap = new HashMap<Long, Compte>();
    @Override
    public void addCompte(Compte cp) {
        compteMap.put(cp.getCode(), cp);
    }

    @Override
    public void verser(Long code, double montant) {
        Compte compte=compteMap.get(code);
        compte.setSolde(compte.getSolde()+montant);
    }

    @Override
    public void retirer(Long code, double montant) {
        Compte compte=compteMap.get(code);
        compte.setSolde(compte.getSolde()-montant);
    }

    @Override
    public Compte consulter(Long code) {
        return compteMap.get(code);
    }
}
