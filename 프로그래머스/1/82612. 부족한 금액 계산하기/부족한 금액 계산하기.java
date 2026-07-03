class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        long add = price;
        for(int i = 0; i<count; i++){
            sum += add;
            add += price;
            System.out.println(sum+" "+price);
        }
        if(sum-money > 0){
            return sum-money;
        }else{
            return 0;
        }
    }
}