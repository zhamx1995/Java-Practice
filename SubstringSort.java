import java.util.*;

public class SubstringSort {
	 public String[] sortSubstrings(String[] wordList) { 
	     //sorting approach
		 class comp implements Comparator<String>{
			 public int compare(String m, String n){
				 String[] p=unsorted(m);
				 String[] q=unsorted(n);
				 //x is separated & sorted m, y is separated n
				 String[] x=new String[p.length];
				 for(int s=0;s<p.length;s++){
				 x[s]=p[s];
			     }
				 Arrays.sort(x);
				 String[] y=new String[q.length];
				 for(int t=0;t<q.length;t++){
				 y[t]=q[t];
			     }
				 Arrays.sort(y);
				 int i=0;
				 while(i<x.length&&i<y.length){
					 String xnow=x[i];
					 String ynow=y[i];
					 if(!xnow.equals(ynow)){
						 return xnow.compareTo(ynow);
					 }
					 i++;
				 }
				 if(x.length<y.length){
					 return -1;
				 }
				 else if(y.length<x.length){
					 return 1;
				 }
				 //when m and n are equal after vowel extracted
			    for(int k=0;k<p.length;k++){
			    	if(!p[k].equals(q[k])){
			    		return p[k].compareTo(q[k]);
			    	}
			    }
				 return 0;
			 }
		 }
		 String[] sortSubstrings=new String[wordList.length];
		 for(int k=0;k<wordList.length;k++){
		 sortSubstrings[k]=wordList[k];
	 } 
		 Arrays.sort(sortSubstrings,new comp());
	 return sortSubstrings;
	 }
	 
	 //this method separate a word into syllables
	 public String[] unsorted(String input){
		 ArrayList<String> elem=new ArrayList<>();
		 char[] arrayIn=input.toCharArray();
		 int start=0;
		 int end=0;
		 for(int i=0;i<arrayIn.length;i++){
			 end=i+1;
			 if(arrayIn[i]=='a'||arrayIn[i]=='e'||arrayIn[i]=='i'||arrayIn[i]=='o'||arrayIn[i]=='u'){
						if(i==arrayIn.length-1||(arrayIn[i+1]!='a'&&arrayIn[i+1]!='e'&&arrayIn[i+1]!='i'&&arrayIn[i+1]!='o'&&arrayIn[i+1]!='u')){
				String extract=input.substring(start, end);
				elem.add(extract);
				start=i+1;
			 }
				}
			 }
          String[] buildArray=new String[elem.size()];
		 for(int j=0;j<elem.size();j++){
			 buildArray[j]=elem.get(j);
		 }
		 
		 return buildArray;
	 }
//	 public static void main(String[] args){
//	 SubstringSort a=new SubstringSort();
//	 String[] b=a.sortSubstrings(new String[]{"qkwcvllewfttaoeeeopoeueoaieapjuaodyyiaeeymaaoieuoa", "tssdjkgeeqdkymptoquiiuiuaooxjrrzxxieehlmgaeoeemouu", "fqtooeueeatniaeuoecueailcfiuofxxluwyuuosvgkbqkexoi", "qcfeiuogswoeiiyzysjuiaarxruiueigdaaauataiiooaeyqnu", "bbeiuheeoiiotknvwyuoosypmtoczueuuxsoiaolouiathdiua", "dseoauhdxjjlbaiabeauoaitnqcaohmfxkmkojftzoesqdooui", "jztealdaueoprooiuuieaccbaiiesmueiauuimrrbwwmaiguaa", "vfktawruauodvqwiaukguooeoizzmmsqgjagmqaaucbioaouao", "zzwxzeonxrccizslkhefbtiehkcpsauoiezuueosnpueobjcya", "guuuuoiobnnciioiusauaaaiaeakaiaoidtndwoeoavgjuexyi", "ywqoiuokkkxuxrzlaouiozpooaueakuuiio", "mnyuoeianssieoeispoiicqbsoouepauaauaaiacquoeijiaoa", "juoueieeoszaoicbjlkqbkuegdyknoiiepxyjifhbnnxoaohco", "voouieauioquuuekjaoaoutbdoulltqdoiiuqyduoiodeiuefe", "vrciuouooolsgzujntgqyzihuiouiolrlhaaioiu", "ryxuaulxdhgooiauvieaahbqlbkabqkyqzvjoyaeiaeuo", "dylbyoiiiugrclilyrqoeuizceaouaaoqvfrbjumtbwlsfcaru", "hmsxluwuuieowouaiuhiaeeieehpwrciantzmyhiaegrieeixa", "fhcjpcaeaohfoeoioaazcjuoinfytouuopooiaaunnsgpkbbhu", "sxjaeuungtqtaaeuevueooaoeuvnkvgpnposrvyhxyooowyksa", "ybbrwqluoktqfyaiqkteuosiiaouuuaxcpkaooowgdrqlbhaie", "yhnmyxwprokfmtmeeioivknoioxmaaiiaaiaxyjkiuoainiaei", "ffeoueaoskfqwdwezrltockiiuuokrnoioaaejgtppxuxdylgo", "ffclneakhdvtcehgjjxiozzueeplxyfbvyohriaowtqscyuaii", "lgwcheibsgioeoisfkvoaoooogieuiizwlskloouaxsuaafyie", "hjeaeajhuiaesgriikcnieeaieomyccueaezdxiouuoau", "dvcpyneaugiuiutmmxkxuuoavcthiihryyxowmceouaoifeoii", "ybiaeoeuhpsdrwraovmbrfeouriuuaejcstmeoouunxrgheeui"});
//	 for(String s:b){
//		 System.out.println(s);
//	 }
//	 
//	 }
}
