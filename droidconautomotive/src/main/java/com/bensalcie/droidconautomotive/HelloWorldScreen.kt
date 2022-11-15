package com.bensalcie.droidconautomotive

import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.*


class HelloWorldScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        // Create simple row instance, supply the necessary data.
        val row1 = Row.Builder().setTitle("Raadio Duo").addText("Terviseminutid..")
            .setImage(CarIcon.APP_ICON)
            .build()


        val row2 = Row.Builder().setTitle("My Hits").addText("Robin Schulz feat.")
            .setImage(CarIcon.APP_ICON)
            .build()

        val row3 = Row.Builder().setTitle("Elmar").addText("Ott Lepland...")
            .setImage(CarIcon.APP_ICON)
            .build()

        val row4 = Row.Builder().setTitle("Elmar1 ").addText("Ott Leplandi...")
            .setImage(CarIcon.APP_ICON)
            .build()




        //Creaye a panel instance
        val pane = Pane.Builder()

        // Add them to a panel Builder. (Responsible for rendering the row items)

        pane.addRow(row1)
        pane.addRow(row2)
        pane.addRow(row3)
        pane.addRow(row4)









        // Return an instance of the Panel template with the corresponding rows.
        return PaneTemplate.Builder(pane.build()).setTitle("My Radios")
            .build()
    }
}