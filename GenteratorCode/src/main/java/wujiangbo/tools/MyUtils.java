package wujiangbo.tools;

/**
 * 工具类
 * @author 波波老师(weixin:javabobo0513)
 */
public class MyUtils {

    public static void main(String[] args){
      System.out.println(convert("t_", "t_user_demo"));
    }

    //单词所有下划线去掉，并且驼峰转换
    public static String convert(String pre, String source) {
        StringBuffer sbf = new StringBuffer();
        if (source.contains(pre))
        {
            // 按下划线来切割字符串为数组
            String[] split = source.split("_");
            // 循环数组操作其中的字符串
            for (int i = 1, index = split.length; i < index; i++){
                String temp = split[i];
                if(i == 1){
                    sbf.append(temp);
                }else{
                    sbf.append(temp.substring(0, 1).toUpperCase() + temp.substring(1));
                }
            }
        }else{
            sbf.append(source);
        }
        return sbf.toString();
    }

}