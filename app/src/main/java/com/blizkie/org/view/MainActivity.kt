package com.blizkie.org.view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blizkie.org.model.getDataModel
import com.blizkie.org.presenter.MainActivityPresenter
import com.blizkie.org.adapter.PartyRecyclerAdapter
import com.party.org.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    private var adapter: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar_app)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar_app.navigationIcon = getDrawable(R.drawable.arrow_left)

        // started the MVP
        val mMainActivityPresenter = MainActivityPresenter(this)
        mMainActivityPresenter.fillElements() // заполняем элементы layout из JsonData
        mMainActivityPresenter.getQuestsList() // получаем и заполняем список RecycleView
    }

    /**
     * Заполнение layout данными из объекта данных JSON
     */
    override fun fillLayout(mGetDataModel: getDataModel) {
        val mGetData = mGetDataModel.getJsonData(this)
        if (mGetData != null) {
            supportActionBar?.title = mGetData.title // Устанавливаем title в toolbar

            // Загружаем banner в header
            Picasso
                .get()
                .load(mGetData.headerBanner)
                .into(header_banner)

            // Загружаем Logo и имя Именника(цы)
            Picasso
                .get()
                .load(mGetData.photoInventer)
                .placeholder(R.drawable.account)
                .error(R.drawable.account)
                .resize(150,150)
                .into(avatar_inventer)

            name_inventer.text = mGetData.nameInventer
            user_initiator.text = "Пригласил(а): "+mGetData.userInitiator
        }
    }

    /**
     * выводим список приглашенных гостей RecycleView
     */
    override fun displayGuests(mGetDataModel: getDataModel) {
        val mGetData = mGetDataModel.getJsonData(this)

        val recycle = recycler as RecyclerView
        recycle.layoutManager = LinearLayoutManager(this)

        adapter = mGetData?.let { PartyRecyclerAdapter(it.guests) }
        recycle.adapter = adapter
    }

    /**
     * обработка нажатия на кнопку "шаг назад"
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                doSomething()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun doSomething() {
        Toast.makeText(this, "Нажата кнопка назад", Toast.LENGTH_LONG).show()
    }

}