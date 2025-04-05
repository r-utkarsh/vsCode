
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
        int cnt=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<=mid){
                cnt++;
                i++;
            }
        }
        return cnt>=k;
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

    public static void findPermutation(String str, String ans){
        if (str.length()==0) {
            System.out.println(ans);
            return ;            
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String newStr = str.substring(0, i)+ str.substring(i+1);
            findPermutation(newStr, ans+c);
        }
    }
    
    // public static void recPermute(int index ,int nums[]){
    //     ArrayList<Integer> temp = new ArrayList<>();
        
    //     if(index == nums.length) return ;

    //     temp.add(nums[index]);
    //     recPermute(index+1, nums);
    //     // return temp;
    // }

    // public static List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> lst = new ArrayList<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         ArrayList<Integer> temp = new ArrayList<>();
    //         temp.add(nums[i]);
            
    //         lst.add(recPermute(i, nums));
    //     }

    //     return lst;
    // }

    public static int findPath(int i, int j, int n, int m){
        if(i==m-1 || j==n-1){
            return 1;
        } else if(i==m || j==n){
            return 0;
        }
        int w1 = findPath(i+1, j, n, m);
        int w2 = findPath(i, j+1, n, m);

        return w1+w2;
    }
    public static int gridWays(int n, int m){
        return findPath(0,0,m,n);
    }
    

    public static int factorial(int n){
        if (n==1||n==0) {
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int newGridWays(int m, int n){
        int u = factorial(m+n-2);
        int l = factorial(m-1) * factorial(n-1);

        return u/l;
    }
    

    public static boolean isSafee(int sudoku[][], int row, int col, int dig){
        //row
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == dig) {
                return false;
            }
        }
        // column
        for (int j = 0; j < 9 ; j++) {
            if (sudoku[row][j] == dig) {
                return false;
            }
        }
        // grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
                if (sudoku[i][j] == dig) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean solveSudoku(int sudoku[][], int row, int col){
        if(row == 9){
            return true;
        }

        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }
        for (int val = 1; val < 10; val++) {
            if (isSafee(sudoku, row, col, val)) {
                sudoku[row][col] = val;
                if(solveSudoku(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }

        }
        return false;
    }
    public static void printSudoku(int sudoku[][]){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    

    public static boolean characterSudoku(char[][] board, int row, int col) {
        if(row == 9) return true;
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if (board[row][col] != '.') {
            return characterSudoku(board, nextRow, nextCol);
        }
        for (char val = '1' ; val <= '9' ; val++) {
            if(isSafeBoard(board, row, col, val)){
                board[row][col] = val;
                if(characterSudoku(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col] = '.';
                    
            }
            
        }
        return false;
    }
    public static boolean isSafeBoard(char[][] board, int row, int col, int val){
        // row
        for (int i = 0; i < board.length; i++) {
            if(board[i][col] == val) return false;
        }
        // col
        for (int j = 0; j < board.length; j++) {
            if(board[row][j] == val) return false;
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static List<List<Integer>> intSubset(int nums[]){
        List<List<Integer>> lst = new ArrayList<>();
        subset(lst, new ArrayList<>(), nums, 0);
        return lst;
    }
    public static void subset(List<List<Integer>> lst, List<Integer> temp, int nums[], int start){
        
        
        lst.add(new ArrayList<>(temp));
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            subset(lst, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
    public static List<List<Integer>> intSubsetDublicate(int nums[]){
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(nums);
        dublicateSubset(lst, new ArrayList<>(), nums, 0);
        return lst;
    }
    public static void dublicateSubset(List<List<Integer>> lst, List<Integer> temp, int nums[], int start){
        if (!lst.contains(temp)) {
            lst.add(new ArrayList<>(temp));
        }
        
        for(int i=start; i<nums.length; i++){
            temp.add(nums[i]);
            dublicateSubset(lst, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
    
    
    public static void main(String[] args) {
        // int arr[] = new int[5];
        // backTrack(arr, 0, 1);
        // printArray(arr);

        // String s = "abc";
        // findSubset(s, "", 0);

        // int arr[] = {1,2,3};        ////incomplete
        // System.out.println(subsets(arr));

        // int n = 4;
        // char board[][] = new char[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         board[i][j] = '.';
        //     }     
        // }
        // // printBoard(board);
        // nQueens(board, 0);
        // System.out.println(count);

        // String s = "abc";
        // String ans = "";
        // findPermutation(s, ans);

        // int[] nums = {1,2,3};
        // System.out.println(permute(nums));
        
        // int m = 3, n = 7;
        // System.out.println(gridWays(2,4));
        // System.out.println(newGridWays(m,n));

        // int sudoku[][] = {
        // {5,3,0,0,7,0,0,0,0},
        // {6,0,0,1,9,5,0,0,0},
        // {0,9,8,0,0,0,0,6,0},
        // {8,0,0,0,6,0,0,0,3},
        // {4,0,0,8,0,3,0,0,1},
        // {7,0,0,0,2,0,0,0,6},
        // {0,6,0,0,0,0,2,8,0},
        // {0,0,0,4,1,9,0,0,5},
        // {0,0,0,0,8,0,0,7,9}};
        // System.out.println(solveSudoku(sudoku,0,0));
        
        // char[][] board = {
        // {'5','3','.','.','7','.','.','.','.'},
        // {'6','.','.','1','9','5','.','.','.'},
        // {'.','9','8','.','.','.','.','6','.'},
        // {'8','.','.','.','6','.','.','.','3'},
        // {'4','.','.','8','.','3','.','.','1'},
        // {'7','.','.','.','2','.','.','.','6'},
        // {'.','6','.','.','.','.','2','8','.'},
        // {'.','.','.','4','1','9','.','.','5'},
        // {'.','.','.','.','8','.','.','7','9'}};
        // System.out.println(characterSudoku(board, 0, 0));
        // printBoard(board);
        
        // int arr[] = {4,4,4,1,4};
        // System.out.println(intSubset(arr));
        // System.out.println(intSubsetDublicate(arr));


        
        
    }
}