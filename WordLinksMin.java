import java.util.*;

public class WordLinksMin {
	public int[] minLinks(String[] inner, String from, String to) { 
	    ArrayList<String> allwords=new ArrayList<>();
		for(int i=0;i<inner.length;i++){
			allwords.add(inner[i]);
		}//create ArrayList, later easy to remove one item
       int[] result=new int[2];
		HashSet<String> firstSet=new HashSet<>();
		for(int i=0;i<inner.length;i++){
			if(isStep(from,inner[i])){
                firstSet.add(inner[i]);//put all first steps into the "inner"
				}
			}
		if(firstSet.isEmpty()){//if nothing in the "inner" links to "from"
			result[0]=0;
			result[1]=0;
			return result;
		}
		
       boolean go=true;
       ArrayList<String> updateList=new ArrayList<>();
       updateList.add(from);
       int times=3;//one for "from", one for "to", and at least one in the "inner"; ++ at the end of while
       while(go){
    	   //copy the allwords, and remove words that are being used in isStep
    	   ArrayList<String> copyall=new ArrayList<>();
    	   for(String word:allwords){
    		   copyall.add(word);
    	   }
    	   for(int k=0;k<updateList.size();k++){
    		   copyall.remove(updateList.get(k));
    	   }
    	   //add all possible words together
    	   ArrayList<String> newone=new ArrayList<>();
    	   for(String a:updateList){
    		   for(String c:copyall){
    			   if(isStep(a,c)){
    				   newone.add(c);
    			   }
    		   }
    	   }
   		if(newone.isEmpty()){
			result[0]=0;
			result[1]=0;
			return result;
		}
   		int satisfyNum=0;//number of words that link to "to"
        for(String b:newone){
        	if(isStep(b,to)){
        		satisfyNum++;
        	}
        }
        if(satisfyNum!=0){
			result[0]=times;
			result[1]=satisfyNum;
            go=false;
        }
  	   updateList=newone;//update the "updateList"
       times++;
       }
       return result;
		}
		//this method checks if the two Strings only have one different letter
			public boolean isStep(String worda, String wordb){
				boolean isStep=false;
				char[] aa=worda.toCharArray();
				char[] ba=wordb.toCharArray();
				int count=0;
				for(int i=0;i<aa.length;i++){
					if(aa[i]!=ba[i]){
						count++;
					}
				}
				if(count==1){
					isStep=true;
				}
				return isStep;
			}


}
