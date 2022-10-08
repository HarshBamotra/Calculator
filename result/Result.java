 //Harsh Bamotra 
//Program to convert a string expression and find the result for calculator project

package result;

public class Result
    {
	private String s;
		
	public Result(String se)
		{
			s=se;
		}	
	
	// utility method to remove elemets from a String array
	public String[] Remove(String arr[] , int n)	
		{						//n represent index here
			int l=arr.length , j=0;
			String temp[] = new String[l-1];
			for(int i=0 ; i<l ; i++)
				{
					if(i!=n)
						temp[j++]=arr[i];
				}
			return temp;
		}

	//utility method to check if a element is present in an array
	public boolean checkif(String arr[] , String e)
		{
			for(int i=0 ; i<arr.length ; i++)
					if(arr[i].equals(e))
						return true;
			return false;
		}
					
		

	public boolean[] FindErrors()
		{
			String arr[] = {"+,,x" , "+,,/" , "+,,+" , "-,,x" , "-,,/" , "-,,+" , "x,,x" , "x,,/" , "x,,+" , "/,,x" , "/,,/" , "/,,+"};
			boolean f1=false;
			boolean f2=false;
			if(s.contains(",,-,"))
				{
					s=s.replace(",,-,", ",-");
				}
			
			if(s.startsWith(",-,"))
				{
					s=s.replaceFirst(",-,", "-");
				}

			for(int j=0 ; j<12 ; j++)
				{
					if(s.contains(arr[j]))
						{
							f1=true;                   //-1 for expression error
							break;
						}
					if(s.contains("/,0"))
						{
							f2=true;                   //0 for divide by zero error
							break;
						}
				}
			return new boolean[] {f1 , f2};
		}

	public String[] Division(String op[])
		{
			Double x=0.0;
			int i=0;
			
			while(checkif(op , "/"))
				{
					if(op[i].equals("/"))
						{
							x = (Double.parseDouble(op[i-1]))/(Double.parseDouble(op[i+1]));
							op[i] = Double.toString(x);
							op = Remove(op , i-1);
							i--;
							op = Remove(op , i+1);
							i--;
						}
					i++;
				}
			return op;
		}
	
	public String[] Multiply(String op[])
		{
			Double x=0.0;
			int i=0;

			while(checkif(op , "x"))
				{
					if(op[i].equals("x"))
						{
							x = (Double.parseDouble(op[i-1]))*(Double.parseDouble(op[i+1]));
							op[i] = Double.toString(x);
							op = Remove(op , i-1);
							i--;
							op = Remove(op , i+1);
							i--;
						}
					i++;			
				}
			return op;
		}

	public String[] add(String op[])
		{
			Double x=0.0;
			int i=0;

			while(checkif(op , "+"))
				{
					if(op[i].equals("+"))
						{
							x = (Double.parseDouble(op[i-1]))+(Double.parseDouble(op[i+1]));
							op[i] = Double.toString(x);
							op = Remove(op , i-1);
							i--;
							op = Remove(op , i+1);
							i--;
						}
					i++;
				}
			return op;
		}

	public String[] sub(String op[])
		{
			Double x=0.0;
			int i=0;
		
			while(checkif(op , "-"))
				{
					if(op[i].equals("-"))
						{
							x = (Double.parseDouble(op[i-1]))-(Double.parseDouble(op[i+1]));
							op[i] = Double.toString(x);
							op = Remove(op , i-1);
							i--;
							op = Remove(op , i+1);
							i--;
						}
					i++;
				}
			return op;
		}

	public Double FindResult()
		{
			String op[] = s.split(",");
			op=Division(op);
			op=Multiply(op);
			op=add(op);
			op=sub(op);
			return Double.parseDouble(op[0]);
		}


	public static void main(String args[])
		{
			Result obj = new Result(",-,1,x,,-,2");
			if(obj.FindErrors()[0]==true)
				{
					System.out.println("Expression error !!");
				}
			else if(obj.FindErrors()[1]==true)
				{
					System.out.println("Divide by zero error !!");
				}
			else
				{
					System.out.println(obj.FindResult());
				}
		}
    }
			
			