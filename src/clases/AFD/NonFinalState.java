package AFD;

public class NonFinalState implements State {
	private String name;

	public NonFinalState(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "NonFinalState [name= " + name + "]";
	}
	
}

