package com.leekoko.block.jijing;

import cn.hutool.core.util.NumberUtil;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 投资策略对象
 */
@Data
public class StrategyObj {

    private BigDecimal buyMoney;
    //扣去手续费后投入的金额
    private String cleanMoney;
    //基金投入总成本
    private BigDecimal sumMoney;
    private BigDecimal lot;
    private BigDecimal wallet;
    private BigDecimal maxWallet;
    private String startDate;
    private String ratio;
    //每月投入金额
    private BigDecimal everyMonthMoney;

    public StrategyObj(){
        this.buyMoney = new BigDecimal("50");
        this.startDate = "2017-07-01";
        this.everyMonthMoney = new BigDecimal("-1000");
        this.cleanMoney = subscribeMoney(buyMoney);
        this.sumMoney = new BigDecimal("0");
        this.lot = new BigDecimal("0");
        this.wallet = new BigDecimal("0");
        this.maxWallet = new BigDecimal("0");
    }

    /**
     * 扣去购买手续费
     * @param buyMoney
     * @return
     */
    private String subscribeMoney(BigDecimal buyMoney) {
        //支付宝中，0<金额<50w的手续费位0.15%
        String ratio = "0.0015";
        return NumberUtil.sub(buyMoney, NumberUtil.mul(buyMoney, new BigDecimal(ratio))).toString();
    }

    /**
     * 执行一次购买
     * @param limitMoney   限制金额
     * @param DWJZ   单位净值
     * @return
     */
    protected boolean buyOnce(BigDecimal limitMoney, String DWJZ){
        BigDecimal beforeWallet = wallet;
        this.wallet = NumberUtil.sub(wallet, buyMoney);
        if(limitMoney.compareTo(wallet) == 1){
            //超出限制，钱包回溯，没钱购买
            this.wallet = beforeWallet;
            return false;
        }
        //新增份额
        this.lot = lot.add(NumberUtil.div(cleanMoney, DWJZ));
        this.sumMoney = sumMoney.add(buyMoney);

        return true;
    }

    /**
     * 强哥策略：卖出一半
     */
    protected void sellHalf(BigDecimal curSumMoney){
        //基金市场中成本的金额减少一半
        sumMoney = NumberUtil.div(sumMoney, new BigDecimal("2"));
        //份额减少一半
        lot = NumberUtil.div(lot, 2);
        //钱包获得当前价值卖出的一半
        //todo:减去手续费
        BigDecimal outputMoney = NumberUtil.div(curSumMoney, new BigDecimal("2"));
        wallet = wallet.add(outputMoney);
        System.out.println("因为收益率达到"+ratio+",取出到钱包："+NumberUtil.round(outputMoney.toString(),2));
    }

}
