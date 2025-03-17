
import java.util.*;

public class newFile {
    public static void hashMapMethods(){
        //Syntax
        Map<String, Integer> mp = new HashMap<>();
        //Adding values
        mp.put("akash", 21);
        mp.put("yash", 16);
        mp.put("lav", 17);
        mp.put("rishi", 19);
        mp.put("harry", 18);

        //Getting value of key in map
        System.out.println(mp.get("yash"));
        System.out.println(mp.get("raj"));
        System.out.println();

        //Change/update value of hashmap
        mp.put("akash", 25);  //put is used for instertion as well as updation
        System.out.println(mp.get("akash"));
        System.out.println();

        //Removing a pair of hashmap
        System.out.println(mp.remove("akash"));
        System.out.println(mp.remove("riya"));
        System.out.println();

        //check if key present or not
        System.out.println(mp.containsKey("akash"));
        System.out.println(mp.containsKey("yash"));
        System.out.println();


        System.out.println(mp.keySet());
        System.out.println(mp.values());
        System.out.println(mp.entrySet());
        System.out.println();
        
        for(var e : mp.entrySet()){
            System.out.println(e);
        }

    }
    public static int MFT(int[] arr){
        int cnt = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(var el : arr){
            if(!mp.containsKey(el)){
                mp.put(el,1);
            }
            else{
                mp.put(el, mp.get(el)+1);
            }
        }
        System.out.println(mp.entrySet());
        int max = 0;
        for(var e : mp.entrySet()){
            if (e.getValue()>cnt) {
                cnt = e.getValue();
                max = e.getKey();
            }
        }
        return max;
    }
    

    public static void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sorty(int nums[]){
        int left = 0;
        int right = nums.length-1;
        int temp = 0;
        while(temp<=right){
            switch (nums[temp]) {
                case 0 -> {
                    swap(nums,temp,left);
                    left ++;
                    temp++;
                }
                case 2 -> {
                    swap(nums,temp,right);
                    right--;
                }
                default -> temp++;
            }
        }
    }
    
    public static boolean canRob(int arr[], int mid, int k){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=mid){
                count++;
                i++;
            }
        }
        return count>=k;
    }
    
    public static int greedy(int arr[],int k){
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max) max = arr[i];
            if(arr[i]<min) min = arr[i];
        }
        int l=min, r = max;
        int ans = r;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(canRob(arr, mid, k)){
                ans = mid;
                r = mid-1;
            }
            else l = mid+1; 
        }
        return ans;

    }
    
    public static int me(int arr[]){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!mp.containsKey(arr[i])){
                mp.put(arr[i], 1);
            }
            else{
                mp.put(arr[i], mp.get(arr[i])+1);
            }
        }
        System.out.println(mp.entrySet());
        int max = 0;
        for(var i : mp.keySet()){
            if(mp.get(i)>=max){
                max = i;
            }
        }
        return max;
    }
    
    public static boolean canDo(int arr[], long mid, int c){
        long carCount = 0;
        for(var i : arr){
            long c2 = mid/i;
            long c2r = (long) Math.floor(Math.sqrt(c2));
            carCount += c2r;
        }
        return carCount>=c;
    }

    public static long repairCAR(int arr[], int c){
        long l=1, r=(long) arr[0] * c * c;
        while(l<r){
            long mid = l+(r-l)/2;
            if(canDo(arr,mid,c)){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }  
    
    public static boolean divideArray(int arr[]){
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (var i : arr) {
            if(!mp.containsKey(i)){
                mp.put(i, 1);
            }
            else {
                mp.put(i, mp.get(i)+1);
            }
        }
        // System.out.println(mp.entrySet());
        for (var i : mp.values()) {
            if(i%2!=0) return false;
        }
        return true;
    }
    
    public static void rotateArray(int arr[][]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i]; 
                arr[j][i] = temp;        
            }
        }
    }
    
    public static void reqArray(int arr[][]){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int left = 0, right = n-1;
            while(left<=right){
                int temp = arr[i][left];
                arr[i][left] = arr[i][right]; 
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args) {
        // hashMapMethods();
        // int arr[] = {1,2,5,1,4,4,6,4,4,4,6,2,2};
        // System.out.println(MFT(arr));
        int brr[] = {2,0,2,1,1,0};
        // sorty(brr);
        for (int i = 0; i < brr.length; i++) {
            // System.out.print(brr[i]+" ");
        }
        // int cr[] = {2,3,5,9} ;
        // System.out.println(greedy(cr, 2));
        // int c[] = {-1,1,1,1,2,1};
        // System.out.println(me(c));
        // int d[] = {5,1,8};
        // System.out.println(repairCAR(d,6));
        // int e[] = {9,9,19,10,9,12,2,12,3,3,11,5,8,4,13,6,2,11,9,19,11,15,9,17,15,12,5,14,12,16,18,16,10,3,8,9,16,20,2,4,16,12,11,14,20,16,2,18,17,20,3,13,16,17,1,1,11,20,20,4};
        // System.out.println(divideArray(e));
       
        // int td[][] = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        // int td[][] = {{1, 2, 3, 4},
                    //   {5, 6, 7, 8},
                    //   {9, 10, 11, 12},
                    //   {13, 14, 15, 16}};
        // rotateArray(td);
        // reqArray(td);
        
    }
}