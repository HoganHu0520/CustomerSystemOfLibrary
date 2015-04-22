package com.hogan.util;

import com.hogan.AppContext;
import com.hogan.Constants;

public class PathUtil {

    public static String getFullPath(String path) {
        if (path == null) {
            path = "";
        }
        String urlPrefix = Constants.APP_URL_PREFIX;
        if (!StringUtil.isEmpty(urlPrefix)) {
            urlPrefix += "/";
        }

        return AppContext.getContextPath() + "/" + urlPrefix  + path;
    }

}
