package unintentional.one.to.many.fetch.and.validate

class Word {

  String value
  String type //authorWord or bookWord

  Author author

  static hasMany = [wordLinks:WordLink]

    static constraints = {
    }

  static mapping = {
    wordLinks joinTable:'WORD_LINK_JOIN', cascade: 'all'
  }

  String toString() { value}
}
