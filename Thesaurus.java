import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Thesaurus {
	  public String[] edit(String[] entry) {
		    // TODO: Convert entries from array of Strings to ArrayList of Sets
		  ArrayList<Set<String>> entryList = new ArrayList<Set<String>>();  
		  for(int k=0;k<entry.length;k++){
		    	Set nowset=sToSet(entry[k]);
		    	entryList.add(nowset);
		    }
		  for(int d=0;d<10;d++){
			  int y=1;
		  for(int m=0;m<entryList.size();m++){
		    	for(int n=0;n<entryList.size();n++){
		    		if(n<entryList.size()&&m<entryList.size()&&n!=m){
		    		Set<String>a = entryList.get(m);
		    		Set<String>b = entryList.get(n);               
		    		int parameter=numInCommon(a,b);
		    	if(parameter>=2){
		    	Set<String> combined=union(a,b);
		    	entryList.add(combined);
		    	entryList.remove(a);
		    	entryList.remove(b);
		    	y=0;
		    		}
		    		}
		    	}  		
		    }
		  if(y==1){
			  break;
		  }
		  }
		  
		    String[] edit=new String[entryList.size()]; 
		    for(int x=0;x<entryList.size();x++){
		    	Set<String> thisset=entryList.get(x);
		    	String thisstring=collToS(thisset);
		    edit[x]=thisstring;
		    }
            Arrays.sort(edit);
		    /*
		     * TODO: Keep merging entries until nothing gets merged
		     * 
		     * Pseudocode:
		     * 
		     * While merging still needed
		     *   Let n be the number of elements in entrySet
		     *   For every pair (i,j) where 0 <= i,j < n and i < j
		     *      if entrySet[i] and entrySet[j] have >= 2 in common
		     *          merge entrySet[i] and entrySet[j]
		     */

		    // TODO: Convert list of Sets to an array of Strings
		    
		    // TODO: Sort entries in alphabetical order
            //String check=edit.toString();

		    return edit;
		}
	//public String[] edit(String[] entry) { 
		/**
		   * Converts the elements of a String to a set. The format of a n-word String should be
		   * "word1 word2 word3... wordn" That is, each word should be separated by exactly one space and
		   * there should be no leading or trailing spaces.
		   * 
		   * @param s words with individual spaces separating words
		   * @return elements of s as a Set
		   */
	//for(int i=0;i<entry.length;i++){
		//String s=entry[i];
	//}
	
	//}
		  public Set<String> sToSet(String s) {
		    // TODO: complete sToSet
			 Set<String> sToSet=new TreeSet<String>();
			 String[] separate=s.split(" ");
			 for(int j=0;j<separate.length;j++){
			 sToSet.add(separate[j]);
			 }
		    return sToSet;
		  }
		

		  /**
		   * Converts the elements in a collection to a space-separated list. That is, if the collection
		   * contains [A, B, C, D], the method should return "A B C D". There should be no leading or
		   * trailing spaces
		   * 
		   * @return the elements of elems as a space-separated String
		   */
		  public String collToS(Collection<String> elems) {
		    // TODO: complete collToS
			  //if(elems.isEmpty())return "";
			  String r ="";
			  for(String s:elems){
				  r+=" "+s;
			  }
		    return r.substring(1);
		  }


		  /**
		   * Returns the number of elements contained in both sets. The sets passed in should not be
		   * changed.
		   * 
		   * @param a a set of words
		   * @param b another set of words
		   * @return number of elements in common to a and b
		   */
		  public int numInCommon(Set<String> a, Set<String> b) {
		    // TODO: complete numInCommon
			  int numInCommon=0;
			  Iterator<String> iterator = a.iterator();
				while (iterator.hasNext()) {
					String setEntry = iterator.next();
				if(b.contains(setEntry)){
					numInCommon++;
				}
				}
		    return numInCommon;
		  }


		  /**
		   * Creates a new set that is the union of the given sets. The union of two sets is the set that
		   * contains all of the elements of both sets.
		   * 
		   * Important: The sets passed in should not be modified.
		   *
		   * @param a a set of words
		   * @param b another set of words
		   * @return union of sets a and b
		   */
		  public Set<String> union(Set<String> a, Set<String> b) {
		    // TODO: complete union
			  Set<String> union=new TreeSet<String>();
			  union.addAll(a);
			  union.addAll(b);
			  
		    return union;
		  }

		  /**
		   * Creates an edited version of Thesaurus entries.
		   * 
		   * If any two entries have 2 or more words in common then they should be combined into a single
		   * entry. The final Thesaurus must contain no pair of entries that have 2 or more words in common.
		   * Each entry must contain no duplicates. The words within each element of the returned value must
		   * be in alphabetical order, and the elements must appear in alphabetical order
		   * 
		   * @param entry each element is a list of words that are all synonyms
		   * @return edited version of Thesaurus entries
		   */

}
