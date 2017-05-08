package com.caiiiyua.bleplayground.injection;

/**
 * Created by pp on 25/01/17.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigPersistent {
}