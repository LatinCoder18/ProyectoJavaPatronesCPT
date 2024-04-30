package Browser;
public class BrowserEngineProxy implements QuickSearch {
    private BrowserEngine browserEngine;
    private BrowserCache browserCache;

    public BrowserEngineProxy(String name, Boolean isPrivateModeEnabled, String profileName, Boolean isPasswordProtected, String password) {
        this.browserEngine = new BrowserEngine.Builder("Firefox")
                .setPrivateModeEnabled(true)
                .setProfileName("Estudiante")
                .setPasswordProtected(true)
                .setPassword("Estudiante24_")
                .build();
        this.browserCache = BrowserCache.getInstance();
    }

    @Override
    public void searchWord(String param) {
        System.out.println("Proxy: Realizando búsqueda en cache antes de llamar a BrowserEngine");
        if (!browserCache.isSearchOnHistory(param)) {
            browserCache.addToHistory(param);
            browserEngine.searchWord(param);
        }
        else {
            System.out.println(STR."Obteniendo busqueda desde el Historial: \{param}");
        }
    }

    @Override
    public void searchImage(String name) {
        System.out.println("Proxy: Realizando operación de búsqueda de imagen");
        browserCache.addToHistory(name);
        browserEngine.searchImage(name);
    }
}