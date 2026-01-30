package com.evaluation.devops;

import java.util.List;

public class HtmlFormatHelper {

    public String getBoldFormat(String content) {
        return "<b>" + content + "</b>";
    }

    public String getItalicFormat(String content) {
        return "<i>" + content + "</i>";
    }

    public String getFormattedListElements(List<String> contents) {
        StringBuilder htmlList = new StringBuilder();
        htmlList.append("<ul>");

        for (String content : contents) {
            htmlList.append("<li>");
            htmlList.append(content);
            htmlList.append("</li>");
        }

        htmlList.append("</ul>");
        return htmlList.toString();
    }
}
