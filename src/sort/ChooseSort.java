
package sort;

public class ChooseSort {
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
		    	int index=i;
		    	for(int j=i;j<arrays.length;j++) {
		    		  
		    		  if(arrays[j]<arrays[index]) {
		    			  index=j;
		    		  }
		    	}
		    	int temp=arrays[i];
		    	arrays[i]=arrays[index];
		    	arrays[index]=temp;
		    }
			return arrays;
		}
}
