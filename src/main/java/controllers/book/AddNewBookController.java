package controllers.book;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Book;
import service.book.BookService;
import validators.BookValidator;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Vadim on 14.03.2017.
 */
public class AddNewBookController implements Initializable {
    @FXML
    private Button btnOk, btnCancel;
    @FXML
    private TextField tfBookTitle, tfBookEdition, tfBookAuthor, tfYearOfPublication;
    @FXML
    private AnchorPane apAddNewBook;

    BookValidator bookValidator = new BookValidator();
    BookService bookService = new BookService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBtnOkListener();
        setBtnCancelListener();
    }

    private void setBtnOkListener() {
        btnOk.setOnAction(event -> {

            Book book = new Book(tfBookTitle.getText(), tfBookAuthor.getText(),
                    tfBookEdition.getText(), tfYearOfPublication.getText());
            if (bookValidator.checkAllTextField(book)) {
                bookService.saveBook(book);
                getStage().close();
            }
        });
    }

    private void setBtnCancelListener() {
        btnCancel.setOnAction(event -> {
            getStage().close();
        });
    }

    private Stage getStage() {
        return ((Stage) apAddNewBook.getScene().getWindow());
    }


}
