package io.github.erikjhordanrey.atp_rankings_di.di

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.util.TypedValue




class App : Application() {

    override fun onCreate() {
        super.onCreate()

    }

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    companion object {

        @JvmStatic
        fun appComponent(context: Context) = (context.applicationContext as App).appComponent
    }

}
fun Activity.appComponent() = App.appComponent(this)

fun getColorByThemeAttr(context: Context, attr: Int, defaultColor: Int): Int {
    val typedValue = TypedValue()
    val theme: Resources.Theme = context.theme
    val got: Boolean = theme.resolveAttribute(attr, typedValue, true)
    return if (got) typedValue.data else defaultColor
}
