interface MealPlan {
    String getPlanType();
}

class VegetarianMeal implements MealPlan {
    public String getPlanType() {
        return "Vegetarian";
    }
}

class KetoMeal implements MealPlan {
    public String getPlanType() {
        return "Keto";
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void generatePlan() {
        System.out.println("Generated Meal Plan: " + meal.getPlanType());
    }
}

class MealPlanner {
    public static <T extends MealPlan> void validateMeal(T meal) {
        System.out.println("Valid meal type: " + meal.getPlanType());
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());

        vegMeal.generatePlan();
        ketoMeal.generatePlan();

        validateMeal(new VegetarianMeal());
        validateMeal(new KetoMeal());
    }
}
