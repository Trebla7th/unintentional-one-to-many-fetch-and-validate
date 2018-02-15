package unintentional.one.to.many.fetch.and.validate

class IndexController {

    def index(String suffix) {
//        def author = Author.first()
//        author.name = 'new-name'
//        author.save(flush: true)


      //End of nominal case

      suffix = suffix ?: UUID.randomUUID().toString().substring(32)

      Author a1 = new Author(name:"TheAuthor-${suffix}")
      a1.save()

      Book b1 = new Book(title:  "Book1-${suffix}", author: a1)
      b1.save()
      println("Book1 properties: ${b1.properties + ['id':b1.id, 'version':b1.version]}")

      Book b2 = new Book(title: "Book2-${suffix}", author:a1)
      b2.save()

      a1.addToBooks(b1)
      a1.addToBooks(b2)

      a1.save(flush:true)

      println("All books: ${Book.list()}")

      //Now the words
      Word w1 = new Word(value: "AuthorWord", author: a1, type: "Author")
      w1.save(flush:true, failOnError: true)
      a1.addToWords(w1)

      Word w2 = new Word(value: "AuthorWord2", author: a1, type:"Author")
      w2.save()
      a1.addToWords(w2)
      a1.save()

      println("Author ${a1} words - ${a1.words}\n\n\n\n")


      Word w11 = new Word(value: "bookWord", author: a1, type: "Book")
      w11.save()
      b1.addToWords(w11)
      b1.save()
      Word w12 = new Word(value: "bookWord222", author: a1, type: "Book")
      w12.save()
      b1.addToWords(w12)
      b1.save()
      a1.save(flush:true)


      println("\n\n\nAll basic objects created, now linking words")

      WordLink link1 = new WordLink(author: a1)
      link1.addToWords(w1)
      link1.addToWords(w11)
      link1.save()
//      a1.save()

      println("link 1 saved")

      WordLink link2 = new WordLink(author: a1)
      link2.addToWords(w2)
      link2.addToWords(w12)
      link2.save()
//      a1.save()


      render "${a1} books - ${a1.books}"
    }
}
