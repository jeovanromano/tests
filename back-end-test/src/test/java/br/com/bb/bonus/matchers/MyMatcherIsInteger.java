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
public class MyMatcherIsInteger extends TypeSafeMatcher<Integer> {

	private Integer num;
	
	public MyMatcherIsInteger(Integer num) {
		this.num = num;
	}
	
	@Override
	public void describeTo(Description description) {
		description.appendText("O ID do produto esperado é ==> " + num);
	}

	@Override
	protected boolean matchesSafely(Integer numberParam) {
		return numberParam.equals(num);
	}

}
