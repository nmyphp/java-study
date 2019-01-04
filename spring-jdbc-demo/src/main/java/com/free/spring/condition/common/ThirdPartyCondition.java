package com.free.spring.condition.common;

import com.free.spring.jdbc.demo.common.Constant;
import com.free.spring.jdbc.demo.common.ParentCondition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ThirdPartyCondition extends ParentCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();

        String interfaceName = getInterFaceName(annotatedTypeMetadata);
        String implPrefix = environment.getProperty(interfaceName);
        return Constant.THIRD_PARTY_PREFIX.equals(implPrefix);
    }
}
