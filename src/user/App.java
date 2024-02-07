package user;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		//String pseudo;
		//String mdp;
		 
		//System.out.println("pseudo:");
		//pseudo = scan.next();
		//System.out.println("mot de passe:");
		//mdp = scan.next();
		
		//new ControllerConnexion(pseudo,mdp);
		
		Boolean flag = false;
		Scanner scan = new Scanner(System.in);
		String isCleaner;
		
		System.out.println("êtes vous un cleaner? (y/n)");
		isCleaner = scan.next();
		
		while(!flag) {
			if(isCleaner.equals("y")) {
				flag=true;
				
				System.out.println("Veuillez entrer ces champs dans l'ordre :\n-Nom\n-Prenom\n-Pseudonyme\n-Age\n-Mot de passe\n-Adresse mail\n-Bio\n-Numero de telephone\n-Date de naissance\n-Perimètre de service\n-Tarif horaire");
				
				String nom = scan.next();
				String prenom = scan.next();
				String pseudo = scan.next();
				int age = scan.nextInt();
				String mdp = scan.next();
				String email = scan.next();
				String bio = scan.next();
				String tel = scan.next();
				String dateNaissance = scan.next();
				int perimeter = scan.nextInt();
				int tarif = scan.nextInt();
				
				new ControllerCreateAccount(true, nom, prenom, pseudo,email,mdp,age,bio,tel,dateNaissance,0,0,perimeter,tarif);
			}
			else if(isCleaner.equals("n")) {
				flag=true;
				
				System.out.println("Veuillez entrer ces champs dans l'ordre :\n-Nom\n-Prenom\n-Pseudonyme\n-Age\n-Mot de passe\n-Adresse mail\n-Bio\n-Numero de telephone\n-Date de naissance");
				
				String nom = scan.next();
				String prenom = scan.next();
				String pseudo = scan.next();
				int age = scan.nextInt();
				String mdp = scan.next();
				String email = scan.next();
				String bio = scan.next();
				String tel = scan.next();
				String dateNaissance = scan.next();
				
				new ControllerCreateAccount(false, nom, prenom, pseudo,email,mdp,age,bio,tel,dateNaissance,0, 0, 0, 0);
			}
			else {
				System.out.println("Erreur");
			}
		}
		
	}	
}
