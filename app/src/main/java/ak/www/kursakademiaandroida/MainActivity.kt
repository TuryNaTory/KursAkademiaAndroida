package ak.www.kursakademiaandroida

import ak.www.kursakademiaandroida.features.characters.presentation.CharacterFragment
import ak.www.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import ak.www.kursakademiaandroida.features.locations.presentation.LocationFragment
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val episodeFragment: EpisodeFragment by inject()
    private val locationFragment: LocationFragment by inject()
    private val characterFragment: CharacterFragment by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //   supportFragmentManager.beginTransaction().add(R.id.container, episodeFragment)
        //       .commit()
        //   supportFragmentManager.beginTransaction().add(R.id.container, locationFragment)
        //       .commit()
        supportFragmentManager.beginTransaction().add(R.id.container, characterFragment)
            .commit()
    }

    fun showProgressBar(enable: Boolean) {
        if (enable) {
            progressBar.visibility = View.VISIBLE
            container.visibility = View.GONE
        } else {
            progressBar.visibility = View.GONE
            container.visibility = View.VISIBLE
        }
    }
}