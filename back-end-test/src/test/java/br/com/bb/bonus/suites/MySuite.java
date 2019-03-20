package br.com.bb.bonus.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.bb.bonus.tests.BonusTest;
import br.com.bb.controller.CategoryControllerTest;
import br.com.bb.controller.ProductControllerTest;

//@RunWith(Suite.class)
//@SuiteClasses({
//	BonusTest.class,
//	CategoryControllerTest.class,
//	ProductControllerTest.class
//})
public class MySuite {
	
	// Apenas demonstrativo
	// Bateria de testes.
	// Não necessário, pois o rodar os testes selecionando o package, irá surtir o mesmo efeito
	// as suites serão executadas novamente nas ferramentas que encontrarem os testes na integração.
	
}
