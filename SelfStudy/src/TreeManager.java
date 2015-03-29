import TreeBranch.*;


public class TreeManager {

	public static void main(String[] args) {
		TreeBranch leaf1 = new Apple();
		TreeBranch leaf2 = new Apple();
		TreeBranch branch1 = new Branch();
		branch1.add(leaf1);
		branch1.add(leaf2);
		TreeBranch leaf3 = new Apple();
		TreeBranch leaf4 = new Apple();
		TreeBranch branch2 = new Branch();
		TreeBranch branch3 = new Branch();
		branch2.add(leaf3);
		branch2.add(leaf4);
		branch3.add(branch1);
		branch3.add(branch2);
		System.out.println("-------------");
		System.out.println(branch3.print());
		System.out.println("-------------");

	}

}
