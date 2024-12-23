import java.util.HashMap;


public class BottomUpMinCoins{
    public static void main(String... args){
        HashMap<Integer,Integer> memo = new HashMap<>();
        int coins[] = {1,3,4,7,9};
        int res = minCoin(coins,150,memo);
        System.out.println(res);
    }
    public static int minCoin(int[] coins, int t,HashMap<Integer,Integer> memo){
        memo.put(0,0);
        for(int j = 1;j<t+1;j++){    
            for(int i =0; i<coins.length; i++){
                int sub = j-coins[i];
                if(sub<0){
                    continue;
                }
                memo.put(j, minSub(memo.getOrDefault(j,-1),memo.getOrDefault(sub,-1)+1));
            }
        }
            return memo.get(t);
        }
    public static int minSub(int a, int b){
        if(a == -1){
            return b;
        }
        if(b==-1){
            return a;
        }
        return Math.min(a,b);
    }

}
