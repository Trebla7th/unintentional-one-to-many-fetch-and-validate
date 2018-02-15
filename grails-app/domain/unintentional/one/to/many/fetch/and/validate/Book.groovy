package unintentional.one.to.many.fetch.and.validate

class Book {
    String title
    static belongsTo = [author: Author]
  static hasMany = [words:Word]

  static constraints = {
    title(validator: {val, obj ->
      println("Validating ${val}")
      return true
    })
  }

  String toString() {
    title
  }
}
