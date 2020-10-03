package ak.www.kursakademiaandroida.features.characters.all.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_character.view.*

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy { mutableListOf<CharacterDisplayable>() }
    lateinit var onCharacterClickListener: (CharacterDisplayable) -> Unit

    fun setCharacters(characters: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_character, parent, false)

        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, onCharacterClickListener)
    }

    override fun getItemCount(): Int = characters.size

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            character: CharacterDisplayable,
            onCharacterClickListener: (CharacterDisplayable) -> Unit
        ) {
            with(itemView) {
                Glide.with(context)
                    .load(character.image)
                    .into(imageView)

                tvName.text = character.name

                setOnClickListener { onCharacterClickListener.invoke(character) }
            }
        }
    }
}