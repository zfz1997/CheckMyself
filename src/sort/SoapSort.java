package sort;

public class SoapSort {
       public static void main(String[] args) {
		int[] arrays= {5,9,1,3,4,6,8,7,2,0};
		for(int i=0;i<arrays.length;i++) {
			System.out.print(arrays[i]+" ");
		}
		System.out.println();
		arrays=sort(arrays);
		for(int i=0;i<arrays.length;i++) {
			System.out.print(arrays[i]+" ");
		}
	}
       public static int[] sort(int[] arrays) {
    	   
    	   for(int i=0;i<arrays.length-1;i++) {
    		   for(int j=0;j<arrays.length-i-1;j++) {
    			   if(arrays[j]>arrays[j+1]) {
    				   int temp=arrays[j];
    				   arrays[j]=arrays[j+1];
    				   arrays[j+1]=temp;
    			   }
    		   }
    	   }
    	   
    	   
    	   
    	    return arrays;
       }
}
