@Aspect: Marks a class as an aspect, which contains advice and pointcut expressions.

@Before: Specifies a method to be executed before a join point, serving as a "before advice".

@After: Specifies a method to be executed after a join point, serving as an "after advice".

@AfterReturning: Specifies a method to be executed after a join point successfully completes, serving as an "after-returning advice".

@AfterThrowing: Specifies a method to be executed after a join point throws an exception, serving as an "after-throwing advice".

@Around: Wraps around a join point, allowing for custom behavior before and after the join point. It serves as "around advice".

@Pointcut: Defines a reusable pointcut expression, which is a condition that determines where advice should be applied.

@DeclareParents: Introduces additional interfaces to a class dynamically at runtime.

@EnableAspectJAutoProxy: Enables support for using AspectJ annotations and enables the creation of proxy-based AOP proxies.

@Order: Specifies the order of execution for multiple aspects when applied to the same join point.