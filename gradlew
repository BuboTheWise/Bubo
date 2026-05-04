#!/bin/sh
export JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
export ANDROID_HOME="$HOME/android-sdk"
export PATH="$PATH:$HOME/android-sdk/cmdline-tools/latest/bin:$HOME/android-sdk/platform-tools"
cd "$WORKSPACE"
exec "$JAVA_HOME/bin/java" -classpath "gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
