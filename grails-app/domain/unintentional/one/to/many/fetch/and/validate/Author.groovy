package unintentional.one.to.many.fetch.and.validate

class Author {
    String name

    static hasMany = [books: Book, words:Word]

    static mapping = {
        books cascade: 'all-delete-orphan'
    }

  static constraints = {
    name(validator: {val, obj ->
      println("Validating ${val}")
      return true
    })
  }

  String toString() {
    name
  }
}
