package ak.www.kursakademiaandroida.features.episodes.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_episode.view.*

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes by lazy { mutableListOf<EpisodeDisplayable>() }

    fun setEpisodes(episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) {
            this.episodes.clear()
        }

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EpisodeViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_episode, parent, false)

        return EpisodeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EpisodeAdapter.EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    override fun getItemCount(): Int = episodes.size

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(episode: EpisodeDisplayable) {
            with(itemView) {
                tvName.text = episode.name
                tvAirDate.text = episode.airDate
                tvCode.text = episode.code
            }
        }
    }
}