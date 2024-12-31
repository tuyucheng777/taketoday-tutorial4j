package cn.tuyucheng.taketoday.chooseapi.dtos;

public record Book(String title, Author author, int year) {

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Book book = (Book) o;
      return year == book.year && title.equals(book.title) && author.equals(book.author);
   }
}