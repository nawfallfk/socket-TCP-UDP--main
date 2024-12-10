package Threads;

public class Suite extends Thread {

	private int terme;
	private int resultat;
	private static int[] suites = new int[100]; // Taille arbitraire, peut être ajustée

	public Suite(int terme){
    this.terme = terme;
	}

@Override
public void run() {
	if (terme == 0) {
		resultat = 2; // Valeur de U0
	} else {
		// Calcul de Un+1 en fonction de Un
		resultat = 5 * suites[terme - 1] + 5;
	}
	suites[terme] = resultat;
	System.out.println("Terme U" + terme + " = " + resultat);
}

public static void main(String[] args) {
	Suite t1 = new Suite(0);
	Suite t2 = new Suite(1);
	Suite t3 = new Suite(2);

	t1.start();
	t2.start();
	t3.start();


}

}
