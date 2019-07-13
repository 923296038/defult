package onlinetest.testspringdi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao){
        this.bookDao = bookDao;
    }
    @Override
    public void addBook(){
        this.bookDao.save();
    }

    public static void main(String[] args) {
        String xmlPath = "testspringdi.xml";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        BookService bookService =
                (BookService) applicationContext.getBean("bookServiceId");
        //BookService bookService1 = new BookServiceImpl();
        bookService.addBook();
    }
}
