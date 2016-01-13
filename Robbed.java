import java.util.*;

public class Robbed {
	boolean hori;//true for right
	boolean verti;//true for up
	boolean allset;//whether all routes reaches the destination
	int height;
    int width;
	
	public int countRoutes (String[] maze) {
    //initialize the matrix
    HashSet<ArrayList<Integer>> blockset=new HashSet<>();
    ArrayList<Integer> cloc=new ArrayList<>();
    ArrayList<Integer> rloc=new ArrayList<>();
    height=maze.length;
    for(int i=0;i<height;i++){//i is pai
    	String thisline=maze[i];
    	width=thisline.length();
    	for(int j=0;j<width;j++){//j is lie
    		char[] lineArray=thisline.toCharArray();
    		ArrayList<Integer> locnow=new ArrayList<>();
    	if(lineArray[j]=='X'){
    		locnow.add(i);
    		locnow.add(j);
    		if(!locnow.isEmpty()){
    		blockset.add(locnow);
    		}
    	}
    	else if (lineArray[j]=='R'){
    		rloc.add(i);
    		rloc.add(j);
    	}
    	else if(lineArray[j]=='C'){
    		cloc.add(i);
    		cloc.add(j);
    	}
    	}
    }
    
    if(cloc.get(0)>rloc.get(0)){
    	verti=true;
    }
    else{
    	verti=false;
    }
    if(cloc.get(1)>rloc.get(1)){
    	hori=true;
    }
    else{
    	hori=false;
    }
    
    ArrayList<ArrayList<Integer>> input=new ArrayList<>();
    input.add(rloc);
    ArrayList<ArrayList<Integer>> finalresult=go(input,cloc,blockset);
    return finalresult.size();
	}
	
	public ArrayList<ArrayList<Integer>> go(ArrayList<ArrayList<Integer>>input, ArrayList<Integer> cloc,HashSet<ArrayList<Integer>> blockset){		
		if(allset){
			return input;
		}
		ArrayList<ArrayList<Integer>> addToInput=new ArrayList<>();
		for(ArrayList<Integer> a:input){
			ArrayList<ArrayList<Integer>> result=next(a);//two possible next position
			ArrayList<ArrayList<Integer>> delete=new ArrayList<>();
			for(ArrayList<Integer> b:result){
				if(blockset.contains(b)){
					delete.add(b);
				}
			}
			result.removeAll(delete);
			addToInput.addAll(result);
		}
		if(addToInput.isEmpty()){
			 ArrayList<ArrayList<Integer>> empty =new ArrayList<>();
			return empty;
		}
		input.clear();
		input.addAll(addToInput);
		
		ArrayList<ArrayList<Integer>> change= new ArrayList<>();
		for(ArrayList<Integer> c:input){
			if(c.equals(cloc)){
				change.add(c);
			}
		}
		if(!change.isEmpty()){
			allset=true;
			input.clear();
			input.addAll(change);
		}
		return go(input,cloc,blockset);
		
	}
	
	public ArrayList<ArrayList<Integer>> next(ArrayList<Integer> loc){
	ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	int pai=loc.get(0);
	int lie=loc.get(1);
	ArrayList<Integer> vertic=new ArrayList<>();
	ArrayList<Integer> horiz=new ArrayList<>();
	if(verti&&(pai+1<height)){
		vertic.add(pai+1);
		vertic.add(lie);
	}
	else if ((!verti)&&(pai-1>=0)){
		vertic.add(pai-1);
		vertic.add(lie);
	}
	if(hori&&(lie+1<width)){
		horiz.add(pai);
		horiz.add(lie+1);
	}
	else if((!hori)&&(lie-1>=0)){
		horiz.add(pai);
		horiz.add(lie-1);
	}
	if(!vertic.isEmpty()) result.add(vertic);
	if(!horiz.isEmpty()) result.add(horiz);
	return result;
	}
}
