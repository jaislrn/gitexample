package sh;

@Readme(value="Arithmetic class", info="demo purpose", author="Nilesh")
public class Arithmetic {
	@Readme(value="Arithmetic class field", author="Nilesh")	
	private int field1;
	@Readme(value="Arithmetic class field")
	private int field2;
	@Readme("Arithmetic class field")	
	private int field3;
	
	//@Readme
	public Arithmetic() {
		// TODO Auto-generated constructor stub
	}
	
	@Readme(value="add method", info="demo purpose", author="Nilesh")	
	public Integer add(Integer a, Integer b) {
		return a + b;
	}
	private Integer multiply(Integer a, Integer b) {
		return a * b;
	}
}
