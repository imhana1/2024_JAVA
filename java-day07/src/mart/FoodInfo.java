package mart;

import java.util.ArrayList;

public class FoodInfo extends Productinfo{
    private ArrayList<String> ingredient = new ArrayList<>();

    public String getIngredient(int i) {
        return ingredient.get(i);
    }

    public void setIngredient(String ingredient) {
        this.ingredient.add(ingredient);
    }
}
