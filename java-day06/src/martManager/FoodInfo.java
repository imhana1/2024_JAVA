package martManager;

import java.util.ArrayList;

public class FoodInfo extends ProductInfo{
    private ArrayList<String> ingredient;

    public String getIngredient(int i) {
        return ingredient.get(i);
    }

    public void setIngredient(String ingredient) {
        this.ingredient.add(ingredient);
    }
}
