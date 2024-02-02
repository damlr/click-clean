package user;

import java.util.*;

public class App {

	public static void main(String[] args) {
		Scanner key =   new Scanner(System.in);
		
		System.out.println("nom d'utilisateur : ");
		String username = key.next();
		System.out.println("mot de passe : ");
		String mdp = key.next();
		
		new TestController(username,mdp);
		
		
		
		// TODO Auto-generated method stub
		//Invite invite1 = new Invite();
		//invite1.newAccount(true,"sdufac","Dufac","Simon",22,"azerty","simon.dufac@gmail.com","blablabla","07293","22/10/2001");
		//invite1.newAccount(false,"abc","Dupont","Pierre",22,"azerty","simon.dufac@gmail.com","blablabla","07293","22/10/2001");
		
		//Cleaner user1 = new Cleaner("sdufac","Dufac","Simon",22,"azerty","simon.dufac@gmail.com","blablabla","07293","22/10/2001");
		//Proprietaire user2 = new Proprietaire("abc","Dupont","Pierre",22,"azerty","simon.dufac@gmail.com","blablabla","07293","22/10/2001");
		
		
		//userBDD.deleteProprietaire(user2);
		//userBDD.deleteCleaner(user1);
		//suserBDD.lister();

		
	}
}
