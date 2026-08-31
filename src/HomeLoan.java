package projects;

public class HomeLoan extends LoanImpl 
{
	void getHomeLaonDocInfo()
	{
		System.out.println("All the Home loan documents verified successfully !");
	}
	@Override
    public double getLoanROI()
	{
		double roi=6.5;
		int cibil=getCibilScore();
		if(cibil>=300 && cibil <=549)
		{
			System.out.println("High risk; loan applications are likely to be rejected or approved at high interest rates");
			roi=roi+4.0;
		}
		else if(cibil >=550 && cibil <=699 )
		{
			System.out.println("Fair – Moderate risk; may face limitations in credit approval");
			roi=roi+2.0;
		}
		else if (cibil >=700 && cibil <=749)
		{
			System.out.println("Good – Low risk; better chances of loan approval with favorable terms");
			roi=roi+1.5;
		}
		else if(cibil >=750 && cibil <=900)
		{
			System.out.println("Excellent – Very low risk; highest likelihood of approval and access to lower interest rates");
			roi=roi+0.5;
		}
		else {
			System.out.println("Invalid cibil score !! Can You connect with relationship manager of your bank");
			roi=roi+10.0;
		}
		return roi;
	}

	public static void main(String[] args) 
	{
		System.out.println("Welcome to your Home Loan Banking !");
		
		HomeLoan hl=new HomeLoan();
		double salary=hl.getCustomerSalary();
		int age=hl.getCustomerAge();
		int cibil=hl.getCibilScore();
		if(salary>=800000.00 && age >=25 && (cibil>=300 && cibil <=900))
		{
			System.out.println("Basic Information is validated check personal details !");
			if(hl.isPhoneValid() && hl.isAadharValid() && hl.isPanValid())
			{
				System.out.println("Details are good and Loan got approved !");
				System.out.println("Your Laon ROI is : "+hl.getLoanROI());
				hl.getHomeLaonDocInfo();
			}
			else
			{
				System.err.println("Something went wrong !");
			}
		}
		else
		{
			System.err.println("your not eligible for Home loan and your loan got rejected !");
		}
	}

}
