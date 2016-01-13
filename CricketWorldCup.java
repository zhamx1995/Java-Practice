import java.util.*;

public class CricketWorldCup {
	public String[] standings(String[] teams, String[] eliminatedBy) { // fill in code here 
	String[] standings= new String[teams.length];
	/*
	 * These codes build a map. It defaults every team as 0, and add the value of wins for each one.
	 */
	HashMap<String,Integer> wins=new HashMap<>();
	for(int k=0;k<teams.length;k++){
		wins.put(teams[k], 0);
	}
	for(int i=0;i<eliminatedBy.length;i++){
		if(!eliminatedBy[i].equals("")){
			String now=eliminatedBy[i];
			int number=wins.get(now);
			wins.replace(eliminatedBy[i], number, number+1);
		}
	}
	//create a map so that it is easier to find out who wins an individual
	HashMap<String,String> matches=new HashMap<>();
	for(int j=0;j<teams.length;j++){
		matches.put(teams[j], eliminatedBy[j]);
		standings[j]=teams[j];//BTW: put teams in "standings" randomly, later sorted by Comparator
	}
		
    class comp implements Comparator<String>{
    	public int compare(String x, String y){
    		if(wins.get(x)<wins.get(y)||y==""){
    			return 1;
    		}
    		else if(wins.get(y)<wins.get(x)||x==""){
    			return -1;
    		}
    		else{
    			String a=matches.get(x);
    			String b=matches.get(y);
    			return compare(a,b);//recursion of comparing, going back to who wins them
    		}	
    	}
    }
    Arrays.sort(standings, new comp()); 
	return standings;
	}
}
