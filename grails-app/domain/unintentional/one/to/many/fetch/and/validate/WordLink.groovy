package unintentional.one.to.many.fetch.and.validate

class WordLink {

  static hasMany = [words: Word]
  static belongsTo = Word
  Author author //reference back to the author

    static constraints = {
    }

  static mapping = {
    words joinTable:'WORD_LINK_JOIN', cascade: 'all'
  }

  String toString() {
    "${words.first()} -- ${words.last()}"
  }
}
