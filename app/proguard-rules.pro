# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/pp/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Add this global rule
-keepattributes Signature
-keepattributes InnerClasses

# This rule will properly ProGuard all the model classes in
# the package com.yourcompany.models. Modify to fit the structure
# of your app.
-keepclassmembers class com.caiiiyua.timeline2nz.data.local.** {
    *;
}

# Wx open sdk
-keep class com.tencent.mm.opensdk.modelmsg.SendMessageToWX {
    *;
}
-keep class com.tencent.mm.opensdk.modelmsg.WXMediaMessage {
    *;
}
-keep class com.tencent.mm.opensdk.modelmsg.WXWebpageObject { *; }
-keep class com.tencent.mm.opensdk.openapi.IWXAPI { *; }
-keep class com.tencent.mm.opensdk.openapi.WXAPIFactory { *; }

-keep class com.tencent.mm.opensdk.** {
   *;
}
-keep class com.tencent.wxop.** {
   *;
}
-keep class com.tencent.mm.sdk.** {
   *;
}

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

-dontwarn retrofit2.adapter.rxjava.CompletableHelper$**
-dontwarn rx.Completable**

# RxJava rules
# RxAndroid will soon ship with rules so this may not be needed in the future
# https://github.com/ReactiveX/RxAndroid/issues/219
-dontwarn sun.misc.Unsafe
-keep class rx.internal.util.unsafe.** { *; }

-keep class javax.inject.** { *; }
-keep class javax.annotation.** { *; }

-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

-keep class rx.**

# Dagger
-dontwarn dagger.producers.monitoring.internal.**

# Java
-dontwarn java.lang.invoke.**

# ButterKnife rules
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

## GSON 2.2.4 specific rules ##

# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
# For using GSON @Expose annotation
-keepattributes *Annotation*

-keepattributes EnclosingMethod

# GMS
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**

# Jodatime
-dontwarn org.joda.convert.**
-dontwarn org.joda.time.**
-keep class org.joda.time.** { *; }
-keep interface org.joda.time.** { *; }

# T2NZ
-keep class com.caiiiyua.timeline2nz.data.** { *; }
-keep class com.caiiiyua.timeline2nz.injection.** { *; }
-keep class com.caiiiyua.timeline2nz.ui.** { *; }
-keep class com.caiiiyua.timeline2nz.utils.** { *; }
-keep class com.caiiiyua.timeline2nz.TimeLineApplication { *; }