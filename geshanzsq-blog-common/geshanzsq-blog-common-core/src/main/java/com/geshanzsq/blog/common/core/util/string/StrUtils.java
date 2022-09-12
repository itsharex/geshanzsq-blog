package com.geshanzsq.blog.common.core.util.string;

import com.geshanzsq.blog.common.core.constant.CommonConstant;
import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 *
 * @author geshanzsq
 * @date 2022/3/19
 */
public class StrUtils extends StringUtils {

    /**
     * 左括号
     */
    private final static String LEFT_BRACKET = "{";

    /**
     * 右括号
     */
    private final static String RIGHT_BRACKET = "}";

    /**
     * 转换文本, {} 表示占位符，例：
     * format("欢迎访问{blogName}博客，网站地址：{siteUrl}", "格姗知识圈", "http://geshanzsq.com")
     * format("欢迎访问{}博客，网站地址：{}", "格姗知识圈", "http://geshanzsq.com")
     * @param str 需要转换的字符串
     * @param params 参数
     */
    public static String format(String str, Object... params) {
        if (isBlank(str) || params == null || params.length == 0) {
            return str;
        }
        StringBuilder result = new StringBuilder();
        // 数组下标
        int index = 0;
        while (str.contains(LEFT_BRACKET) && str.contains(RIGHT_BRACKET)) {
            int start = str.indexOf(LEFT_BRACKET);
            int end = str.indexOf(RIGHT_BRACKET);
            // 如果 index 大于 params 数组，说明后续无需替换
            if (index > (params.length - 1)) {
                result.append(str);
                break;
            }
            // 如果右 } 大于左 }，直接取出 {，跳过当前，示例：欢迎访问{blogName}博客，}{网站地址：{siteUrl}
            if (end < start || index > (params.length - 1)) {
                result.append(str.substring(0, start + 1));
                str = str.substring(start + 1);
                continue;
            }
            result.append(str.substring(0, start));
            result.append(params[index]);
            str = str.substring(end + 1);
            index++;
        }
        return result.toString();
    }

    /**
     * 是否为http(s)://开头
     *
     * @param link 链接
     * @return 结果
     */
    public static boolean isHttp(String link) {
        return StringUtils.startsWithAny(link, CommonConstant.HTTP, CommonConstant.HTTPS);
    }

}
