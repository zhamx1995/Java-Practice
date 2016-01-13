import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class HighTechIncubator {
	 public String[] shameList(String[] location1, String[] location2, String[] location3) { 
		Set<String> loc1Set=sAToSet(location1);
		Set<String> loc2Set=sAToSet(location2);
		Set<String> loc3Set=sAToSet(location3);
		Set<String> shameSet=list(loc1Set,loc2Set);
		shameSet.addAll(list(loc1Set,loc3Set));
		shameSet.addAll(list(loc2Set,loc3Set));//add all person
		String names=collToS(shameSet);
		String[] nothing= new String[0];//setting none return
		if(names==""){
			return nothing;
		}
		String[] shameList=names.split(" ");
		 return shameList;
	 }
	 
	 
	  public Set<String> sAToSet(String[] s) {
		    // TODO: complete sToSet
			 Set<String> sAToSet=new TreeSet<String>();
			 for(int j=0;j<s.length;j++){
			 sAToSet.add(s[j]);
			 }
		    return sAToSet;
		  }
	  
	  public Set list(Set<String> a, Set<String> b) {//find out common people in two sets
			  Set<String> list=new TreeSet<String>();
			  Iterator<String> iterator = a.iterator();
				while (iterator.hasNext()) {
					String setEntry = iterator.next();
				if(b.contains(setEntry)){
					list.add(setEntry);
				}
				}
		    return list;
		  }
	  public String collToS(Collection<String> elems) {//transfer shameSet into string
		  String r ="";
			  if(elems.isEmpty()) return "";
			  for(String s:elems){
				  r+=" "+s;
			  }
		    return r.substring(1);
		  }
	  
}
