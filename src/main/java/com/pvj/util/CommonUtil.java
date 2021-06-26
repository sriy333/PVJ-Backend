package com.pvj.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonUtil {

    public static Gson getGsonInstance() {
        GsonBuilder builder = new GsonBuilder();
        builder = builder.disableHtmlEscaping();
        return builder.create();
    }
}
