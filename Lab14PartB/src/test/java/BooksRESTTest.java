import books.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8082);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testDelete() {
        Book book = new Book("123", "Book 1", 20.95, "James Brown");

        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books")
                .then()
                .statusCode(200);
        given()
                .when()
                .delete("/books/123");
        given()
                .when()
                .get("/books")
                .then()
                .contentType(ContentType.JSON)
                .body("books.isbn", hasSize(0));
    }

    @Test
    public void testPost(){
        Book book = new Book("234", "Book 3", 34.75, "Jack Johnson");

        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .when()
                .get("/books")
                .then()
                .contentType(ContentType.JSON)
                .body("books.isbn",hasItems("234"));

        given()
                .when()
                .delete("books/234");
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book("123", "Book 1", 20.95, "James Brown");
        Book updatedBook = new Book("123 Update", "Book 1 Update", 20.95, "James Brown Update");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        given()
                .contentType("application/json")
                .body(updatedBook)
                .when().put("/books/123").then()
                .statusCode(200);

        given()
                .when()
                .get("/books/123 Update")
                .then()
                .statusCode(200)
                .and()
                .body("isbn",equalTo("123 Update"))
                .body("title",equalTo("Book 1 Update"))
                .body("price",equalTo(20.95f))
                .body("author",equalTo("James Brown Update"));

        given()
                .when()
                .delete("books/123");


    }

    @Test
    public void testSearchBooksByAuthor(){
        Book book = new Book("123", "Book 1", 20.95, "James Brown");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .when()
                .get("/books/123")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("author",equalTo("James Brown"));
    }

    @Test
    public void testSearchBooksByAuthor_GetAllIfNull(){
        Book book = new Book("123", "Book 1", 20.95, null);
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .when()
                .get("/books")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("books",hasSize(2));
    }

}
