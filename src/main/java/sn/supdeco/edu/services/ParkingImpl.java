package sn.supdeco.edu.services;

import sn.supdeco.edu.models.Database;
import sn.supdeco.edu.models.Utilisateur;
import sn.supdeco.edu.models.Voiture;

import javax.xml.crypto.Data;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;

public class ParkingImpl implements IParking{
    private static final Random RANDOM = new Random();
    Scanner scanner = new Scanner(System.in);
    @Override
    public String creerUtilisateur(Utilisateur utilisateur) throws RemoteException {

        Database.addUtilisateur(utilisateur);
        return "Utilisateur enregistré avec succès !";

    }



    @Override
    public String creerVoiture(Voiture voiture,Utilisateur utilisateur) throws RemoteException {
        System.out.println(Database.geVoitures().size());
        if(Database.geVoitures().size() >5){
            return "Nous n'avons plus de place pour vous stationner ! ";
        }

        voiture.setCodeParking("PRK"+RANDOM.nextInt());
        Database.addVoiture(voiture);
        //Database.addUtilisateur(utilisateur);
        return "Merci de garder le code de stationnement "+ voiture.getCodeParking();

    }

    @Override
    public String recupererVoiture(String codeParking) throws RemoteException {
        Database.geUtilisateurs();
        for (int i = 0; i< Database.geVoitures().size(); i++){
         if( Database.geVoitures().get(i).getCodeParking().equalsIgnoreCase(codeParking)){

                Database.geVoitures().remove(i);
                return "Merci de nous avoir fait confiance";
         }
        }

        return null;
    }
}
