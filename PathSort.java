import java.util.Arrays;
import java.util.Comparator;


public class PathSort {

public String[] sortPath(String[] dire) {
	for(int i=0;i<dire.length;i++){
		String now=dire[i].toLowerCase();
		dire[i]=now;
	}
	
    class comp implements Comparator<String>{
    	
    	public int compare(String x, String y){
    		String[] xa=x.split("/");
    		String[] ya=y.split("/");
    		if(xa.length<ya.length){
    			return -1;
    		}
    		else if(ya.length<xa.length){
    			return 1;
    		}
    		else{
    			return x.compareTo(y);
    		}
    	}  	
    }
	String[] sortPath=new String[dire.length];
	for(int i=0;i<sortPath.length;i++){
		sortPath[i]=dire[i];
	}
	Arrays.sort(sortPath, new comp());
	
	return sortPath;
	}

}
