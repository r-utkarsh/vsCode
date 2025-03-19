
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
    
    public static List<List<Integer>> generate(int row){
        List<List<Integer>> lst = new ArrayList<>();
        int ans = 1;
        for (int x = 1; x <= row; x++) {
            ArrayList<Integer> temp = new ArrayList<>(); 
            temp.add(ans);
            for (int i = 1; i < x; i++) {
                ans *= x-i;
                ans /= i;
                temp.add(ans);
            }
            lst.add(temp);
        }
        return lst;
    }
    
   public static void backTrack(int arr[], int i, int val){
        if(i == arr.length){
            printArray(arr);
            return;
        }
        arr[i] = val;
        backTrack(arr, i+1, val+1);
        arr[i] = arr[i]-2;
   }

    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void findSubset(String s, String ans, int i){
        if(i == s.length()){
            System.out.print(ans+" ");
            return;
        }

        findSubset(s, ans+s.charAt(i), i+1);

        findSubset(s, ans, i+1);
    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> lst = new ArrayList<>();
       
        return lst;
    }

    public static void printBoard(char board[][]){
        System.out.println("-----board----");
        for (char[] board1 : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board1[j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;
    public static void nQueens(char board[][], int row){
        if(row == board.length){
            printBoard(board);
            count++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = '.';
            }
        }
    }
    
    public static boolean isSafe(char board[][], int row, int col){
        //vertical
        for (int i = row-1; i>=0; i--) {
            if (board[i][col]=='Q') {
                return false;
            }
        }
        // left side
        for (int i=row-1, j=col-1; i>=0 && j>=0 ; i--,j--) {
            if (board[i][j]=='Q') {
                return false;
            }
        }
        // right side
        for (int i=row-1, j=col+1; i>=0 && j<board.length ; i--,j++) {
            if (board[i][j]=='Q') {
                return false;
            }
        }
        return true;
    }

 
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // backTrack(arr, 0, 1);
        // printArray(arr);

        // String s = "abc";
        // findSubset(s, "", 0);

        // int arr[] = {1,2,3};        ////incomplete
        // System.out.println(subsets(arr));

        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }     
        }
        // printBoard(board);
        nQueens(board, 0);
        System.out.println(count);
    }
}