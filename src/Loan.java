package projects;

public interface Loan 
{
	public abstract boolean isPhoneValid();
	
	public abstract boolean isPanValid();
	
	public abstract boolean isAadharValid();
	
	public abstract  double getLoanROI();
	
	public abstract int getCibilScore();
	
	public abstract int getCustomerAge();
	
	public abstract double getCustomerSalary();
	
	
}
