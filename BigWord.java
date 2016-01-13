import java.util.HashMap;
import java.util.Iterator;

public class BigWord {
	public String most(String[] sentences) {
		HashMap words= new HashMap();
		for(int i=0;i<sentences.length;i++){
		String[] separate=sentences[i].split(" ");
		for(int j=0;j<separate.length;j++){
			separate[j]=separate[j].toLowerCase();
			if(words.containsKey(separate[j])){
				int k=words.get(separate[j]).hashCode();
				words.replace(separate[j], k, k+1);
			}
			else{
				words.put(separate[j], 1);
			}
		}
		
		}
		int maxValue=0;
		String most=null;
		Iterator iterator = words.entrySet().iterator();
		while (iterator.hasNext()) {
			HashMap.Entry mapEntry = (HashMap.Entry) iterator.next();
			int value=(int) mapEntry.getValue();
			if(value>maxValue){
				maxValue=value;
			most=(String) mapEntry.getKey();
			}
		}
	   return most;
		
	}
}
