package unintentional.one.to.many.fetch.and.validate

class IndexController {

    def index() {
        def author = Author.first()
        author.name = 'new-name'
        author.save(flush: true)
        render 'ok'
    }
}
