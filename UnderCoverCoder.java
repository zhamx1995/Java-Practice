import java.util.HashMap;
import java.util.Iterator;


public class UnderCoverCoder {
	 public int totalNotes(String[] clips, String[] notes) { 
		String d=" ";
		char[] f=d.toCharArray();
		char g=f[0];//g is a space with form of char
		HashMap charsAvailable= new HashMap();
		String clipstostring="";
		for(int t=0;t<clips.length;t++){
			clipstostring=clipstostring+clips[t];
		}
		String lowerstring=clipstostring.toLowerCase();
				char[] c=lowerstring.toCharArray();
		for(int i=0;i<c.length;i++){
			if(charsAvailable.containsKey(c[i])){
				int k=charsAvailable.get(c[i]).hashCode();
				charsAvailable.replace(c[i], k, k+1);
			}
			else{
				charsAvailable.put(c[i], 1);
		}
		}//put all letters in clip into a map
			
		int totalNotes=0;
		 for(int j=0;j<notes.length;j++){
				HashMap nowNoteMap= new HashMap();
				String lowernowstring=notes[j].toLowerCase();
				char[] c1=lowernowstring.toCharArray();
				for(int m=0;m<c1.length;m++){
					if(nowNoteMap.containsKey(c1[m])){
						int p=nowNoteMap.get(c1[m]).hashCode();
						nowNoteMap.replace(c1[m], p, p+1);
					}
					else{
						nowNoteMap.put(c1[m], 1);
				}
				}
			 
			 //totalNotes++;
				Iterator iterator = nowNoteMap.entrySet().iterator();
				//boolean check=false;
				boolean add=true;
				while (iterator.hasNext()&&add==true) {
					HashMap.Entry mapEntry = (HashMap.Entry) iterator.next();
					if(mapEntry.getKey().equals(g)){
						add=true;
					}
					
					else{//!=" "
						if(charsAvailable.containsKey(mapEntry.getKey())){
						int value1=(int) mapEntry.getValue();
						int value2=(int) charsAvailable.get(mapEntry.getKey());
						//if(value2<value1){
						     if(value2>=value1){
						//totalNotes--;
							add=true;
							//check=false;
						     }
						    else{//value less
							add=false;
						    }
						}
						else{//does not contain
							add=false;
						}

				}
				}
				if(add==true){
					totalNotes++;
				}
				nowNoteMap.clear();
			 
		 }
		 
		 return totalNotes;
		 }
	 
	 

}
