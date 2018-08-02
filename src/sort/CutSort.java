package sort;

import java.util.Arrays;

public class CutSort {
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
			for(int i=1;i<arrays.length;i++) {
				int j=i;
				int target=arrays[i];
				while(j>0&&target<arrays[j-1]) {
				  arrays[j]=arrays[j-1];
				  j--;
			}
			arrays[j]=target;
		
		}
			return arrays;
}
		
}