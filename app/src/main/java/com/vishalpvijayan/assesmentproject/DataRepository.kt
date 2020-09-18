package com.vishalpvijayan.assesmentproject

class DataRepository (
        private val api: DataApi) : HandlingRequest() {
        suspend fun getData() = apiRequest { api.getData(2,20) }
}