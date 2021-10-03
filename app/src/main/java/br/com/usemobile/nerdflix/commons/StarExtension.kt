package br.com.usemobile.nerdflix.commons

import br.com.usemobile.nerdflix.network.model.ActorRequest
import br.com.usemobile.nerdflix.network.model.Star

fun Star.getImage(actorList: List<ActorRequest>) {
    var currentStar: Star

    actorList.forEach {
        if (this.id == it.id) {
            this.image = it.pathImage
        }
    }
}