import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.Callable;

public class Port_Thread implements Callable<Integer>{
	private int port;
	private String hostname;
	
	public Port_Thread(int p,String h){
		this.port=p;
		this.hostname=h;
	}
	
	@Override
	public Integer call(){
		Socket s= new Socket();
		SocketAddress address = new InetSocketAddress(this.hostname,this.port);
		try{
			try{
				s.connect(address);
			}catch(IOException ex){
				System.err.print("");
			}
			if(s.isConnected())
				System.out.println("Port "+s.getPort()+" opened");
		}finally{
			try{
				s.close();
			}catch(IOException e){}
		}
		return 1;
	}
}