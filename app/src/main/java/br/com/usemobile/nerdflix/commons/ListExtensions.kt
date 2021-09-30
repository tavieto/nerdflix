package br.com.usemobile.nerdflix.commons

import br.com.usemobile.nerdflix.network.model.Star

fun List<Star>.toModel(): String {
    var stringStars = this[0].name
    var counter = 1

    while (counter < this.size) {
        stringStars += " - ${this[counter].name}"
        counter++
    }

    return stringStars
}