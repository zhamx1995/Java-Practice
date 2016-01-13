public class CountOccurrences {
	public int numberOccurrences(int number, int digit) {
	if (number<=0){
			System.out.println("invalid input of number");
		}
        if (digit==0){
        	System.out.println("invalid input of digit");
        }
        int numberOccurrences=0;
        String a=Integer.toString(number);
        int[] vector=new int[a.length()];
        		vector[0]=number;
        int i=0;
	    while(number>10){
	    	number=number/10;
	    	i++;
	    	vector[i]=number;
	    }
	    int check=vector[i];
	    if(check==digit){
	    	numberOccurrences++;
	    }
	    for(int j=i;j>=1;j--){
	    	check=vector[j-1]-vector[j]*10;
	    	if(check==digit){
	    	numberOccurrences++;
	    	}
	    }
		return numberOccurrences;
        
	
	}
	}
