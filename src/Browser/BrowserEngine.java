package Browser;
import Browser.BrowserGlobalLogger;

import static java.lang.StringTemplate.STR;

public class BrowserEngine implements QuickSearch{
    private String name;
    private Boolean isPrivateModeEnabled = Boolean.FALSE;
    private String profileName;
    private Boolean isPasswordProtected;

    private String password;

    private BrowserGlobalLogger browserGlobalLogger;

    public BrowserEngine(String name, Boolean isPrivateModeEnabled, String profileName, Boolean isPasswordProtected,String password) {
        this.name = name;
        this.isPrivateModeEnabled = isPrivateModeEnabled;
        this.profileName = profileName;
        this.isPasswordProtected = isPasswordProtected;
        this.password = password;
        this.browserGlobalLogger = BrowserGlobalLogger.getInstance();
    }
@Override
    public void searchWord(String param){
        System.out.println(STR."Browser Word \{param}");
        browserGlobalLogger.logInfo("OK");
    }
    @Override
    public void searchImage(String name){
        System.out.println(STR."Browser Image\{name}");
    }

    public static class Builder {
        private String name;
        private Boolean isPrivateModeEnabled;
        private String profileName;
        private Boolean isPasswordProtected;
        private String password;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setPrivateModeEnabled(Boolean isPrivateModeEnabled) {
            this.isPrivateModeEnabled = isPrivateModeEnabled;
            return this;
        }

        public Builder setProfileName(String profileName) {
            this.profileName = profileName;
            return this;
        }

        public Builder setPasswordProtected(Boolean isPasswordProtected) {
            this.isPasswordProtected = isPasswordProtected;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public BrowserEngine build() {
            return new BrowserEngine(name, isPrivateModeEnabled, profileName, isPasswordProtected, password);
        }
    }
}
