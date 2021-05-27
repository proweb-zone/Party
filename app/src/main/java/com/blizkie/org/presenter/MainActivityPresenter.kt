package com.blizkie.org.presenter

import com.blizkie.org.model.getDataModel


class MainActivityPresenter(view: View) {

    private var view: View = view
    private val mGetDataModel = getDataModel() // объявляем экземпляр класса для работы с данными

    /**
     * Получаем данные из модели и заполняем layout
     */
    fun fillElements() {
        view.fillLayout(mGetDataModel)
    }

    /**
     * Получаем данные Json из модели и заполняем RecycleView List
     */
    fun getQuestsList() {
        view.displayGuests(mGetDataModel)
    }


    interface View {
        fun displayGuests(mGetDataModel: getDataModel)
        fun fillLayout(mGetDataModel: getDataModel)
    }

}