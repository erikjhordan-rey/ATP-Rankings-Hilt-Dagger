package io.github.erikjhordanrey.atp_rankings_di.di

import android.app.Activity
import android.app.Application
import android.content.Context

class App : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    companion object {

        @JvmStatic
        fun appComponent(context: Context) = (context.applicationContext as App).appComponent
    }

}
fun Activity.appComponent() = App.appComponent(this)
