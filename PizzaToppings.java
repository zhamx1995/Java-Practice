import java.util.HashSet;


public class PizzaToppings {
	public int whichToppings(String[] menu, String[] favorites){
		int whichToppings=0;
		boolean add=false;
		HashSet<String> menus=new HashSet<String>();
		for(int i=0;i<menu.length;i++){
			menus.add(menu[i]);
		}
		for(int j=0;j<favorites.length;j++){
			String[] nowfavorites=favorites[j].split(" ");
			for(int k=0;k<nowfavorites.length;k++){
				if(!menus.contains(nowfavorites[k])){
					break;
				}
				if(k==nowfavorites.length-1){
				add=true;
				}
			}
			if(add){
				break;
			}
			if(add==false&&j==favorites.length-1){
				whichToppings=-2;
			}
			whichToppings++;
		}
		return whichToppings;
	}
}
