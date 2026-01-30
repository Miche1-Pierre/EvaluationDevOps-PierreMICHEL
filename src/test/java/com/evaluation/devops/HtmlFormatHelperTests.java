package com.evaluation.devops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Tests unitaires pour la classe HtmlFormatHelper
 */
public class HtmlFormatHelperTests {

    // Tests pour getBoldFormat()
    @Test
    @DisplayName("Retourne le format HTML en gras")
    void HtmlFormatHelper_GetBoldFormat_ReturnsBoldHtml() {
        HtmlFormatHelper helper = new HtmlFormatHelper();

        String content = "Bold Text";
        String result = helper.getBoldFormat(content);

        assert result.equals("<b>Bold Text</b>");
    }

    // Tests pour getItalicFormat()
    @Test
    @DisplayName("Retourne le format HTML en italique")
    void HtmlFormatHelper_GetItalicFormat_ReturnsItalicHtml() {
        HtmlFormatHelper helper = new HtmlFormatHelper();

        String content = "Italic Text";
        String result = helper.getItalicFormat(content);

        assert result.equals("<i>Italic Text</i>");
    }

    // Test pour getFormattedListElements()
    @Test
    @DisplayName("Retourne le format HTML pour une liste non vide")
    void HtmlFormatHelper_GetFormattedListElements_ReturnsHtmlList() {
        HtmlFormatHelper helper = new HtmlFormatHelper();

        List<String> contents = List.of("Item 1", "Item 2", "Item 3");
        String result = helper.getFormattedListElements(contents);
        String expectedHtml = "<ul><li>Item 1</li><li>Item 2</li><li>Item 3</li></ul>";

        assert result.equals(expectedHtml);
    }
}
