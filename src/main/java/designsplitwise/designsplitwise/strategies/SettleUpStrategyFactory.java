package designsplitwise.designsplitwise.strategies;

import designsplitwise.designsplitwise.models.StrategyType;

public class SettleUpStrategyFactory {

    public static SettleUpStrategy getSettleUpStrategy(StrategyType strategyType) {
       if(strategyType.equals(StrategyType.EQUAL)){
           return new EqualSettleUpStrategy();
       }
       else if(strategyType.equals(StrategyType.HEAP)){
           return new HeapSettleUpStrategy();
       }
       else{
           return new GeneralSettleStrategy();
       }
    }
}
