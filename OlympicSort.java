import java.util.*;

public class OlympicSort {
	 public String[] standings(String[] results) { // you fill in this code 
		 HashMap<String,ArrayList<Integer>> mapMedal=buildMap(results);	 
	    
		    class comp implements Comparator<String>{	 
	    	public int compare(String m, String n){
	    		String x=m.split(" ")[0];
	    		String y=n.split(" ")[0];
	    		//compare gold medals
	    		if(mapMedal.get(x).get(0)<mapMedal.get(y).get(0)){
	    			return 1;
	    		}
	    		else if(mapMedal.get(x).get(0)>mapMedal.get(y).get(0)){
	    			return -1;
	    		}
	    		else{
	    			//compare silver medals
		    		if(mapMedal.get(x).get(1)<mapMedal.get(y).get(1)){
		    			return 1;
		    		}
		    		else if(mapMedal.get(x).get(1)>mapMedal.get(y).get(1)){
		    			return -1;
		    		}
		    		else{
		    			//compare bronze medals
			    		if(mapMedal.get(x).get(2)<mapMedal.get(y).get(2)){
			    			return 1;
			    		}
			    		else if(mapMedal.get(x).get(2)>mapMedal.get(y).get(2)){
			    			return -1;
			    		}
			    		else{
			    			//compare alphabetically
			    			return x.compareTo(y);	
			    		}			    			    			
		    		}
	    		}
	    		
	    	}
	    }
		 String[] standings=arraybuild(mapMedal);
		 Arrays.sort(standings, new comp());
	 return standings;
	 }
	 
	 
	 public HashMap<String,ArrayList<Integer>> buildMap(String[] input){
		 HashMap<String,ArrayList<Integer>> buildMap=new HashMap<>();
		 for(int i=0;i<input.length;i++){
			 String[] nowGuo=input[i].split(" ");//split nowGuo into 3 countries
			 for(int j=0;j<3;j++){
			 if(buildMap.containsKey(nowGuo[j])){
				 int medals=buildMap.get(nowGuo[j]).get(j);
				 int correct=medals+1;
				 buildMap.get(nowGuo[j]).set(j, correct);
			 }
			 else{
				 ArrayList<Integer> addin=new ArrayList<>();
				 addin.add(0);
				 addin.add(0);
				 addin.add(0);//create three 0 first, then change
				 addin.set(j, 1);
				 buildMap.put(nowGuo[j],addin);
			 }
		 }		 
		 }	 
		 return buildMap;
	 }
	 
	 public String[] arraybuild(HashMap<String,ArrayList<Integer>> map){
		 String[] arraybuild=new String[map.keySet().size()];
		 int i=0;
		 for(String s:map.keySet()){
			 arraybuild[i]=s+" "+map.get(s).get(0)+" "+map.get(s).get(1)+" "+map.get(s).get(2);//line up medals after country name
			 i++;
		 }
		 return arraybuild;
	 }
}
