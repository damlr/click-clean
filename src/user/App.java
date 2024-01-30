package user;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cleaner user1 = new Cleaner("sdufac","Dufac","Simon",22,"azerty","simon.dufac@gmail.com","blablabla","07293","22/10/2001");
		Proprietaire user2 = new Proprietaire("abc","Dupont","Pierre",22,"azerty","simon.dufac@gmail.com","blablabla","07293","22/10/2001");
		user1.comment(user2, 5, "ouais pas mal");
		user1.comment(user2, 2, "ouais bof");
		user2.printComment();
	}
}
