/**
 * 
 */
package br.com.bb.bonus.runner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Demonstrtivo de execução paralela dos testes. Ao abrir as threads apontando para os rests, acabam quebrando pela ausencia do contexto
 * 
 * Nas classes de testes ficariam com a anotação:
 * @ RunWith(ParallelRunner.class)
 * 
 * erro: java.lang.IllegalArgumentException: WebApplicationContext is required
 * 
 * 
 * @author Jeovan Romano
 *
 */
public class ParallelRunner extends SpringJUnit4ClassRunner {

	public ParallelRunner(Class<?> klass) throws InitializationError {
		super(klass);
		setScheduler(new ThreadPoll());
	}

	private static class ThreadPoll implements RunnerScheduler {

		private ExecutorService executor;
		
		public ThreadPoll() {
			executor = Executors.newFixedThreadPool(2);
		}
		
		@Override
		public void schedule(Runnable childStatement) {
			executor.submit(childStatement);
		}

		@Override
		public void finished() {
			executor.shutdown();
			try {
				executor.awaitTermination(10, TimeUnit.MINUTES);
			} catch (InterruptedException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
	}
}
