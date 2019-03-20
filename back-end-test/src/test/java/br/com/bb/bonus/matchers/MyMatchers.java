/**
 * 
 */
package br.com.bb.bonus.matchers;

/**
 * @author Jeovan Romano
 *
 */
public class MyMatchers {
	
	public static MyMatcherIsInteger myIsInt(Integer num) {
		return new MyMatcherIsInteger(num);
	}
	
	public static MyMatcherIsString myIsString(String string) {
		return new MyMatcherIsString(string);
	}

}
