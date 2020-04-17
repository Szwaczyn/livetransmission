package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectMatchEvent {
	
	@Before("execution(* interfaces.IMatchExecution.beginMatch(..))")
	public void informPreprePizza() {
		System.out.println("PIZZA IS PREPRERD probable");
	}

}
