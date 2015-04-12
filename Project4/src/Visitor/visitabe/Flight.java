package Visitor.visitabe;

import Visitor.visitor.Visitor;

public class Flight implements Visitable {
	private Visitor vistor;

	@Override
	public void accept(Visitor vistor) {
		this.vistor = vistor;
		
	}

}
