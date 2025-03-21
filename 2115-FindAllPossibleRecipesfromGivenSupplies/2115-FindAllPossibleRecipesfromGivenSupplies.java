class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String>res = new HashSet<>();
        Set<String>set = new HashSet<>();
        for(String supply: supplies) set.add(supply);
        int sum = 1;
        while(sum > 0){
            sum = 0;
            for(int i = 0; i < recipes.length; i++){
                String recipe = recipes[i];
                boolean all = true;
                for(String ingredient:ingredients.get(i)){
                    if(!set.contains(ingredient)){
                        all = false; break;
                    }
                }
                if(all && !res.contains(recipe)){
                    res.add(recipe);
                    set.add(recipe);
                    sum++;
                } 
            }
        }

        List<String>result = new ArrayList<>();
        for(String s: res)result.add(s);
        
        return result;
    }
}