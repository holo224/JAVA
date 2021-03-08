package sn.isi.traitement;

import sn.isi.entities.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedecinImp implements IMedcin{
    private Scanner sc = new Scanner(System.in);
    private Service service = new Service();
    private Medecin medecin = new Medecin();
    @Override
    public Medecin saisie() {
        System.out.println("Entrer un service");
        System.out.println("Entrer l'id : ");
        service.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entrer le nom : ");
        service.setNom(sc.nextLine());
        System.out.println("Entrer les données du Medecin");
        System.out.println("Id : ");
        medecin.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entrer leNom : ");
        medecin.setNom(sc.nextLine());
        System.out.println("Entrer le Prenom : ");
        medecin.setPrenom(sc.nextLine());
        System.out.println("entrer le Service : ");
        medecin.setService(service);
        return medecin;
    }

    @Override
    public void affiche(Medecin m) {
        System.out.println("l'Id : "+medecin.getId());
        System.out.println("le Nom : "+medecin.getNom());
        System.out.println("le Prenom : "+medecin.getPrenom());
        System.out.println("le Service : "+medecin.getService());
    }
    private MedecinChef MC = new MedecinChef();
    @Override
    public MedecinChef saisieMC() {
        System.out.println("Entrer le bureau : ");
        MC.setBureau(sc.nextLine());
        System.out.println("Entrer un service");
        System.out.println("Entrer les données du Medecin");
        System.out.println("Id : ");
        MC.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("entrer le Nom : ");
        MC.setNom(sc.nextLine());
        System.out.println("Entrer lePrenom : ");
        MC.setPrenom(sc.nextLine());
        System.out.println("Entrer leService : ");
        service.setNom("Medecin Chef");
        MC.setService(service);
        return MC;
    }

    @Override
    public void afficheMC(MedecinChef MC) {
        System.out.println("Bureau : "+MC.getBureau());
        System.out.println("Id est : "+MC.getId());
        System.out.println("Nom est : "+MC.getNom());
        System.out.println("Prenom est: "+MC.getPrenom());
        System.out.println("Service est : "+MC.getService());
    }
    @Override
    public MedecinGeneraliste saisieMG() {
        MedecinGeneraliste MG = new MedecinGeneraliste();
        String rep;
        List<Specialite> specialites = new ArrayList<>();
        do {
            Specialite specialite = new Specialite();
            System.out.println("Entrer la Liste de Specialite");
            System.out.println("Entrer le Nom de la Specialite :");
            specialite.setNomSpe(sc.nextLine());
            specialites.add(specialite);
            System.out.println("NOUVELLE SPECIALITE ?");
            rep = sc.nextLine();
        }while(rep.equalsIgnoreCase("oui"));
        MG.setListSpecialistes(specialites);
        System.out.println("Entrer un service");
        System.out.println("L'id : ");
        service.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Nom : ");
        service.setNom(sc.nextLine());
        System.out.println("Entrer les données du Medecin");
        System.out.println("Id : ");
        MG.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entrer le Nom : ");
        MG.setNom(sc.nextLine());
        System.out.println("Entrer le Prenom : ");
        MG.setPrenom(sc.nextLine());
        System.out.println("Entrer le Service : ");
        MG.setService(service);
        return MG;
    }

    @Override
    public void afficheMG(MedecinGeneraliste MG) {
        System.out.println("Id est: "+MG.getId());
        System.out.println("Nom est: "+MG.getNom());
        System.out.println("Prenom est: "+MG.getPrenom());
        System.out.println("Service est : "+MG.getService().getNom());
        List<Specialite> specialites = new ArrayList<Specialite>();
        specialites = MG.getListSpecialistes();
        for (Specialite sp : specialites )
        {
            System.out.println("SPECIALITE : "+sp.getNomSpe());
        }
    }
    private MedecinSpecialiste MS = new MedecinSpecialiste();
    @Override
    public MedecinSpecialiste saisiMS() {
        System.out.println("Entrer une Specialite");
        MS.setSpecialite(sc.nextLine());
        System.out.println("Entrer un service");
        System.out.println("Entrer L'id : ");
        service.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entrer Nom : ");
        service.setNom(sc.nextLine());
        System.out.println("Entrer les données du Medecin");
        System.out.println("Entrer Id : ");
        MS.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Entrer Nom : ");
        MS.setNom(sc.nextLine());
        System.out.println("Entrer Prenom : ");
        MS.setPrenom(sc.nextLine());
        System.out.println("Entrer Service : ");
        MS.setService(service);
        return MS;
    }

    @Override
    public void afficheMS(MedecinSpecialiste MS) {
        System.out.println("Specialiste : "+MS.getSpecialite());
        System.out.println("Id est : "+MS.getId());
        System.out.println("Nom est: "+MS.getNom());
        System.out.println("Prenom est : "+MS.getPrenom());
        System.out.println("Service est : "+MS.getService());
    }

    @Override
    public Integer choix() {
        Integer choix = null;
        do {
        System.out.println("FAITE VOTRE CHOIX ");
        System.out.println("1_____MEDECIN");
        System.out.println("2_____MEDECIN CHEF");
        System.out.println("3_____MEDECIN GENERALITE");
        System.out.println("4_____MEDECIN SPECIALISTE");
        System.out.println("5______QUITTER");
        choix = Integer.parseInt(sc.nextLine());
        if (choix == 5)
        {
            break;
        }
        }while (choix<1 || choix>5);

        return choix;
    }
}
