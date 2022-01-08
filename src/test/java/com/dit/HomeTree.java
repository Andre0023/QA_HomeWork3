package com.dit;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeTree {

    @Test
    void searchExampleCodeForJUnit5() {
        //Открыть Selenide в Github
        open("https://github.com/selenide/selenide");

        //перейти Wiki проекта
        $("#wiki-tab").click();

        // в списке страниц (Pages) есть страница c
        $("#wiki-pages-filter").val("SoftAssertions").pressEnter();

        $("[data-filterable-for='wiki-pages-filter']").shouldHave(text("SoftAssertions"));

        //Откртыь страницу SoftAssertions, проверить что  есть пример кода для JUnit5
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();

        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

    @Test
    void testDragAndDrop() {
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("b"));
        $("#column-b").shouldHave(text("a"));
    }
}