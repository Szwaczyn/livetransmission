package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectMatchEvent {
	
	@Before("execution(* interfaces.IMatchExecution.beginMatch(..))")
	public void informPreprePizza() {
		System.out.println("PIZZA IS PREPRERD probable");
	}

}
