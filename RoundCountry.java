public class RoundCountry {
	public int minBorders(int[] x, int[] y, int[] r, int x1, int y1, int x2, int y2) {
	    int n=x.length;
	    int s1[]=new int[n];
	    int s2[]=new int[n];  
	    int minBorders=0;
		for(int i=0;i<n;i++){
			s1[i]=(x[i]-x1)*(x[i]-x1)+(y[i]-y1)*(y[i]-y1);
			s2[i]=(x[i]-x2)*(x[i]-x2)+(y[i]-y2)*(y[i]-y2);
	    if(s1[i]<r[i]*r[i] && r[i]*r[i]<s2[i] || s2[i]<r[i]*r[i] && r[i]*r[i]<s1[i]){
			minBorders++;
			}
		}
		return minBorders;
	}
}
