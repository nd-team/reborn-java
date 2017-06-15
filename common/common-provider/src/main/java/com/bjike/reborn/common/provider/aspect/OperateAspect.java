package com.bjike.reborn.common.provider.aspect;

import com.bjike.reborn.common.provider.kafka.KafkaProducer;
import com.bjike.reborn.common.provider.utils.RpcTransmit;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @Author: [liguiqin]
 * @Date: [2017-06-14 14:48]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Aspect
public class OperateAspect {

    @Resource
    private KafkaProducer producer;

    private final static Logger log = Logger.getLogger(OperateAspect.class);

    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点

    @Pointcut("execution(* com.bjike.reborn.*.api..*(..))")
    public void pointcut() {
    }

    /*
     * 配置前置通知,使用在方法aspect()上注册的切入点
     * 同时接受JoinPoint切入点对象,可以没有该参数
     */


    //配置环绕通知,使用在方法aspect()上注册的切入点
    @Around("pointcut()")
    public Object around(JoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint
                .getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();//获取参数值
        String modules = joinPoint.getTarget().getClass().getName();
        modules = StringUtils.substringAfter(modules, "com.bjike.reborn.");
        modules = StringUtils.substringBefore(modules, ".api");
        Operate operate = method.getAnnotation(Operate.class);
        if (null != operate) {
            String token = RpcTransmit.getUserToken();
            Log log = new Log();
            log.setContent(operate.name());
            log.setModules(modules);
            log.setToken(token);
            String ip = RpcTransmit.getUserIP();
            log.setIp(ip);
            producer.produce(log);
            RpcTransmit.transmitUserToken(token);
        }
        return ((ProceedingJoinPoint) joinPoint).proceed(args);
    }

    //配置抛出异常后通知,使用在方法aspect()上注册的切入点
    @AfterThrowing(pointcut = "pointcut()", throwing = "ex")
    public void afterThrow(JoinPoint joinPoint, Exception ex) {
        if (log.isInfoEnabled()) {
            log.info("afterThrow " + joinPoint + "\t" + ex.getMessage());
        }
    }
}
