package com.johnvon.fjy.util;

import java.util.Map;

/**
 * @author Johnvon
 */
public class UrlUtil {

    public String urlParamsConstruct(String baseUrl, Map<String, Object> params) {
        String url = baseUrl;
        StringBuilder sb = new StringBuilder(baseUrl);

        if (params.size() > 0) {
            //check baseUrl has contain params
            if (!baseUrl.contains("?")) {
                sb.append("?");
            } else if (!baseUrl.endsWith("&")) {
                sb.append("&");
            }

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue().toString()).append("&");
                }
            }

            url = sb.toString().endsWith("&") ? sb.substring(0, sb.length() - 1) : sb.toString();
        }
        return url;
    }

}
