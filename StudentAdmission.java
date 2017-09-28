import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentAdmission 
{
	String name;
	String email;
	long rollNo;
	String address;
	String phone;
	double hsc;
	double ug;
	
	public StudentAdmission() throws IOException
	{
		try{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.println("Roll No.:");
			rollNo=Long.parseLong(br.readLine());
			System.out.println("Name:");
			name=br.readLine();
			while(true)
			{
				System.out.println("phoneone Number:");
				phone=br.readLine();
				if(phone.length()==10)
				{
					
					break ;
				}
				System.out.println("*Invalid*");
			}
			while(true)
			{
				System.out.println("Email id:");
				email=br.readLine();
				if(email.contains("@") && email.endsWith(".com"))
				{
					break ;
				}
				System.out.println("*Invalid*");
			}
			System.out.println("Address:");
			address=br.readLine();
			System.out.println("HSC Marks(%):");
			hsc=Double.parseDouble(br.readLine());
			System.out.println("UG Marks(%):");
			ug=Double.parseDouble(br.readLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Caught "+e);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Caught "+e);
		}
		catch(NullPointerException e)
		{
			System.out.println("Caught "+e);
		}
	}
	void check()
	{
		if(hsc>=60 && ug>=70)
		{
			System.out.println("Eligible for National Institute");
		}
		else
		{
			System.out.println("Not Eligible for National Institute");
		}
	}
	public static void main(String args[])
	{
		try{
		StudentAdmission obj=new StudentAdmission();
		obj.check();
		}
		catch(IOException e)
		{
			System.out.println("Caught "+e);
		}
	}
}