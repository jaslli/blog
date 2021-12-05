package com.yww.blog.util;

import cn.hutool.json.JSONUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     用于封装Json数据进行返回
 * </p>
 *
 * @author yww
 * @version 1.0
 * @date 2021/11/30 22:31
 **/
public class ResponseUtil {

    /**
     * 用于返回JSON数据
     * @param response 请求响应
     * @param result   响应的结果
     */
    public static void printlnOut(HttpServletResponse response, Result result) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().write(JSONUtil.toJsonStr(result));
        response.getWriter().flush();
    }

}
