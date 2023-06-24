package org.test;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Handler;

///**
// */
//@TargetClass(className = "org.jboss.logmanager.LoggerNode")
//final class Target_org_jboss_logmanager_LoggerNode {
//
//    @Alias
//    @RecomputeFieldValue(declClass = AtomicReference.class, kind = RecomputeFieldValue.Kind.NewInstance)
//    AtomicReference<Handler[]> handlersRef;
//}

@TargetClass(className = "org.slf4j.LoggerFactory")
final class Target_org_slf4j_LoggerFactory {

    @Substitute
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz.getName());
    }

}
//@TargetClass(className = "jdk.internal.foreign.abi.UpcallLinker")
//final class Target_class {
//
//    @de
//    public static Logger getLogger(Class<?> clazz) {
//        return LoggerFactory.getLogger(clazz.getName());
//    }
//
//}
//
//@TargetClass(java.util.logging.Logger.class)
//final class Target_java_util_logging_Logger {
//    @Substitute
//    static java.util.logging.Logger getLogger(String name) {
//        return LogContext.getLogContext().getLogger(name);
//    }
//
//    @Substitute
//    static java.util.logging.Logger getLogger(String name, String ignored) {
//        return LogContext.getLogContext().getLogger(name);
//    }
//}

final class LoggingSubstitutions {
}
