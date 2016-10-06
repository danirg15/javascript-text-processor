package DFA;

public class FinalState implements State {
	private String name;

	public FinalState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "FinalState [name= " + name + "]";
	}
	
}
