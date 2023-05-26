//package org.example;
//
//import com.oracle.svm.core.annotate.Substitute;
//import com.oracle.svm.core.annotate.TargetClass;
//
//@TargetClass(className = "io.netty.util.internal.logging.InternalLoggerFactory")
//final class Target_io_netty_util_internal_logging_InternalLoggerFactory {
//
//    @Substitute
//    private static InternalLoggerFactory newDefaultFactory(String name) {
//        return JdkLoggerFactory.INSTANCE;
//    }
//}