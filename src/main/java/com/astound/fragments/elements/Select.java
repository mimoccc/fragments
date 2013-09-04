package com.astound.fragments.elements;

import com.astound.fragments.PageContext;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Select extends Fragment {

    public Select(PageContext pageContext) {
        super(pageContext);
    }

    private org.openqa.selenium.support.ui.Select delegate() {
        return new org.openqa.selenium.support.ui.Select(getWrappedElement());
    }

    public void deselectAll() {
        publishEvent("deselecting all options");
        delegate().deselectAll();
    }

    public void deselectByIndex(int index) {
        publishEvent(String.format("deseclting [%s] option", index));
        delegate().selectByIndex(index);
    }

    public void deselectByValue(String value) {
        publishEvent(String.format("deselecting option with value [%s]", value));
        delegate().deselectByValue(value);
    }

    public void deselectByVisibleText(String text) {
        publishEvent(String.format("deselecting option with text [%s]", text));
        delegate().deselectByVisibleText(text);
    }

    public <E extends Fragment> Collection<E> getAllSelectedOptions(Class<E> eClass) {
        return findFragments(new By() {
            @Override public List<WebElement> findElements(SearchContext searchContext) {
                return delegate().getAllSelectedOptions();
            }
        }, eClass, getName() + "-selected-option-");
    }

    public <E extends Fragment> E getFirstSelectedOption(Class<E> aClass) {
        return (E) findFragment(new By() {
            @Override public WebElement findElement(SearchContext context) {
                return delegate().getFirstSelectedOption();
            }

            @Override public List<WebElement> findElements(SearchContext searchContext) {
                return Arrays.asList(delegate().getFirstSelectedOption());
            }
        }, aClass, getName() + "-selected-option-1");
    }

    public List<String> getSelectedOptionsText() {
        List<WebElement> elements = delegate().getAllSelectedOptions();

        List<String> options = new ArrayList<>();

        for (WebElement element : elements) {
            options.add(element.getText());
        }

        return options;
    }

    public List<String> getOptionsText() {
        List<WebElement> elements = delegate().getOptions();

        List<String> options = new ArrayList<>();

        for (WebElement element : elements) {
            options.add(element.getText());
        }

        return options;
    }

    public <E extends Fragment> List<E> getOptions(Class<E> aClass) {
        return findFragments(new By() {
            @Override public List<WebElement> findElements(SearchContext searchContext) {
                return delegate().getOptions();
            }
        }, aClass, getName() + "-option");
    }

    public boolean isMultiple() {
        return delegate().isMultiple();
    }

    public void selectByIndex(int index) {
        publishEvent(String.format("selecting option with index [%s]", index));
        delegate().selectByIndex(index);
    }

    public void selectByValue(String value) {
        publishEvent(String.format("selecting option with value [%s]", value));
        delegate().selectByValue(value);
    }

    public void selectByVisibleText(String text) {
        publishEvent(String.format("selecting option with text [%s]", text));
        delegate().selectByVisibleText(text);
    }

    public void selectByPartialText(String text) {
        publishEvent(String.format("selecting option with text[%s]", text));
        findFragment(By.xpath(String.format("./option[contains(text(), '%s')]", text))).jsClick();
    }
}
