package ssm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApiControllerAspect {
	
	@Pointcut("execution(* ssm.user.controller.*.*(..))")
	public void controllerAspect(){};
	
	@Before("controllerAspect()")
	public Object requestValidate(JoinPoint joinPoint){
		System.out.println("----------------------------");
		return null;
	}
}
