import java.util.*;
public class WordLinks {
		public String isLinked(String[] inner, String from, String to) { // fill in code here
		List<String> words=new ArrayList<>();
		for(int i=0;i<inner.length;i++){
			words.add(inner[i]);
		}//create ArrayList, later easy to remove one item
		if(isStep(from,to)&&links(from, inner)==inner.length){
			return "none";
		}
		for(String s : words){
		if(isStep(from,s)){
			List<String> copy = new ArrayList<String>(words); 
			copy.remove(s);
			if(isStep(s,to)){
				return "ladder";
			}
			String[] newinner=new String[copy.size()];
			for(int j=0;j<copy.size();j++){
				newinner[j]=copy.get(j);
			}//transform list into array, used for recursion
			if(isLinked(newinner, s, to).equals("ladder")){
				return "ladder";
			}
		}
		} 
		return "none";
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
			//This method tests the number of words in the array that is one letter from the given String
			public int links(String from, String[] inner){
				int links=0;
				for(int i=0;i<inner.length;i++){
					if(isStep(from,inner[i])){
						links++;
				}
				}
				return links;
			}

}
