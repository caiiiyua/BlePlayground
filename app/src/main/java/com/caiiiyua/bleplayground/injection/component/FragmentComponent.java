package com.caiiiyua.bleplayground.injection.component;

/**
 * Created by stu on 27/12/16.
 */


import com.caiiiyua.bleplayground.injection.PerFragment;
import com.caiiiyua.bleplayground.injection.module.FragmentModule;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}