/**
 * 
 */
package br.com.bb.bonus.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author Jeovan Romano
 *
 */
public class MyMatcherIsString extends TypeSafeMatcher<String> {

	private String string;
	
	public MyMatcherIsString(String string) {
		this.string = string;
	}
	
	@Override
	public void describeTo(Description description) {
		description.appendText("O nome do produto esperado é ==> " + string);
	}

	@Override
	protected boolean matchesSafely(String stringParam) {
		return stringParam.equals(string);
	}

}
