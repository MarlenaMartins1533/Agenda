package com.marlena.agenda.scenes.aboutUs

import com.marlena.agenda.service.WeatherClient
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class AboutPresenter(val view: About.View): About.Presenter, CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null

    override fun requestMessage() {
        view.showMessage("Message!")
    }

    override fun getWeather() {
        job = launch {
            val lat = "-12.9704"
            val long = "-38.5124"

            val bodyWeather = withContext(Dispatchers.IO){ WeatherClient.instance.getCurrentWeatherData(lat, long) } //if withContext has problem about suspend something, then need job=launch
            val response = "Weather today ${bodyWeather?.name}"

            view.showMessage(response)
        }
    }

    override fun kill(){
        job?.cancel()
    }
}
