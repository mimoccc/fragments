package com.astound.fragments.pages;

import com.astound.fragments.FragmentContext;
import com.astound.fragments.FragmentFactory;
import com.astound.fragments.elements.Fragment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage implements FragmentContext {

	private final FragmentContext context;

	public BasePage(WebDriver webDriver) {
		FragmentFactory fragmentFactory = new FragmentFactory((JavascriptExecutor) webDriver);
		context = fragmentFactory.createNamedArea(webDriver, getClass().getSuperclass().getName());
		fragmentFactory.initFragmentsIn(this);
	}

	public String getName() {return context.getName();}

	public Fragment findFragment(By by) {return context.findFragment(by);}

	public List<Fragment> findFragments(By by) {return context.findFragments(by);}

	public <E extends Fragment> E findFragment(By by, Class<E> aClass) {return context.findFragment(by, aClass);}

	public <E extends Fragment> List<E> findFragments(By by, Class<E> aClass) {return context.findFragments(by, aClass);}

	public <E extends Fragment> E findFragment(By by, Class<E> aClass, String name) {return context.findFragment(by, aClass, name);}

	public <E extends Fragment> List<E> findFragments(By by, Class<E> aClass, String name) {return context.findFragments(by, aClass, name);}

	public List<WebElement> findElements(By by) {return context.findElements(by);}

	public WebElement findElement(By by) {return context.findElement(by);}

	public Object executeScript(String s, Object... objects) {return context.executeScript(s, objects);}

	public Object executeAsyncScript(String s, Object... objects) {return context.executeAsyncScript(s, objects);}

}
