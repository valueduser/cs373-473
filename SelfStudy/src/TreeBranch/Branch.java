package TreeBranch;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class Branch implements TreeBranch {
	private String name = "Branch ";
	
	List<TreeBranch> branches = new ArrayList<TreeBranch>();
	@Override
	public void add(TreeBranch branch) {
		branches.add(branch);
	}

	@Override
	public void remove(TreeBranch branch) {
		branches.remove(branch);
	}

	@Override
	public TreeBranch getChild(int i) {
		return branches.get(i);
	}

	@Override
	public String print() {
		String branchDiscription = "Branch ";
		Iterator<TreeBranch> branchIterator = branches.iterator();
		while(branchIterator.hasNext()){
			TreeBranch b = branchIterator.next();
			branchDiscription += b.print();
		}
		return branchDiscription;
	}

	@Override
	public String getName() {
		return name;
	}

}
