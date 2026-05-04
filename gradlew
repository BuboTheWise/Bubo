#!/bin/sh
exec /usr/lib/jvm/java-17-openjdk/bin/java -Dfile.encoding=UTF-8 -classpath gradle/wrapper/gradle-wrapper.jar org.gradle.wrapper.GradleWrapperMain $@
