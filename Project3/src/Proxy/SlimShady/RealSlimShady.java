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
			System.out.println("Yes I'm the real Shady \nAll you other Slim Shadys are just imatating");
			return this.isStanding;
		}
		else {
			System.out.print("The Real Slim Shady is already standing.");
		}
		return false;
	}
}