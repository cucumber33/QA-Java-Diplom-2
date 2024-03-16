package ingredients;

import org.example.Endpoints;

import static io.restassured.RestAssured.given;

public class IngredientRequest {

    public static Ingredient[] getIngredientsArray() {
        return getIngredientResponse().getIngredients();
    }

    public static IngredientResponse getIngredientResponse() {
        return given()
                .get(Endpoints.INGREDIENTS)
                .as(IngredientResponse.class);
    }

    public static Ingredient getIngredientFromArray() {
        return getIngredientsArray()[0];
    }
}