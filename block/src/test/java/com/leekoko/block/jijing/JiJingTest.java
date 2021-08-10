package com.leekoko.block.jijing;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * 基金计算类
 * todo:比例  盈利值  做成折线统计图
 */
public class JiJingTest {



    @Test
    public void computeTest() throws ParseException {
        //持久化文件
//        genDataFile();
        List<Lsjz> lsjzList = getLsjzData();
        //倒序
        reverse(lsjzList);


        Double maxProfit = -100000000.0;
        Double minProfit = 100000000.0;
        String winRatio = null;
        String minWinRatio = null;

        for (Double i = 101.0; i < 1000; i++) {
            StrategyObj strategyObj = new StrategyObj();
            String ratio = (i / 100) + "";
            String profitStr = startSimulate(lsjzList, ratio, strategyObj);
            Double profitNum = Double.parseDouble(profitStr);
            if(profitNum > maxProfit){
                maxProfit = profitNum;
                winRatio = ratio;
            }
            if(profitNum < minProfit){
                minProfit = profitNum;
                minWinRatio = ratio;
            }
        }
        System.out.println("赢面最大的比例是："+winRatio+"，盈利值为："+maxProfit);
        System.out.println("赢面最小的比例是："+minWinRatio+"，盈利值为："+minProfit);
    }


    /**
     * 开始模式
     * @param ratio  比率  强哥提出1.05
     * @throws ParseException
     */
    private String startSimulate(List<Lsjz> lsjzList, String ratio, StrategyObj strategyObj) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(strategyObj.getStartDate());

        for (Lsjz lsjz : lsjzList) {
            Date date2 = sdf.parse(lsjz.getFSRQ());
            if(date1.after(date2)){
                continue;
            }
            BigDecimal limitMoney = getEveryMonthLimitMoney(strategyObj.getEveryMonthMoney(), date1, date2);
            //如果收益达到5%，卖出一半
            BigDecimal lot = strategyObj.getLot();
            BigDecimal curSumMoney = NumberUtil.mul(lot.toString(), lsjz.getDWJZ());
            String sumMoney = strategyObj.getSumMoney().toString();
            //超出指定比例，售出一半
            if(curSumMoney.compareTo(NumberUtil.mul(sumMoney, ratio)) == 1){
                strategyObj.sellHalf(curSumMoney);
            }

            //todo:更换lyb买入策略
            //钱包消耗
            if(!strategyObj.buyOnce(limitMoney, lsjz.getDWJZ())){
                continue;
            }

            BigDecimal wallet = strategyObj.getWallet();
            if(wallet.compareTo(strategyObj.getMaxWallet()) == -1){
                //钱包金额 小于 历史最大支出金额
                strategyObj.setMaxWallet(wallet);
            }
        }
        //最近一次的单位净值
        String lastMoney = lsjzList.get(lsjzList.size()-1).getDWJZ();
        return getProfitResult(ratio, strategyObj, lastMoney);
    }

    /**
     * 获取盈利结果
     * @param ratio
     * @param strategyObj
     * @param lastMoney
     * @return
     */
    private String getProfitResult(String ratio, StrategyObj strategyObj, String lastMoney) {
        System.out.println("份额："+ NumberUtil.round(strategyObj.getLot(),2));
        System.out.println("基金市场中当前金额："+NumberUtil.round(NumberUtil.mul(strategyObj.getLot().toString(),lastMoney), 2));
        System.out.println("基金市场中当前成本："+NumberUtil.round(strategyObj.getSumMoney().toString(),2));
        System.out.println("钱包收入："+NumberUtil.round(strategyObj.getWallet().toString(),2));
        BigDecimal profit = NumberUtil.round(NumberUtil.add(strategyObj.getWallet(), NumberUtil.mul(strategyObj.getLot().toString(), lastMoney)), 2);
        System.out.println("总盈利："+ profit);
        System.out.println("最高筹备金额："+NumberUtil.round(strategyObj.getWallet().toString(),2));
        System.out.println("比率为："+ratio);
        System.out.println("=======================================");
        return profit.toString();
    }

    /**
     * 获取每个月限制金额
     * @param everyMonthMoney
     * @return
     * @throws ParseException
     */
    private BigDecimal getEveryMonthLimitMoney(BigDecimal everyMonthMoney, Date date1, Date date2) throws ParseException {
        long betweenMonth = DateUtil.betweenMonth(date1, date2, false) + 1;
        return NumberUtil.mul(betweenMonth, everyMonthMoney);
    }




    /**
     * 获取抓取的数据
     * @return
     */
    private List<Lsjz> getLsjzData() {
//        String listStr = getStringByUrl();
        String listStr = getStringByFile();
        JSONArray jsonArray = JSONUtil.parseArray(listStr);
        return jsonArray.toList(Lsjz.class);
    }

    /**
     * 生成持久化文件
     */
    private void genDataFile(){
        //持久化文件
        String listStr = getStringByUrl();
        FileWriter writer = new FileWriter("D://jijing2.txt");
        writer.write(listStr);
    }

    private String getStringByFile() {
        FileReader fileReader = new FileReader("D://jijing2.txt");
        return fileReader.readString();
    }

    /**
     * 根据URL获取基金数据
     * todo:每次都只要抓取最新的部分数据，把旧的数据缓存起来
     * @return
     */
    private String getStringByUrl() {
        String code = "003096";
        String URL = "http://api.fund.eastmoney.com/f10/lsjz?callback=jQuery183048755887315390956_1625383673542&fundCode="+code+"&pageIndex=1&pageSize=10000&startDate=&endDate=&_=1625385095173";
        String resp = HttpRequest.get(URL).header("Referer", "http://fundf10.eastmoney.com/").execute().body();
        String resultJson = resp.substring(resp.indexOf("(") + 1, resp.lastIndexOf(")"));
        JSONObject jsonObject = JSONUtil.parseObj(resultJson);
        String dataStr = jsonObject.getStr("Data");
        jsonObject = JSONUtil.parseObj(dataStr);
        return jsonObject.getStr("LSJZList");
    }


}
