package unintentional.one.to.many.fetch.and.validate

class BootStrap {

    def init = { servletContext ->
        def auhtor = new Author(name: 'name').save()

        3.times {
            new Book(title: 'title', author: auhtor).save()
        }
    }

    def destroy = {
    }
}
