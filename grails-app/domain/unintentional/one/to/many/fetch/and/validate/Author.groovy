package unintentional.one.to.many.fetch.and.validate

class Author {
    String name

    static hasMany = [books: Book]

    static mapping = {
        books cascade: 'all-delete-orphan'
    }
}
