#!/bin/bash

# Bubo Android App Build and Deploy Script
# Location: /home/bubo/.hermes/workspace/Code/Bubo/build-and-deploy.sh

set -e

echo "=== Bubo Android App Build and Deploy ==="
echo ""

# Set up environment
export JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
export ANDROID_HOME="/home/bubo/android-sdk"
export ANDROID_SDK_ROOT="/home/bubo/android-sdk"
export PATH="/usr/bin:/home/bubo/.npm-global/bin:$HOME/android-sdk/cmdline-tools/latest/bin:$HOME/android-sdk/platform-tools:$PATH"
cd /home/bubo/.hermes/workspace/Code/Bubo

echo "Step 1: Verify project structure"
ls -la

echo ""
echo "Step 2: Fix gradlew script"
cat > gradlew << 'GRADLESCRIPT'
#!/bin/sh
export JAVA_HOME="/usr/lib/jvm/java-17-openjdk"
export PATH="/usr/bin:$HOME/android-sdk/cmdline-tools/latest/bin:$HOME/android-sdk/platform-tools:$PATH"
cd /home/bubo/.hermes/workspace/Code/Bubo
exec "$JAVA_HOME/bin/java" -classpath "gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
GRADLESCRIPT
chmod +x gradlew

echo ""
echo "Step 3: Create settings.gradle"
cat > settings.gradle << 'EOF'
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = 'Bubo'
include ':app'
EOF

echo ""
echo "Step 4: Build the app"
./gradlew clean assembleDebug

echo ""
echo "Step 5: Install to Pixel device"
adb install -r app/build/outputs/apk/debug/app-debug.apk

echo ""
echo "=== Build and Deploy Complete ==="
echo "APK Location: /home/bubo/.hermes/workspace/Code/Bubo/app/build/outputs/apk/debug/app-debug.apk"
echo "App installed on device: Bubo"