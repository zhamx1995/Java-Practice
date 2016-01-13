public class RaspberryDelight {

	 public int toasts(int upper_limit, int layer_count){
		 if(upper_limit<1||upper_limit>100){
			 System.out.println("invalid input of upper_limit");
		 }
		 if(layer_count<1||layer_count>1000){
			 System.out.println("invalid input of layer_count");
		 }
		 int i=0;
		 int toasts=0;
		while(i<layer_count){
			i=i+upper_limit; 
		toasts++; 
		 }
		 
	return toasts;
	}

}
