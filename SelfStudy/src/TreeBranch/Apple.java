package TreeBranch;

public class Apple implements TreeBranch {
	private String name = "Apple ";

	@Override
	public void add(TreeBranch branch) {
		// Method does not apply to leaf node
	}

	@Override
	public void remove(TreeBranch branch) {
		// Method does not apply to leaf node

	}

	@Override
	public TreeBranch getChild(int i) {
		// Method does not apply to leaf node
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String print() {
		return name;
	}

}
