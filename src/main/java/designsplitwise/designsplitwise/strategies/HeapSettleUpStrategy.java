package designsplitwise.designsplitwise.strategies;

import designsplitwise.designsplitwise.models.*;

import java.util.*;

public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUpStrategy(List<Expense> expenses) {

        Map<User,Integer>userExpMap=new HashMap<>();

        for(Expense expense:expenses){
            for(UserExpense userExpense:expense.getUserExpense()){
                User user=userExpense.getUser();
                int amount=userExpense.getAmount();

                if(!userExpMap.containsKey(user)){
                    userExpMap.put(user,0);
                }
                if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID_BY)){
                    userExpMap.put(user,userExpMap.get(user)+amount);
                }
                else if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID_FOR)){
                    userExpMap.put(user,userExpMap.get(user)-amount);
                }
            }
        }

        PriorityQueue<UserAmount>whoPaid=new PriorityQueue<>((a,b)->b.amount-a.amount );
        PriorityQueue<UserAmount>whoHaveToPay=new PriorityQueue<>((a,b)-> Math.abs(b.amount) - Math.abs(a.amount));
         for(Map.Entry<User,Integer>entry:userExpMap.entrySet()){
             int amount=entry.getValue();

             if(amount>0){
                 whoPaid.add(new UserAmount(entry.getKey(),amount));
             }
             else if(amount<0){
                 whoHaveToPay.add(new UserAmount(entry.getKey(),amount));
             }
         }

         List<Transaction>transactions=new ArrayList<>();

         while(!whoPaid.isEmpty() && !whoHaveToPay.isEmpty()){
             UserAmount whoPaidUser=whoPaid.remove();
             UserAmount whoHaveToPayUser=whoHaveToPay.remove();
             int settleAmount=Math.min(whoPaidUser.amount,-whoHaveToPayUser.amount);
               Transaction transaction=new Transaction(whoHaveToPayUser.user,whoPaidUser.user,settleAmount);
             transactions.add(transaction);

             whoPaidUser.amount=whoPaidUser.amount-settleAmount;
             whoHaveToPayUser.amount=whoHaveToPayUser.amount+settleAmount;

         }

        return transactions;
    }
    private static class UserAmount {
        User user;
        int amount;

        public UserAmount(User user, int amount) {
            this.user = user;
            this.amount = amount;
        }
    }
}



