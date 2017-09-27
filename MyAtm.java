import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.HashMap;


//import javax.swing.JOptionPane;

 class MyAtm 
{
	String accNo;
	int pin;
	int bal;
	int check=0;
	public MyAtm()
	{
		try
		{ 
			Scanner sc=new Scanner(System.in);
			System.out.print("\nEnter your account number:");
			accNo=sc.nextLine();
			System.out.print("\nEnter your PIN number:");
			pin=sc.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.print("\nEnter the valid input");
		}
		catch(NumberFormatException e)
		{
			System.out.print("\nConversion not valid");
		}
	}
	void deposit(int n)
	{
		this.bal+=n;
	}
	void withdrawl(int n)
	{
		this.bal-=n;
	}
	void display()
	{
		System.out.println("\nTotal bal : "+this.bal);
	}
	public static void main(String args[])throws ClassNotFoundException
	{
		
		Map<String,Integer> mp=new HashMap<String,Integer>(); 
		mp.put("abcd", 1234);
		mp.put("efgh", 5678);
		mp.put("ijkl",9101);
		mp.put("mnop",1123);
		
		Scanner sc=new Scanner(System.in);
		MyAtm obj=new MyAtm();
		
		try{
			int am,amt;
			for(Map.Entry<String,Integer> entry : mp.entrySet())
			{
				if( obj.accNo.equals(entry.getKey()) && obj.pin==entry.getValue())
				{
					obj.check++;
					while(true)
					{
						System.out.println("\nEnter Your Choice: 1.Deposit 2.Withdrawl 3.Show bal 4.Exit");
						int n=sc.nextInt();
						switch(n)
						{
						case 1:
							System.out.print("\nAmount:");
							am=sc.nextInt();
							obj.deposit(am);
							break;
						case 2:
							System.out.print("\nAmount:");
							amt=sc.nextInt();
							obj.withdrawl(amt);
							break;
						case 3:
							obj.display();
							break;
						case 4:
							System.exit(1);
							break;
						}
					}
					
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("\nNo operation is performed with null string");
		}
		catch(InputMismatchException e)
		{
			System.out.print("\nEnter the valid input");
		}
		catch(NoSuchElementException e)
		{
			System.out.print("\nElement not found");
		}

		if(obj.check==0)
		{
			//JOptionPane.showMessageDialog(null, "INVALID PIN NUMBER", "Warning",JOptionPane.WARNING_MESSAGE);
			System.out.println("\nINVALID PIN NUMBER");
		}
	}
}