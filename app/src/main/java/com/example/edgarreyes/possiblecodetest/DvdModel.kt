package com.example.edgarreyes.possiblecodetest

import org.json.JSONArray

class DvdModel(var presenter: DvdPresenter): DvdContract.Model{
    private var jsonArray:JSONArray ?= null
    private val webUrl = "http://de-coding-test.s3.amazonaws.com/books.json"

    override fun getDvdData(): JSONArray{
        return jsonArray!!
    }

    override fun loadDvdData() {
        //Assigns  the task of making a network request to a NetworkService
        var s = NetworkService(webUrl, this)
    }

    override fun getLoadedData(jsonArray: JSONArray) {
        this.jsonArray = jsonArray
        presenter.passDvdData(jsonArray)
    }


}