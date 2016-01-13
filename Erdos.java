import java.util.*;

public class Erdos {
	 public String[] number(String[] pubs) { // you write code here 
		 HashMap<String, Integer> authors=new HashMap<>();
		 authors.put("ERDOS", 0);
		 for(int x=0;x<pubs.length;x++){
			 HashMap<String,Integer> smallAuthors=new HashMap<>();
		 for(int i=0;i<pubs.length;i++){
			 String[] all=pubs[i].split(" ");
			 int min=pubs.length+1;
			 HashSet<String> newAuth=new HashSet<>();
             for(int j=0;j<all.length;j++){
            	 if((!authors.containsKey(all[j]))||authors.get(all[j])==-1){
            		 newAuth.add(all[j]);
            	 }         	 
            	 else{
            		 int a;
            		 if((a=authors.get(all[j]))<min){
            			 min=a;
            		 }
            	 }
             }
             if(!newAuth.isEmpty()){
             boolean check=false;
             if(newAuth.size()==all.length){
            	 check=true;
             }
		     Iterator<String> it=newAuth.iterator();
		     while(it.hasNext()){
		    	 String newguy=it.next();
		    	 if(check){
		    		 if(!smallAuthors.containsKey(newguy)){
		         smallAuthors.put(newguy, -1); 
		    		 }
		    	 }
		    	 else{
		    	 smallAuthors.put(newguy, min+1);
		     }
		 }
             }
		 }
		 Iterator<String> iter=smallAuthors.keySet().iterator();
		 while(iter.hasNext()){
			 String addthis=iter.next();
			 if(authors.containsKey(addthis)){
				authors.replace(addthis,-1, smallAuthors.get(addthis)); 
			 }
			 else{
			 authors.put(addthis, smallAuthors.get(addthis));
			 }
		 }
		 }
		 String[] number=finalArray(authors);
		 return number;
		 }
	/*
	 * This method gives out the final result according to the final version of HashMap
	 */
	 public String[]finalArray(HashMap<String,Integer> authors){
		 ArrayList<String>list=new ArrayList<>();
		 Iterator<String> it=authors.keySet().iterator();
		 while(it.hasNext()){
			 String thisguy=it.next();
			 String input;
			 if(authors.get(thisguy)==-1){
			 input=thisguy;
			 }
			 else{
			 input=thisguy+" "+authors.get(thisguy).toString();
			 }
			 list.add(input);
		 }
		 String[] result=new String[list.size()];
		 for(int i=0;i<result.length;i++){
			 result[i]=list.get(i);
		 }
		 Arrays.sort(result);
		 return result;
	 }
}
