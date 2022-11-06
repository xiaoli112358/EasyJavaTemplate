package cn.wujiangbo.vo;

import lombok.Data;

import java.util.List;

/**
 * @desc：登录成功后的首页数据
 * @author 波波老师(weixin:javabobo0513)
 */
@Data
public class HomePageVo {

    private Integer count1;
    private Integer count2;
    private Integer count3;
    private Integer count4;
    private List<Integer> mothDayValue1;
    private List<Integer> mothDayValue2;
    private List<String> mothDayText;
}
