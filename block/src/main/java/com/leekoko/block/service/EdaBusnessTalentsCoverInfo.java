package com.leekoko.block.service;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 创业领军人才认定申请-封面信息
 * </p>
 *
 * @author petty
 * @since 2019-07-31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EdaBusnessTalentsCoverInfo extends Model<EdaBusnessTalentsCoverInfo> {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @TableId("CODE")
    private String code;

    @TableField("DECLARE_MAN")
    private String declareMan;

    @TableField("DECLARE_UNIT")
    private String declareUnit;

    @TableField("EMAIL")
    private String email;

    @TableField("FAX")
    private String fax;

    @TableField("PHONE")
    private String phone;

    @TableField("TEL")
    private String tel;

    @TableField("FILL_DATE")
    private String fillDate;

    @TableField("LINK")
    private String link;

    @TableField("LINK_EMAIL")
    private String linkEmail;

    @TableField("LINK_PHONE")
    private String linkPhone;

    @TableField("LINK_TEL")
    private String linkTel;

    @TableField("OTHER_FIELD")
    private String otherField;

    @TableField("PRO_FIELD")
    private String proField;

    @TableField("PRO_NAME")
    private String proName;

    @TableField("PRO_NO")
    private String proNo;

    @TableField("UNIT_ADDR")
    private String unitAddr;

    // 申请类别
    @TableField("TSM1")
    private String tsm1;

    // 区内/外企业
    @TableField("TSM2")
    private String tsm2;

    // 场地面积（平方米）
    @TableField("TSM3")
    private String tsm3;

    @TableField("TSM4")
    private String tsm4;

    @TableField("TSM5")
    private String tsm5;

    @TableField("TSM6")
    private String tsm6;

    @TableField("TSM7")
    private String tsm7;

    @TableField("TSM8")
    private String tsm8;

    @TableField("TSM9")
    private String tsm9;

    @TableField("DEL_FLAG")
    @TableLogic
    private Integer delFlag;

    @TableField("CREATOR")
    private String creator;

    @TableField("CREATE_DATE")
    private String createDate;

    @TableField("MODIFIER")
    private String modifier;

    @TableField("MODIFY_DATE")
    private String modifyDate;

    @TableField("AREA_CODE")
    private String areaCode;

    @TableField("AREA_NAME")
    private String areaName;

    @TableField("DEPT_CODE")
    private String deptCode;

    @TableField("DEPT_NAME")
    private String deptName;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
