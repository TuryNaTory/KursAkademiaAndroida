package ak.www.kursakademiaandroida.mock

import ak.www.kursakademiaandroida.core.api.model.EpisodeRemote
import ak.www.kursakademiaandroida.core.api.model.EpisodesResponse
import ak.www.kursakademiaandroida.core.api.model.ResponseInfo
import ak.www.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    characters = emptyList(),
    url = "episode url",
    airDate = "episode air date",
    code = "episode code",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    characters = emptyList(),
    url = "episode url",
    airDate = "episode air date",
    code = "episode code"
)