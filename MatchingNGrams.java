import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class MatchingNGrams {
	public int totalMatches(String[] ngrams) {
		ArrayList<int[]> list=new ArrayList<int[]>();//list to change letters into numbers
		HashMap calc=new HashMap();//map to calculate sum of Cn2
		for(int i=0;i<ngrams.length;i++){
			int[] nowInts=stringToInts(ngrams[i]);
			list.add(nowInts);//loop every string,change into int[],store in arraylist
		}
		
       for(int j=0;j<list.size()-1;j++){
    	   int[] first=list.get(j);
    	   calc.put(first, 1);//this one must be different from previous ones
    	   for(int k=j+1;k<list.size();k++){
    		   int[] second=list.get(k);
           if(check(first,second)){
               int p=calc.get(first).hashCode();
               calc.replace(first,p, p+1);//increment of counting in the same int[]
        	   list.remove(second);
        	   k--;
//list is shorted by removal,k should stay at the same position for next test
           }
		   if(k==list.size()-1&&check(first,second)==false){
			   calc.put(second,1);//if the last one is not the same as last-1,set it as 1
		   }
    	   }
       }
       int totalMatches=calculation(calc);
		return totalMatches;
	}
	
	
	public int[] stringToInts(String s){//change chars in a string into array of numbers by assigning them into hashmap
		HashMap stringToMap= new HashMap();
		char[] c=s.toCharArray();
		int[] stringToInts=new int[c.length];
		int j=0;
		for(int i=0;i<c.length;i++){
			int k=0;
			if(stringToMap.containsKey(c[i])){
				k=stringToMap.get(c[i]).hashCode();//if the same letter existed, use the same value
			}
			else{
				stringToMap.put(c[i], j);
				k=j;//if not, assign new value with increment of 1
				j++;
		}
			stringToInts[i]=k;
		}
		stringToMap.clear();
		return stringToInts;
	}
	
	
	public boolean check(int[] first,int[] second){
		boolean check=true;
		for(int i=0;i<first.length;i++){
			int value1=first[i];
			int value2=second[i];
				if(value1!=value2){//compare the number on same position in two int[]
					check=false;
					break;//if there's one value not the same,no need check the rest
				}
			}
		return check;
	}

	public int calculation(HashMap map){
		int calculation=0;
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			HashMap.Entry mapEntry = (HashMap.Entry) iterator.next();
			int number=(int) mapEntry.getValue();
			if(number>2){
            calculation+=number*(number-1)/2;//Cn2
			}
			if(number==2){
				calculation++;//C22=1
			}
		}
		return calculation;
	}

	
}
