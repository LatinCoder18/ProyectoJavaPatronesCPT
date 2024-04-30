package Browser;

import java.util.ArrayList;
import java.util.List;

public class BrowserCache {
    private static BrowserCache instance;
    private List<String> searchHistory;

    private BrowserCache() {
        this.searchHistory = new ArrayList<>();
    }

    public static BrowserCache getInstance() {
        if (instance == null) {
            instance = new BrowserCache();
        }
        return instance;
    }

    public void addToHistory(String search) {
        searchHistory.add(search);
    }

    public boolean isSearchOnHistory(String search){
        System.out.println("Cache: Realizando búsqueda previa antes de llamar a BrowserEngine");
        for(int i = 0; i<= searchHistory.size(); i++){
            if (searchHistory.get(i).equals(search)) return true;
        }
        return false;
    }

    public List<String> getSearchHistory() {
        return searchHistory;
    }
}