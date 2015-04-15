package Visitor.visitable;

import Visitor.visitor.Visitor;

public interface Visitable {
    public void accept(Visitor visitor);
}
