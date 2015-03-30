package Proxy.SlimShady;

public class RealSlimShady implements SlimShady
{
	private boolean isStanding = false;
	private RealSlimShady realSlim;

	public RealSlimShady(SlimShady slim) {
		this.realSlim = (RealSlimShady) slim;
	}
	
	@Override
	public boolean standUp() {
		if (this.isStanding == false){
			this.isStanding = true;
			System.out.println("The real slim shady has stood up!");
			return this.isStanding;
		}
		else {
			System.out.print("The Real Slim Shady is already standing.");
		}
		return false;
	}
}