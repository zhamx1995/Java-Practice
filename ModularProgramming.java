import java.util.*;

public class ModularProgramming {
	public int[] modules(String[] dependencies) {
		HashSet<ArrayList<Integer>> set=new HashSet<>();
    for(int i=0;i<dependencies.length;i++){
    	ArrayList<Integer> loc=new ArrayList<>();
    	loc.add(i);
    	ArrayList<Integer> finalloc=all(loc,dependencies);
    	ArrayList<Integer> sortedList=sortlist(finalloc);
    	if(!set.contains(sortedList)){
    		set.add(sortedList);
    	}
    }
        int[] modules=cases(set);
		Arrays.sort(modules);
		return modules;
	}
	public ArrayList<Integer> all (ArrayList<Integer> update, String[] dependencies){
//		ArrayList<Integer> old=new ArrayList<>();
		ArrayList<Integer> addition=new ArrayList<>();
		for(int i=0;i<update.size();i++){
			int expandthis=update.get(i);
			String[] parts=dependencies[expandthis].split(" ");
			if(!parts[0].equals("")){
			for(int j=0;j<parts.length;j++){
				int a=Integer.valueOf(parts[j]);
				if((!update.contains(a))&&(!addition.contains(a))){
					addition.add(a);
				}
			}
			}
		}
		for(Integer m:addition){
			update.add(m);
		}
		if(addition.isEmpty()){
			return update;
		}
		else{
			return all(update,dependencies);
		}
	}

	public int[] cases(HashSet<ArrayList<Integer>> set){
		ArrayList<Integer> numbers=new ArrayList<>();
		HashMap<Integer,Integer> findLargest=new HashMap<>();
		for(ArrayList<Integer> addthis:set){
			numbers.add(addthis.size());
			if(!findLargest.containsKey(addthis.size())){
			findLargest.put(addthis.size(),1);
			}
			else{
				int times=findLargest.get(addthis.size());
				findLargest.replace(addthis.size(),times, times+1);
			}
		}
		Iterator<Integer> it=findLargest.keySet().iterator();
		int largest=0;
		int targetKey=-1;
		while(it.hasNext()){
			int check=it.next();
			if(findLargest.get(check)>largest){
				largest=findLargest.get(check);
				targetKey=check;
			}
		}
		if(largest>(numbers.size()/2)){
			ArrayList<Integer> removelist=new ArrayList<>();
			for(int i=0;i<largest;i++){
					removelist.add(targetKey);
			}
			numbers.removeAll(removelist);
		}
		else{
			largest=0;
		}

		ArrayList<ArrayList<Integer>> initial=new ArrayList<>();
		int[] lengthArray=new int[numbers.size()];
		for(int i=0;i<lengthArray.length;i++){
			lengthArray[i]=i;
		}
		ArrayList<ArrayList<Integer>> combi=allcombi(initial,lengthArray);
		int[] modules=getresult(combi,numbers,targetKey,largest);
		return modules;
	}
	public ArrayList<ArrayList<Integer>> allcombi(ArrayList<ArrayList<Integer>> input, int[] allnum){
		if(allnum.length==0){
			return input;
		}
		if(input.isEmpty()){
		for(int addthis:allnum){
			ArrayList<Integer> firstinput=new ArrayList<>();
			firstinput.add(addthis);
			input.add(firstinput);
		}
		return allcombi(input,allnum);
		}
		else if(input.size()==Math.pow(2,allnum.length)-1){
			return input;
		}
		else{
			HashSet<ArrayList<Integer>> updateinput=new HashSet<>();
		for(ArrayList<Integer> onecombi:input){
			ArrayList<Integer> left=new ArrayList<>();
			for(int i=0;i<allnum.length;i++){
				left.add(allnum[i]);
			}
			for(int exist:onecombi){
				if(left.contains(exist)){
					left.remove((Object)exist);
				}
			}
			for(int addthis:left){
				ArrayList<Integer> addnew=new ArrayList<>();
				addnew.addAll(onecombi);
				addnew.add(addthis);
				addnew=sortlist(addnew);
				if((!input.contains(addnew))&&(!updateinput.contains(addnew))){
				updateinput.add(sortlist(addnew));
				}
			}
		}
			input.addAll(updateinput);
		return allcombi(input,allnum);
		}
	}
	
	public int[] getresult(ArrayList<ArrayList<Integer>> combi,ArrayList<Integer> numbers,int sizeKey, int times){
//		int[] result=new int[combi.size()];
//		int i=0;
		ArrayList<Integer> result=new ArrayList<>();
		if(!numbers.isEmpty()){
		for(ArrayList<Integer> findsum:combi){
			int sum=0;
			for(int addition:findsum){
				sum+=numbers.get(addition);
			}
			result.add(sum);
		}
		}
		if(times!=0){
			result.add(0);
		ArrayList<Integer> addItems=new ArrayList<>();
		for(int sumup:result){
			for(int i=1;i<=times;i++){
				int lastAdd=sumup+i*sizeKey;
				addItems.add(lastAdd);
			}	
		}
		result.addAll(addItems);
		result.remove((Object)0);
		}
		HashSet<Integer> filter=new HashSet<>();
		filter.addAll(result);
		int i=0;
		int[] output=new int[filter.size()];
		for(int each:filter){
			output[i]=each;
			i++;
		}
		return output;
	}
	public ArrayList<Integer> sortlist(ArrayList<Integer> origin){
    	int[] finalArray=new int[origin.size()];
    	for(int n=0;n<origin.size();n++){
    		finalArray[n]=origin.get(n);
    	}
        Arrays.sort(finalArray);
        ArrayList<Integer> sortedList=new ArrayList<>();
        for(int m=0;m<finalArray.length;m++){
        	sortedList.add(finalArray[m]);
        }
		return sortedList;
	}
	
}
