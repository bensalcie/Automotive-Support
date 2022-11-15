package com.bensalcie.droidconautomotive

import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInstaller

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.car.app.CarAppService
import androidx.car.app.Screen
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator
import androidx.test.core.app.ApplicationProvider


 class HelloWorldService : CarAppService() {
    override fun onCreateSession(): Session {
        return object : Session() {


            /**
             * Requests the first [Screen] for the application.
             *
             *
             * Once the method returns, [Screen.onGetTemplate] will be called on the
             * [Screen] returned, and the app will be displayed on the car screen.
             *
             *
             * To pre-seed a back stack, you can push [Screen]s onto the stack, via [ ][ScreenManager.push] during this method call.
             *
             *
             * Called by the system, do not call this method directly.
             *
             * @param intent the intent that was used to start this app. If the app was started with a
             * call to [CarContext.startCarApp], this intent will be equal to
             * the intent passed to that method
             */
            override fun onCreateScreen(intent: Intent): Screen {
                return HelloWorldScreen(carContext)
            }
        }
    }

    override fun createHostValidator(): HostValidator {
        return if (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE !== 0) {
            HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
        } else {
            HostValidator.Builder(ApplicationProvider.getApplicationContext())
                .addAllowedHosts(R.array.hosts_allowlist_sample)
                .build()
        }
    }
}


