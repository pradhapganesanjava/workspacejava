package solstools.random;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProbabilityRandom {

	public static void main(String[] args) {
		Set<TstNode> st = new HashSet<>();
		st.add(new TstNode("a"));
		st.add(new TstNode("b"));
		st.add(new TstNode("A"));
		st.add(new TstNode("a",true));
		st.add(new TstNode("c",true));
		System.out.println(st);
		List<String> slst = st.stream().map( o -> o.name).collect(Collectors.toList());
		slst.forEach(e->System.out.println(e));
	}

}
class TstNode{
	String name = "";
	boolean isValid = false;
	
	public TstNode() {
		
	}
	public TstNode(String name) {
		this.name = name;
	}
	public TstNode(String name, boolean flg) {
		this.name = name;
		this.isValid = flg;
	}
	public int hashcode() {
		return name.hashCode();
	}
	public boolean equals(TstNode o) {
		if(o==null)
			return false;
		
		return this.name.equals(o.name) && this.isValid==o.isValid;
	}
	public String toString() {
		return this.name+","+this.isValid;
	}
}