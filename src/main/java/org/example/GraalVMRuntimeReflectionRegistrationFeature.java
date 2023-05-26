package org.example;

import com.oracle.svm.core.feature.AutomaticallyRegisteredFeature;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

import java.util.List;

public class GraalVMRuntimeReflectionRegistrationFeature implements Feature {

    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        try {

           // The classes which  make "New Method or Constructor found as reachable after static analysis" error
            var classes = List.of(
                    Class.forName("jdk.internal.foreign.abi.UpcallLinker$CallRegs"),Class.forName("jdk.internal.reflect.ReflectionFactory$Config"));

            for (var eachClass : classes) {
                for (var each : eachClass.getDeclaredFields()) {
                    RuntimeReflection.register(each);
                }
                for (var each : eachClass.getDeclaredMethods()) {
                    RuntimeReflection.register(each);
                }
                for (var each : eachClass.getDeclaredConstructors()) {
                    RuntimeReflection.register(each);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}