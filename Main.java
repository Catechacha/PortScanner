import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static int N=1000;
	
	public static void main(String[] args){
		int i;
		Scanner input = new Scanner(System.in);
		System.out.println("Give me the IP-Address or hostname");
		String hostname=input.nextLine();
		input.close();
		
		ExecutorService exe = Executors.newFixedThreadPool(N);
		ArrayList<Future<Integer>> tasks = new ArrayList<Future<Integer>>();
		for(i=0;i<65535;i++)//(2^16)-1=65535
			tasks.add(exe.submit(new Port_Thread(i,hostname)));
		exe.shutdown();
	}
}