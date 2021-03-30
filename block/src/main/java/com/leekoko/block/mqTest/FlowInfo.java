package com.leekoko.block.mqTest;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 发送流程信息
 */
@Data
public class FlowInfo implements Serializable {
    private String applicationCode;
    private Map<String, Object> mainTableData;

    public FlowInfo(String applicationCode, Map<String, Object> mainTableData){
        this.applicationCode = applicationCode;
        this.mainTableData = mainTableData;
    }


}
