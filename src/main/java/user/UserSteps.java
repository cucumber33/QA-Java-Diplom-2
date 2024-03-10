package user;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Endpoints;

import static io.restassured.RestAssured.given;

public class UserSteps {

    public static RequestSpecification requestSpec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(Endpoints.BASE_URL);
    }

    @Step("Регистрация нового пользователя")
    public Response userCreate(User user) {
        return requestSpec()
                .body(user)
                .post(Endpoints.REGISTER);
    }

    @Step("Удаление профиля пользователя")
    public void userDelete(String token) {
        requestSpec()
                .header("Authorization", token)
                .delete(Endpoints.USER);
    }

    @Step("Изменение профиля пользователя")
    public Response userProfileChanging(User newUser, String token) {
        return requestSpec()
                .header("Authorization", token)
                .body(newUser)
                .patch(Endpoints.USER);
    }

    @Step("Авторизация пользователя по логину")
    public Response userLogin(User user) {
        return requestSpec()
                .body(user)
                .post(Endpoints.LOGIN);
    }

    @Step("Авторизация пользователя по логину и токену")
    public Response userLoginToken(User user, String token) {
        return requestSpec()
                .header("Authorization", token)
                .body(user)
                .post(Endpoints.LOGIN);
    }
}
