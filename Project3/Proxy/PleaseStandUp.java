import SlimShady.RealSlimShady;
import SlimShady.SlimShady;
import SlimShady.ProxySlimShady;

public class PleaseStandUp {
	public static void main(String [] args){
		SlimShady slim = null;
		System.out.println("Will the real Slim Shady please stand up?");
		ProxySlimShady proxySlim = new ProxySlimShady(slim);
		proxySlim.standUp();
	}
}