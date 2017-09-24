package unintentional.one.to.many.fetch.and.validate

class Book {
    String title
    static belongsTo = [author: Author]
}
