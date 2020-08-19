package ak.www.kursakademiaandroida.mock

import ak.www.kursakademiaandroida.core.api.model.*
import ak.www.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import ak.www.kursakademiaandroida.features.characters.data.local.model.CharacterLocationCached
import ak.www.kursakademiaandroida.features.characters.data.local.model.CharacterOriginCached
import ak.www.kursakademiaandroida.features.data.remote.model.CharacterLocationRemote
import ak.www.kursakademiaandroida.features.data.remote.model.CharacterOriginRemote
import ak.www.kursakademiaandroida.features.data.remote.model.CharacterRemote
import ak.www.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import ak.www.kursakademiaandroida.features.locations.data.local.model.LocationCached
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

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimensions",
    residents = emptyList(),
    url = "location url",
    created = "example data"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimensions",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun CharacterOriginRemote.Companion.mock() = CharacterOriginRemote(
    name = "character origin name",
    url = "character origin url"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "character location name",
    url = "character location url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    characterOriginRemote = CharacterOriginRemote.mock(),
    characterLocationRemote = CharacterLocationRemote.mock(),
    image = "character image",
    episode = emptyList(),
    url = "character url",
    created = "example data"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterOriginCached.Companion.mock() = CharacterOriginCached(
    originName = "character origin name",
    originUrl = "character origin url"
)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    locationName = "character location name",
    locationUrl = "character location url"
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    characterOriginCached = CharacterOriginCached.mock(),
    characterLocationCached = CharacterLocationCached.mock(),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)