
public class DNAMutate {

	public static String mutate(String dna)  {
		// TODO Auto-generated method stub
		//String mutate=null;
		char[] arrayVersion1=dna.toCharArray();
		int a=dna.length();
		String mutate=dna; 
		char[] arrayVersion2=mutate.toCharArray();
		for (int i=0;i<=a-1;i++){
		arrayVersion2[i]=arrayVersion1[a-1-i];
		mutate=new String(arrayVersion2);
		}
		return mutate;
	}
	
	public static void main(String[] args){
		String input = "ATCGGCATACT";
		System.out.println(mutate(input));
	
	}

}
