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
import Service.ClientService;
import Service.CommandeService;
import Service.DemandeService;
import Service.FournisseurService;
import Service.LigneCommandeService;
import Service.LigneDemandeService;
import Service.ProduitService;
import Service.RayonService;

public class TestClientProduit {

	public static void main(String[] args) {
		ClientService cs = new ClientService();
		ProduitService ps = new ProduitService();
		CommandeService ccs = new CommandeService();
		LigneCommandeService lcs = new LigneCommandeService();
		FournisseurService fs = new FournisseurService();
		RayonService rs = new RayonService();
		DemandeService ds = new DemandeService();
		LigneDemandeService lds = new LigneDemandeService();
		Scanner sc2 = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int d = 0;
		while (d < 12) {
			System.out.println("------------------------------MENU--------------------------------\n");
			System.out.println("1-ajouter client ");
			System.out.println("2-rechercher client ");
			System.out.println("3-afficher les clients ");
			System.out.println("4-supprimer Client ");
			System.out.println("5-ajouter produit ");
			System.out.println("6-afficher les produits ");
			System.out.println("7-rechercher produit ");
			System.out.println("8-supprimer produit");
			System.out.println("9-rechercher les commandes faites par un client ");
			System.out.println("10-afficher toutes les commandes faites");
			System.out.println("11-Faire une commande");
			System.out.println("12-quitter");
			System.out.println("donnez votre choix ");
			d = sc2.nextInt();
			switch (d) {
			case 1: {
				System.out.println("donnez le nom du client ");
				String b = sc.nextLine();
				System.out.println("donnez le phone ");
				String tel = sc.nextLine();
				System.out.println("donnez l'email ");
				String em = sc.nextLine();
				cs.create(new Client(b, tel, em));
				System.out.println("Client ajoute ");
				break;
			}
			case 2: {
				int l = 0;
				System.out.println("Donnez le nom du client ");
				String n = sc.nextLine();
				for (Client c : cs.findAll()) {
					if (c.getNom().equals(n)) {
						System.out.println(c);
						l++;
					}
				}
				if (l == 0) {
					System.out.println("Aucun client n a le nom entre ");
				}
				break;
			}
			case 3: {
				for (Client c : cs.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 4: {
				int l = 0;
				System.out.println("Donnez le nom du client ");
				String n = sc.nextLine();
				for (Client c : cs.findAll()) {
					if (c.getNom().equals(n)) {
						cs.delete(c);
						l++;
						System.out.println("client supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun client n a le nom entre ");
				}
				break;
			}
			case 5: {
				Scanner sc6=new Scanner(System.in);
				Scanner sc7=new Scanner(System.in);
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
			case 6: {
				for (Produit c : ps.findAll()) {
					System.out.println(c);
				}
				break;
			}
			case 7: {
				int l = 0;
				System.out.println("Donnez l'id du produit ");
				for(Produit p:ps.findAll())
				{
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
			case 8: {
				int l = 0;
				System.out.println("Donnez l'id du produit ");
				for(Produit p:ps.findAll())
				{
					System.out.println(p);
				}
				int n = sc.nextInt();
				for (Produit c : ps.findAll()) {
					if (c.getId() == n) {
						ps.delete(c);
						l++;
						System.out.println("produit supprime successivement");
					}
				}
				if (l == 0) {
					System.out.println("Aucun produit n a l id entre ");
				}
				break;
			}
			case 9: {
				Scanner sc15 = new Scanner(System.in);
				System.out.println("Donnez le nom du client");
				String d1 = sc15.nextLine();
				int k = 0;
				for (Commande c : ccs.findAll()) {
					if ((c.getClient().getNom()).equals(d1)) {
						System.out.println(c);
						k++;
					}

				}
				if (k == 0)
					System.out.println("nom entre non existant");
				break;
			}
			case 10: {
				int p=0;
				System.out.println("Voici les Commandes Faites");
				for (Commande c : ccs.findAll()) {
					System.out.println(c);
					p++;
				}
				if(p==0)
				{
					System.out.println("aucune commande n a ete faite");
				}
				break;
			}
			
			case 11: {
				Scanner sc9=new Scanner(System.in);
				System.out.println("Donnez l'id du client");
				for(Client c:cs.findAll())
				{
					System.out.println(c);
				}
				int vv=sc9.nextInt();
				Scanner sc10=new Scanner(System.in);
				System.out.println("Donnez l'id du produit");
				for (Produit p : ps.findAll()) {
					System.out.println(p);
				}
				int cl = sc.nextInt();
				System.out.println("Donnez la quantite ");
				int qu = sc.nextInt();
				if(ps.findById(cl).quantite<qu || qu==0)
				{
					System.out.println("quantite entree est superieur a notre disposition");
					break;
				}
				System.out.println("Donnez le prix de vente");
				double pr = sc2.nextDouble();
				ccs.create(new Commande(new Date(),cs.findById(vv)));
				lcs.create(new LigneCommande(qu, pr,new Commande(new Date(),cs.findById(vv)), ps.findById(cl)));
				System.out.println("Commande faite");
				break;
			}
		
			}
		}
	}
}
