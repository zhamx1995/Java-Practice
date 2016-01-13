import java.util.*;

public class GridGame {
	public int winningMoves(String[] grid){
		int wins=0;
		//Xs is a set containing all the unavailable position choices
		//Ds is a set containing all the available position choices
		HashSet<ArrayList<Integer>> Xs=new HashSet<>();
		HashSet<ArrayList<Integer>> Ds=new HashSet<>();
		for(int i=0;i<grid.length;i++){
			String[] b=grid[i].split("");//separate X and . from String[] into two lists
			for(int j=0;j<b.length;j++){
				String position=b[j];
				ArrayList<Integer> loc=new ArrayList<>();
				loc.add(i);//add pai
				loc.add(j);//add lie
				if(position.equals("X")){
					Xs.add(loc);
				}
				else if(position.equals(".")){
					Ds.add(loc);
				}
			}
		}
		//update the two sets of choices at first, before I make my first move
		HashSet<ArrayList<Integer>> allupdate=new HashSet<>();
		for(ArrayList<Integer> a:Xs){
			HashSet<ArrayList<Integer>> created=invalidlocs(a);
			allupdate.addAll(created);
		}
		Xs.addAll(allupdate);
		Ds.removeAll(allupdate);
		//begin the recursion, if after the update above, there are no available choices left for me,
		//(Xs.size()==16), I cannot win and it returns 0, so myTurn has to be initialized as 0.
		int myTurn=0;
		ArrayList<Integer> input=new ArrayList<>();
		ArrayList<Integer> finalresults=play(Xs,Ds,input,myTurn);	
		//finalresults is an ArrayList of integers that suggests whether the move guarantees a win 
		//at last. Find out how many 1 are there in the finalresults, and the number is the winningMoves
		for(int m:finalresults){
			if(m==1){
				wins++;
			}
		}
		
		return wins;
	}
	/*
	 * This method takes a location and finds out all the adjacent locations in the matrix,
	 * which are then belong to the "unavailable choices", and will be deleted from the "available choices"
	 */
	public HashSet<ArrayList<Integer>> invalidlocs(ArrayList<Integer> input){
		HashSet<ArrayList<Integer>> output=new HashSet<>();
		int pai=input.get(0);
		int lie=input.get(1);
		for(int i=0;i<4;i++){
			ArrayList<Integer> addthis=new ArrayList<>();
			if(i==0&&pai<3){//up
				addthis.add(pai+1);
				addthis.add(lie);
			}
			else if(i==1&&pai>0){//down
				addthis.add(pai-1);
				addthis.add(lie);
			}
			else if(i==2&&lie>0){//left
				addthis.add(pai);
				addthis.add(lie-1);
			}
			else if(i==3&&lie<3){//right
				addthis.add(pai);
				addthis.add(lie+1);
			}
			if(!addthis.isEmpty()){
			output.add(addthis);
			}
		}
		return output;
	}
	
	public ArrayList<Integer> play (HashSet<ArrayList<Integer>> Xs,HashSet<ArrayList<Integer>> Ds,ArrayList<Integer> input,int myTurn){
		if(Xs.size()==16){
			input.add(myTurn);
			return input;
		}
		else{
			if(myTurn==1){
				myTurn=0;
			}
			else if(myTurn==0){
				myTurn=1;
			}
			
		for(ArrayList<Integer> beginloc:Ds){
			HashSet<ArrayList<Integer>> newcreated=invalidlocs(beginloc);
			HashSet<ArrayList<Integer>> newX=new HashSet<>();
			newX.addAll(Xs);
			newX.add(beginloc);
			HashSet<ArrayList<Integer>> newD=new HashSet<>();
			newD.addAll(Ds);
			newD.remove(beginloc);
			//update the available choice and unavailable choice
			newX.addAll(newcreated);
		    newD.removeAll(newcreated);
			
			ArrayList<Integer> allpossi=new ArrayList<>();
			allpossi=play(newX,newD,allpossi,myTurn);
			//when it is my turn, I have to make sure that I will win no matter which
			//move the other one makes
			if(myTurn==1){
				boolean check=true;
			for(int x:allpossi){
				if(x==0){
					check=false;
					break;
				}
			}
			if(check){
			input.add(1);
			}
			else{
				input.add(0);
			}
			}
			//when it is the other one's turn, I have to make sure that I will win at least
			//once among all cases that are left for me after his move.
			else if(myTurn==0){
				boolean check=false;
				for(int x:allpossi){
					if(x==1){
						check=true;
						break;
					}
				}
				if(check){
				input.add(1);
				}
				else{
					input.add(0);
				}
			}
			newX.clear();
			newD.clear();
		}
		}
		return input;	
	}
}
