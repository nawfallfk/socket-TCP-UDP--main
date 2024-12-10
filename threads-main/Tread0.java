package Threads;
public class Tread0 extends Thread {
	private String name ;
		public Tread0(String name){
		this.name=name;
		}
		public void run(){
		for( int i=1; i<100; i++){
		try {
		sleep (( long )( Math . random () * 100));
		} catch (InterruptedException ie){
		   ie.getStackTrace ();
		}
		System . out . println ( name );
		}}
		public static void main (String args[]){
		Tread0 T1 = new Tread0 ( " T1 est en cours ... " );
		Tread0 T2 = new Tread0 ( " T2 est en cours ... " );
		Tread0 T3 = new Tread0 ( " T3 est en cours ... " );
		T1 . start ();
		T2 . start ();
		T3 . start ();
		System . out . println ( " c ’ est le threads principal . " );
}}


