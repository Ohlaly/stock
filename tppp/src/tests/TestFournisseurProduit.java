package tests;

import java.util.Date;
import java.util.Scanner;

import Entite.Client;
import Entite.Commande;
import Entite.Demande;
import Entite.Fournisseur;
import Entite.LigneCommande;
import Entite.LigneDemande;
import Entite.Produit;
import Entite.Rayon;
import Service.DemandeService;
import Service.FournisseurService;
import Service.LigneDemandeService;
import Service.ProduitService;
import Service.RayonService;

public class TestFournisseurProduit {
	public static void main(String[] args) {

		ProduitService ps = new ProduitService();
		FournisseurService fs = new FournisseurService();
		RayonService rs = new RayonService();
		DemandeService ds = new DemandeService();
		LigneDemandeService lds = new LigneDemandeService();
		Scanner sc2 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int d = 0;
		while (d < 12) {
			System.out.println("------------------------------MENU--------------------------------\n");
			System.out.println("1-ajouter produit ");
			System.out.println("2-afficher les produits ");
			System.out.println("3-rechercher produit ");
			System.out.println("4-supprimer produit");
			System.out.println("5-faire une demande d'un produit");
			System.out.println("6-afficher toutes les demandes faites");
			System.out.println("7-ajouter un fournisseur");
			System.out.println("8-afficher les fournisseurs");
			System.out.println("9-Supprimer Fournisseur");
			System.out.println("10-ajouter rayon ");
			System.out.println("11-quitter");
			System.out.println("donnez votre choix ");
			d = sc2.nextInt();
			switch (d) {
			case 1: {
				Scanner sc6 = new Scanner(System.in);
				Scanner sc7 = new Scanner(System.in);
				System.out.println("Donnez la designation d'un produit ");
				String des = sc6.nextLine();
				System.out.println("Donnez le prix d'achat du produit ");
				Double pr = sc7.nextDouble();
				System.out.println("Choisissez votre rayon");
				for (Rayon r : rs.findAll()) {
					System.out.println(r);
				}
				int rc = sc.nextInt();

				ps.create(new Produit(des, pr, rs.findById(rc)));
				System.out.println("produit ajoute");
				break;
			}
			case 2: {
				for (Produit c : ps.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 3: {
				int l = 0;
				System.out.println("Donnez l'id du produit ");
				for (Produit p : ps.findAll()) {
					System.out.println(p);
				}
				int n = sc.nextInt();
				for (Produit c : ps.findAll()) {
					if (c.getId() == n) {
						System.out.println(c);
						l++;
					}
				}
				if (l == 0) {
					System.out.println("Aucun produit n a le nom entre ");
				}
				break;
			}
			case 4: {
				int l = 0;
				System.out.println("Donnez l'id du produit ");
				int n = sc.nextInt();
				for (Produit c : ps.findAll()) {
					if (c.getId() == n) {
						ps.delete(c);
						l++;
						System.out.println("produit supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun produit n a le nom entre ");
				}
				break;
			}
			case 5: {
				System.out.println("donnez l'id du fournisseur");
				for (Fournisseur f : fs.findAll()) {
					System.out.println(f);
				}
				int i = sc.nextInt();
				ds.create(new Demande(fs.findById(i), new Date()));
				System.out.println("Donnez l'id du produit que vous voulez");
				for (Produit c : ps.findAll()) {
					System.out.println(c);
				}

				int g = sc.nextInt();

				System.out.println("Donnez la quantite dont vous avez besoin");
				int qu = sc.nextInt();
				lds.create(new LigneDemande(ps.findById(g),new Demande(fs.findById(i), new Date()), qu));
				System.out.println("Demande faite");
				break;
			}
			case 6: {
				int h=0;
				System.out.println("Voici les Demandes Faites");
				for (Demande c : ds.findAll()) {
					System.out.println(c);
					h++;
				}
				if(h==0)
					System.out.println("Aucune demande n a ete faite");
				break;
			}
			case 7: {
				Scanner sc3 = new Scanner(System.in);
				Scanner sc4 = new Scanner(System.in);
				System.out.println("Donnez le nom du fournisseur");
				String name = sc3.nextLine();
				System.out.println("Donnez son telephone");
				String phone = sc4.nextLine();
				fs.create(new Fournisseur(name, phone));
				System.out.println("Fournisseur ajoute");
				break;
			}
			case 8: {
				for (Fournisseur f : fs.findAll()) {
					System.out.println(f);
				}
				break;
			}
			case 9: {
				int l = 0;
				System.out.println("Donnez l'id du fournisseur \n");
				for (Fournisseur c : fs.findAll()) {
					System.out.println(c);
				}
				int n = sc.nextInt();
				for (Fournisseur c : fs.findAll()) {
					if (c.getId() == n) {
						fs.delete(c);
						l++;
						System.out.println("fournisseur supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun fournisseur n a le nom entre \n");
				}
				break;
			}
			case 10: {
				Scanner sc5 = new Scanner(System.in);

				System.out.println("donnez le code du rayon");
				String cod = sc5.nextLine();
				rs.create(new Rayon(cod));
				System.out.println("rayon ajoute avec succes");
				break;

			}
			}
		}
	}
}
