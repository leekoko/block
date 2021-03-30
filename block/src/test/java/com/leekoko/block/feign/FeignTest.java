package com.leekoko.block.feign;

import com.leekoko.block.service.EdaBusnessTalentsCoverInfo;
import com.leekoko.block.service.IEdaBusnessTalentsCoverInfoDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FeignTest {

    @Autowired
    IEdaBusnessTalentsCoverInfoDataService edaBusnessTalentsCoverInfoDataService;

    @Test
    public void feignTest(){
        String code = "9fa2391573774fdba10dd6527a766901";
        Map data = edaBusnessTalentsCoverInfoDataService.getDataByCode(code);
        data.keySet().stream().forEach(System.out::print);
    }

    @Test
    public void pojoTest(){
        EdaBusnessTalentsCoverInfo edaBusnessTalentsCoverInfo = new EdaBusnessTalentsCoverInfo();
        edaBusnessTalentsCoverInfo.setAreaCode("1");
        edaBusnessTalentsCoverInfo.setAreaName("2");
        edaBusnessTalentsCoverInfo.setCode("3");
        edaBusnessTalentsCoverInfo.setCreateDate("2021-02-26 12:11:22");
        edaBusnessTalentsCoverInfo.setCreator("tsrj");
        edaBusnessTalentsCoverInfoDataService.delete(edaBusnessTalentsCoverInfo);
        System.out.println("结束");
    }

}
