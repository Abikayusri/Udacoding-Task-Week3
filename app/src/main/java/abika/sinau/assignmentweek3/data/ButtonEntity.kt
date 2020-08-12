package abika.sinau.assignmentweek3.data

import abika.sinau.assignmentweek3.model.Button

/**
 * Created by Abika Chairul Yusri
 * on Wednesday, 12 August 2020
 * Bismillahirrahmanirrahim
 */
class ButtonEntity {
    companion object {
        val button: List<Any>
        get() = mutableListOf(
            Button("Button","Klik di sini")
        )
    }
}