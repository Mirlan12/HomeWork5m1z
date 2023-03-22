package com.example.homework5m1z

import android.graphics.Color

class Presenter {

    var model = CounterModel()
    lateinit var view: CounterView

    fun incrementCount() {
        model.increment()
        view.updateText(model.count.toString())

        if (model.count == 10){
            view.showToast("God!")
        }
        if (model.count == 15)
            view.showColor(Color.GREEN)

    }

    fun decrementCount() {
        model.decrement()
        view.updateText(model.count.toString())

        if (model.count <= -15){
            view.showColor(Color.RED)
        }

    }
    fun attachView(view: CounterView){
        this.view = view
    }
}