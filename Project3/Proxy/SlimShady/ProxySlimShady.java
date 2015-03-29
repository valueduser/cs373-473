package SlimShady;

public class ProxySlimShady implements SlimShady {
	private SlimShady slim;

	public ProxySlimShady (SlimShady slim){
		this.slim = slim;
	}
	
	@Override
	public boolean standUp() {
		RealSlimShady realSlim = new RealSlimShady(slim);
		realSlim.standUp();
		return true;
	}
	
}