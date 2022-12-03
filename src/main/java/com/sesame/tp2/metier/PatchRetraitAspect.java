package com.sesame.tp2.metier;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Aspect
@Component
@EnableAspectJAutoProxy
public class PatchRetraitAspect {
   @Autowired
    private ImetierBanque metier;

    @Around("execution(* com.sesame.tp2..ImetierBanque.*(..)) && args(code,montant)")
    public Object autour(ProceedingJoinPoint proceedingjoinPoint, Long code, double montant ) throws Throwable {
        Compte compte = metier.consulter(code);
        if(compte.getSolde()< montant)throw new RuntimeException("Solde insuffisant");
        return proceedingjoinPoint.proceed();
    }

}
