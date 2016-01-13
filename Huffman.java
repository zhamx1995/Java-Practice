import java.util.*;

public class Huffman {
	public String translate(String encoded, String[] dictionary) { // fill in code here 
		String[] alphabet={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		HashMap<String,String> transform=new HashMap<>();
		for(int i=0;i<dictionary.length;i++){
			transform.put(dictionary[i], alphabet[i]);
		}
	        int start = 0;
	        StringBuilder search = new StringBuilder(encoded);
	        String translate="";
	        int a=0;
	        String replace=dictionary[a];
	        int debug=0;
	       while(true){
	        while ((debug=search.indexOf(replace, start)) >= 0) {
	        	if(debug!=start){
	        		break;
	        	}
	            start += replace.length();
	            translate+=transform.get(replace);
	        }
	        if (start < search.length()) {
	        	if(a==dictionary.length-1){
	        		a=0;
	        	}
	        	else{
	        		a=a+1;
	        	}
	        	replace=dictionary[a];
	        }
	        else{
	        	break;
	        }
	       }
	        return translate;
	    }	
}
