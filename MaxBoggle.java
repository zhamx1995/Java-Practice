import java.util.*;
public class MaxBoggle {
	public long maxPoints(String[] matrix, String[] words){
		long maxPoints=0;
		String matrixS="";
    	for(int j=0;j<matrix.length;j++){
    		matrixS+=matrix[j];
    	}
    	char[] matrixCA=matrixS.toCharArray();
    	//creating charArray of matrix
	    for(int i=0;i<words.length;i++){
	    	String nowW=words[i];
	    	char[] nowWA=nowW.toCharArray();
	    	//select the word that is being tested in the words
//	    	boolean addition=true;
	    	ArrayList<HashSet<long[]>> locs= new ArrayList<>();//for each word, locs stores the location of letter for each char in the word
	    	for(int k=0;k<nowWA.length;k++){//compare the letter in the word and each letter in the matrix
	    		//for each letter in the word
            HashSet<long[]>locSet=new HashSet<>();
            for(int j=0;j<matrixCA.length;j++){
            	//for each letter in the matrix
            	if(matrixCA[j]==nowWA[k]){
            		long a=j/4;
            		long b=j%4;
            		if(k==0){
            			long[] loc=new long[3];
            			loc[0]=a;
            			loc[1]=b;
            			loc[2]=1;
            			locSet.add(loc);
            		}
            		else if(k>0&&newtime(locs.get(k-1),a,b)!=0){
            			long frmPrevToNow=newtime(locs.get(k-1),a,b);
            			long[] loc=new long[3];
                		loc[0]=a;
                		loc[1]=b;
                        loc[2]=frmPrevToNow;
            		    locSet.add(loc);
            		}
            	}
            }
            locs.add(locSet);
	    	}
	    	long pathways=0;
	    	for(long[] a:locs.get(locs.size()-1)){
	    		long addition=a[2];
	    	    pathways=(pathways+addition)%(long)1E13;
	    	}
	        maxPoints=(maxPoints+pathways*nowW.length()*nowW.length())%(long)1E13;
	    }
	    return maxPoints;
	}
    public long newtime(HashSet<long[]> set,long newpai, long newlie){//figure out how many paths can (newpai,newlie) link to the old loc in old set
    	long times=0;
    	Iterator<long[]> it=set.iterator();
    	while(it.hasNext()){
    		long[] nowloc=it.next();
    		long oldpai=nowloc[0];
    		long oldlie=nowloc[1];
    		long thistime=(long) (nowloc[2]%(long)1E13);
    		if((Math.abs(oldpai-newpai)<=1&&Math.abs(oldlie-newlie)<=1)&&!(oldpai==newpai&&oldlie==newlie)){
    			times=(times+thistime)%(long)1E13;
    		}
    	}
    	return times;
    }
}
