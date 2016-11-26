package com.scaffold.core.aop.tx;

/**
 * Spring AOP在同一个类里自身方法相互调用时无法拦截。例如同一个类中有methodA和methodB,两个方法经过AOP代理,执行时都实现系统日志记录。单独使用methodA或methodB时，没有任何问题。
 * 但如果在methodA中调用methodB,methodA里调用的methodB方法是原始的，未经过AOP增强的。 期望调用一次methodA会记录下两条系统日志
 * ，分别是methodA和methodB的，但实际上只能记录下methodA的日志，也就是只有一条。在配置事务时也可能会出现问题，比如methodA方法是REQUIRED
 * ，methodB方法是REQUIRES_NEW，methodB的配置将不起作用，与methodA方法会使用同一个事务，不会按照所配置的打开新事务。
 * 出现这种特殊情况时，不要直接调用自身方法，而通过AOP代理后的对象。在实现里保留一个AOP代理对象的引用，调用时通过这个代理即可
 * 
 */
public interface ISelfInject {

	/**
	 * 解决Spring AOP在同一个类里自身方法相互调用时无法拦截问题
	 * 
	 * @param bean
	 */
	public void setSelf(Object bean);
}
