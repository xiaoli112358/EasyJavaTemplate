package cn.wujiangbo.controller;

import cn.wujiangbo.controller.base.BaseController;
import cn.wujiangbo.result.JSONResult;
import cn.wujiangbo.util.MyTools;
import cn.wujiangbo.vo.HomePageVo;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc 公用 API接口
 * @author wujiangbo
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController{

    /**
     * 获取登录成功后的首页数据
     * @date 2022-05-07
     */
    @PostMapping(value="/getHomePageData")
    public JSONResult getHomePageData(){
        HomePageVo vo = new HomePageVo();

        vo.setCount1(Integer.valueOf(MyTools.getRandomDotString(4000000, 5000000)));
        vo.setCount2(Integer.valueOf(MyTools.getRandomDotString(2000000, 3000000)));
        vo.setCount3(Integer.valueOf(MyTools.getRandomDotString(70000000, 90000000)));
        vo.setCount4(Integer.valueOf(MyTools.getRandomDotString(40000000, 60000000)));

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        for(int i=1; i<=31; i++){
            list1.add(Integer.valueOf(MyTools.getRandomDotString(20000, 50000)));
            list2.add(Integer.valueOf(MyTools.getRandomDotString(2000, 5000)));
            list3.add(String.valueOf(i));
        }
        vo.setMothDayValue1(list1);
        vo.setMothDayValue2(list2);
        vo.setMothDayText(list3);

        return JSONResult.success(vo);
    }
}
