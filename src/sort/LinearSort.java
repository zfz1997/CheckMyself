package sort;

public class LinearSort {
         public static void main(String[] args) {
			  int[] arrays= {1,3,8,19,56,79,89,99,105,168,197,206,289};
			  System.out.println("您要找的数字下标为"+sort(arrays,89));
		}
        public static int sort(int arrays[],int number) {
        	 int length=arrays.length;
        	 int mid=length/2;
        	 while(arrays[mid]!=number) {
        		 if(arrays[mid]>number) {
        			 mid/=2;
        		 }
        		 else if(arrays[mid]<number) {
        			 mid=(mid+length)/2;
        			 
        		 }
        	 }
        	 return mid;
        }
        	 
        	 
        	
   }

