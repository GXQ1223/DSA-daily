class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        int n = recipes.length;
        
        Set<String> availability = new HashSet<>();
        for (String s : supplies) {
            availability.add(s);
        }

        Map<String, Integer> recipeToIndex = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            recipeToIndex.put(recipes[i], i);
        }
        
        boolean[] visited = new boolean[n];
        for (String recipe : recipes) {
            if (checkRecipe(recipe, recipeToIndex, ingredients, availability, visited)) {
                res.add(recipe);
            }
        }
        
        return res;
    }

    private boolean checkRecipe(String recipe, Map<String, Integer> recipeToIndex,
                                List<List<String>> ingredients, Set<String> availability, boolean[] visited) {
        if (availability.contains(recipe)) {
            return true;
        }

        if (!recipeToIndex.containsKey(recipe) || visited[recipeToIndex.get(recipe)]) {
            return false;
        }
        int i = recipeToIndex.get(recipe);
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        for (String ingre : ingredients.get(i)) {
            if (!checkRecipe(ingre, recipeToIndex, ingredients, availability, visited)) {
                return false;
            }
        }

        availability.add(recipe);
        return true;
    }
}