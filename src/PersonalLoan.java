package projects;

public class PersonalLoan extends LoanImpl
{
	void getPersonalLaonDocInfo()
	{
		System.out.println("All the personal loan documents verified successfully !");
	}
	public static void main(String[] args) 
	{
		System.out.println("Welcome to your Personal Loan Banking !");
		
		PersonalLoan pl=new PersonalLoan();
		double salary=pl.getCustomerSalary();
		int age=pl.getCustomerAge();
		int cibil=pl.getCibilScore();
		if(salary>=900000.00 && age >=26 && (cibil>=300 && cibil <=900))
		{
			System.out.println("Basic Information is validated check personal details !");
			if(pl.isPhoneValid() && pl.isAadharValid() && pl.isPanValid())
			{
				System.out.println("Details are good and Loan got approved !");
				System.out.println("Your Laon ROI is : "+pl.getLoanROI());
				pl.getPersonalLaonDocInfo();
			}
			else
			{
				System.err.println("Something went wrong !");
			}
		}
		else
		{
			System.err.println("your not eligible for personal loan and your loan got rejected !");
		}
		

	}

}
