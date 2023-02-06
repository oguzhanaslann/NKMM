package com.example.nkmm.android.di

import com.example.nkmm.di.sharedDepModule

val androidModules = listOf(
    androidAppModule,
    viewModelModule,
) + sharedDepModule