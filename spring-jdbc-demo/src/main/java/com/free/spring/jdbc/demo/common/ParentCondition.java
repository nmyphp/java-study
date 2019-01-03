package com.free.spring.jdbc.demo.common;

import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;

public class ParentCondition {
    protected String getInterFaceName(AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (annotatedTypeMetadata instanceof ClassMetadata) {
            String[] interfaceNames = ((ClassMetadata) annotatedTypeMetadata).getInterfaceNames();
            if (interfaceNames.length > 0) {
                return interfaceNames[0];
            }
        }

        return ((MethodMetadata)annotatedTypeMetadata).getDeclaringClassName();
    }
}
