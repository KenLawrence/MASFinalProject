package mas;

public class SpecialShow{

	private String desription;

	public SpecialShow() {
		
	}

	
	public String getDesription() {
		return desription;
	}

	public void setDesription(String desription) {
		validateString(desription);
		this.desription = desription;
	}


	  private void validateString(String str) {
			if (str == null) {
				throw new IllegalArgumentException("Name cannot be null!");
			}
			if (str.isEmpty()) {
				throw new IllegalArgumentException("Name must have 1 character or more");
			}
	    }

	@Override
	public String toString() {
		return "SpecialShow [desription=" + desription + "]";
	}
	
	
	
}
