import java.util.*;

public class EmergencyNetwork {
	public int lagTime(int[] bosses) {
		int[] timeForEach=new int[bosses.length];
	for(int i=bosses.length-1;i>=0;i--){
		if(i==bosses.length-1){
			timeForEach[i]=0;
		}
		else{
			HashSet<Integer> subs=Subs(bosses,i);
			if(subs.size()==0){
				timeForEach[i]=0;
			}
			else{
				int[] times=new int[subs.size()];
				Iterator<Integer> it=subs.iterator();
				int j=0;
				while(it.hasNext()){
					int index=it.next();
					times[j]=timeForEach[index];
					j++;
				}
				Arrays.sort(times);
				for(int k=times.length-1;k>=0;k--){
					times[k]=times[k]+times.length-k;
				}
				Arrays.sort(times);
				timeForEach[i]=times[times.length-1];
			}
		}
		}
	return timeForEach[0];
	}
public HashSet<Integer> Subs(int[] bosses,int a){
	HashSet<Integer> subs=new HashSet<>();
	for(int i=a+1;i<bosses.length;i++){
		if(bosses[i]==a){
			subs.add(i);
		}
	}
	return subs;
}
}
