package sh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountAspectImpl {
	@Before("execution (* Account.withdraw(..))")
	public void beforeWithdraw(JoinPoint jpt) {
		// security -- found hack -- email to the account holder
		//Account acc = (Account) jpt.getTarget();
		System.out.println("Before Withdraw(): "+jpt.getArgs()[0]);
	}
	
	@AfterThrowing("execution (* Account.withdraw(..))")
	public void afterWithdrawException(JoinPoint jpt) {
		System.out.println("After Withdraw() Exception: "+jpt.getArgs()[0]);
	}
	
	@After("execution (* Account.set*(..))")
	public void afterSetter(JoinPoint jpt) {
		System.out.println("After :: " + jpt.getSignature());
	}
	
	@Around("execution (* Account.deposit(..))")
	public void aroundDeposit(ProceedingJoinPoint jpt) throws Throwable {
		long start = System.currentTimeMillis();
		Object ret = jpt.proceed();
		long end = System.currentTimeMillis();
		System.out.println("Method : " + jpt.getSignature());
		System.out.println("Return value: " + ret);
		System.out.println("Method execution time: " + (end-start));
	}

	@Pointcut("execution (* Account.withdraw(..)) || execution (* Account.deposit(..))")
	public void depositAndWithdraw() {}
	
	@After("depositAndWithdraw()")
	public void afterTransaction(JoinPoint jpt) {
		System.out.println("After ::: " + jpt.getSignature());
	}
}




