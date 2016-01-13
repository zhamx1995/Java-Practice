import java.util.*;


public class OldKing {
	public String kingPath(int n, String initSquare) {
		String[] startloc=initSquare.split("");
		int paistart=Integer.valueOf(startloc[1]);
		int liestart=StringtoNum(startloc[0]);
		HashSet<ArrayList<ArrayList<Integer>>> routes=new HashSet<>();
		ArrayList<ArrayList<Integer>> beginloc=new ArrayList<>();
		ArrayList<Integer> kaishi=new ArrayList<>();
		kaishi.add(liestart);
		kaishi.add(paistart);
		beginloc.add(kaishi);
		routes.add(beginloc);

		routes=allpossi(routes,n);
		String[] paths=listToArray(routes);
//		Arrays.sort(paths);
		return paths[paths.length-1];
	}
	
	public int StringtoNum(String a){
		int num=0;
		if(a.equals("a")) num=1;
		else if(a.equals("b")) num=2;
		else if(a.equals("c")) num=3;
		else if(a.equals("d")) num=4;
		else if(a.equals("e")) num=5;
		else if(a.equals("f")) num=6;
		else if(a.equals("g")) num=7;
		else if(a.equals("h")) num=8;
		return num;
	}
	
	public HashSet<ArrayList<ArrayList<Integer>>> allpossi(HashSet<ArrayList<ArrayList<Integer>>> input, int length){
		HashSet<ArrayList<ArrayList<Integer>>> addthis=new HashSet<>();
		HashSet<ArrayList<ArrayList<Integer>>> removelist=new HashSet<>();
		for(ArrayList<ArrayList<Integer>> loc:input){
			if(loc.size()==length*length){
				return input;
			}
			else{
				HashSet<ArrayList<ArrayList<Integer>>> branch=extend(loc,length);
				if(!branch.isEmpty()){
				addthis.addAll(branch);
				removelist.add(loc);
				}
			}
		}
		input.removeAll(removelist);
		if(addthis.isEmpty()){
			return input;
		}
		else{
		input.addAll(addthis);
		return allpossi(input,length);
		}
	}
	public HashSet<ArrayList<ArrayList<Integer>>> extend(ArrayList<ArrayList<Integer>> routeOld, int length){
		ArrayList<Integer> locLast=routeOld.get(routeOld.size()-1);
		int oldlie=locLast.get(0);
		int oldpai=locLast.get(1);
		HashSet<ArrayList<Integer>> allNewLasts=new HashSet<>();
		boolean[] continues=new boolean[3];
		if(oldlie+1<=length){
			ArrayList<Integer> newLast=new ArrayList<>();
			newLast.addAll(locLast);
			newLast.set(0,oldlie+1);
			if(notAppeared(newLast,routeOld)){
				allNewLasts.add(newLast);
				continues[0]=true;
				continues[1]=true;
				continues[2]=true;
			}
		}
		if(!continues[0]){
			if(oldpai+1<=length){
				ArrayList<Integer> newLast=new ArrayList<>();
				newLast.addAll(locLast);
				newLast.set(1,oldpai+1);
				if(notAppeared(newLast,routeOld)){
					allNewLasts.add(newLast);
					continues[1]=true;
					continues[2]=true;
				}
			}
		}
		
		if(!continues[1]){
			if(oldpai-1>=1){
				ArrayList<Integer> newLast=new ArrayList<>();
				newLast.addAll(locLast);
				newLast.set(1,oldpai-1);
				if(notAppeared(newLast,routeOld)){
					allNewLasts.add(newLast);
					continues[2]=true;
				}
			}
		}
		if(!continues[2]){
		if(oldlie-1>=1){
			ArrayList<Integer> newLast=new ArrayList<>();
			newLast.addAll(locLast);
			newLast.set(0, oldlie-1);
			if(notAppeared(newLast,routeOld)){
				allNewLasts.add(newLast);
			}
		}
		}


		HashSet<ArrayList<ArrayList<Integer>>> update=new HashSet<>();
		for(ArrayList<Integer> addthisEnd:allNewLasts){
			ArrayList<ArrayList<Integer>> copyOld=new ArrayList<>();
			copyOld.addAll(routeOld);
			copyOld.add(addthisEnd);
			update.add(copyOld);
		}
		return update;
	}
	public boolean notAppeared(ArrayList<Integer> newEnd, ArrayList<ArrayList<Integer>> oldRoute){
		for(ArrayList<Integer> oldLocs:oldRoute){
			if(oldLocs.equals(newEnd)){
				return false;
			}
		}
		return true;
	}
	public String[] listToArray(HashSet<ArrayList<ArrayList<Integer>>> routes){
		String[] array=new String[routes.size()];
		int i=0;
		for(ArrayList<ArrayList<Integer>> way:routes){
			String add="";
			if(way.size()<=14){
			for(int j=0;j<way.size();j++){
				add+=numToS(way.get(j))+"-";
			}
			}
			else{
				for(int k=0;k<7;k++){
					add+=numToS(way.get(k))+"-";
				}
				int endIndex=add.length();
				add=add.substring(0, endIndex-1);
				add+="...";
				for(int l=way.size()-7;l<way.size();l++){
					add+=numToS(way.get(l))+"-";
				}
			}
			int endIndex=add.length();
			add=add.substring(0, endIndex-1);
			array[i]=add;
			i++;
		}
		return array;
	}
	public String numToS(ArrayList<Integer> posi){
		int a=posi.get(0);
		String output="";
		if(a==1) output="a";
		else if(a==2) output="b";
		else if(a==3) output="c";
		else if(a==4) output="d";
		else if(a==5) output="e";
		else if(a==6) output="f";
		else if(a==7) output="g";
		else if(a==8) output="h";
		output+=posi.get(1).toString();
		return output;
	}
	
}
