package TreeBranch;

public interface TreeBranch {
	public String getName();
	public void add(TreeBranch branch);
	public void remove(TreeBranch branch);
	public TreeBranch getChild(int i);
	public String print();
}
