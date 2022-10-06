package starter.dummyjson.API.UsersAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetAllUsersApi {

    public static String URl = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static String GET_ALL_USER = URl + "/users";
    public static String GET_ALL_USER_INVALID_1 = URl +"/userss";
    public static String GET_ALL_USER_INVALID_2 = URl +"/usersZZZZZZZZ";
    public static String GET_ALL_USER_INVALID_3 = URl +"/users{number}";
    public static String GET_ALL_USER_INVALID_3_NUMBERS = URl +"/users{numbers}";
    public static String GET_ALL_USER_INVALID_3_CHARACTERS = URl +"/users{characters}";
    public static String GET_SINGLE_USER = URl +"/users/{id}";
    public static String GET_SINGLE_USER_CHARACTER = URl +"/users/{letter}";
    public static final String JSON_SCHEMA_GET_ALL_USER = DIR + "/src/test/resources/JSON.SchemaValidator.Users";









    @Step ("Get All User")
    public void getAllUser () {SerenityRest.given();}

    @Step ("Get All User Invalid ")
    public void getAllUserInvalid () {SerenityRest.given();}

    @Step ("Get All user invalid adding number")
    public void getAllUserInvalidAddingNumber (int number) {SerenityRest.given()
            .pathParam("number", number);}

    @Step ("Get All user invalid adding numbers")
    public void getAllUserInvalidAddingNumbers (int numbers) {SerenityRest.given()
            .pathParam("numbers", numbers);}

    @Step ("Get all users invalid with special characters")
    public void getAllUsersInvalidWithSpecialCharacters (String characters) {SerenityRest.given()
            .pathParam("characters", characters);}

    @Step ("Get single user")
    public void getSingleUSer (int id) {SerenityRest.given()
            .pathParam("id", id);}


    @Step ("Get single user decimal")
    public void getSingleUSerDecimal (float id) {SerenityRest.given()
            .pathParam("id", id);}

    @Step ("Get single user invalid using letters")
    public void getSingleUSerInvalidUsingLetters (String letter) {SerenityRest.given()
            .pathParam("letter", letter);}


}
